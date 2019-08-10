package com.accolite.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accolite.pojo.User;

@Controller
public class DatabaseController {

	public static Session getsession() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sessionFactory = con.buildSessionFactory(ssrb.build());
		Session session = sessionFactory.openSession();
		return session;

	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loginPost")
	public String loginPost(HttpServletRequest req, Model m) {
		DatabaseController dc = new DatabaseController();
		Session session = dc.getsession();

		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");

		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("uname", uname));
		List<User> results = cr.list();

		if (results.isEmpty()) {
			m.addAttribute("message", "User does not exist.");
			System.out.println("x exist");
			return "login";
		} else {
			for (User user : results) {
				if ("admin".equals(user.getRole())) {
					System.out.println("Admin");
					return "admin";
				}
				// user account
				else {
					System.out.println("User");
					int noOfWrongAttempts = user.getNoOfWrongAttemps();

					// permanent block
					if (noOfWrongAttempts >= 12) {
						m.addAttribute("message", "Account permanently locked. Contact admin.");
					}

					else if (noOfWrongAttempts > 2 && noOfWrongAttempts % 3 == 0) {
						Date date = new Date();
						long curr_ts = date.getTime();
						long waitTime = (long) (Math.pow(2, noOfWrongAttempts / 3 - 1) * 60 * 1000) * 10;
						// blocking
						if (curr_ts - user.getTs() < waitTime) {
							double toWait = (user.getTs() + waitTime - curr_ts) / 60 / 1000;
							m.addAttribute("message", "Wrong credentials. Account temp blocked. Try after "
									+ Math.round(toWait) + " minutes.");
						} else {
							loginOpr(user, pass, session, tx, m, noOfWrongAttempts);	
						}
					}
					
					else
					{
						loginOpr(user, pass, session, tx, m, noOfWrongAttempts);
					}
				}
			}
		}
		return "login";
	}

	public static boolean loginSuccess(String ac_pass, String pass) {
		return pass.equals(ac_pass);
	}

	public static void saveDB(User user, Session session, Transaction tx) {
		try {
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public static void loginOpr(User user, String pass, Session session, Transaction tx, Model m, int noOfWrongAttempts) {
		if (loginSuccess(user.getPassword(), pass)) {
			user.setNoOfWrongAttemps(0);
			user.setStatus(true);
			saveDB(user, session, tx);
			m.addAttribute("message", "Login Successful.");
		}
		// login fail
		else {
			if (noOfWrongAttempts % 3 == 2) {
				Date date1 = new Date();
				long ts = date1.getTime();
				user.setTs(ts);
			}
			noOfWrongAttempts++;
			user.setNoOfWrongAttemps(noOfWrongAttempts);
			if(noOfWrongAttempts >= 12)
				user.setStatus(false);
			saveDB(user, session, tx);
			m.addAttribute("message", "Wrong credentials, try again!");
		}
	}

	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/unblock/{id}")
	public String unblock(@PathVariable int id, Model m) {
		DatabaseController dc = new DatabaseController();
		Session session = dc.getsession();
		
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("id", id));
		List<User> results = cr.list();
		
		if (results.isEmpty()) {
			m.addAttribute("message", "Invalid operation.");
		}
		else {
			for(User user: results) {
				user.setStatus(true);
				saveDB(user, session, tx);
			}
		}
		
		return "admin";
	}
	
	

	@RequestMapping("/signupPost")
	public String loginUser(HttpServletRequest req, Model m) {
		DatabaseController dc = new DatabaseController();
		Session session = dc.getsession();

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		Transaction tx = session.beginTransaction();
		Timestamp ts = new Timestamp(new Date().getTime());
		User user = new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setUname(uname);
		user.setStatus(true);
		user.setRole("user");
		user.setPassword(pass);
		user.setNoOfWrongAttemps(0);

		try {
			session.save(user);
			tx.commit();
			m.addAttribute("status", "Signup Successful");
		} catch (Exception e) {
			m.addAttribute("status", "Signup Failed");
		}
		return "signup";
	}

}
