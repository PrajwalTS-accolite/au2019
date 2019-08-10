<%@page import="java.util.List"%>
<%@page import="com.accolite.pojo.User"%>
<%@page import="com.accolite.main.DatabaseController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.criterion.Restrictions"%>
<%@ page import="org.hibernate.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body bgcolor="">

	<div class="container">
		<div class="row">
			<h1 class="display-3" style="padding:10px">Admin Panel</h1>
		</div>
		<div class="row">
		<table class="table table-dark">
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Status</th>
				<th>Change Status</th>
			</tr>
			<%
				Session s = DatabaseController.getsession();
				Transaction tr = s.beginTransaction();
				Criteria cr = s.createCriteria(User.class);
				List<User> results = cr.list();
				for (User user : results) {
					String btn = "";
					if (!user.isStatus()) {
						btn = "<a href = \"/SpringMVCAU/apis/unblock/" + user.getId() + "\"><button type=\"button\" class=\"btn btn-success\"> Unblock</button></a>";
					}
					if ("user".equals(user.getRole()))
						out.println("<tr><td>" + user.getId() + "</td><td>" + user.getFname() + "</td><td>"
								+ user.getLname() + "</td><td>" + user.getUname() + "</td><td>" + user.getPassword()
								+ "</td><td>" + user.isStatus() + "</td><td>" + btn + "</td><tr>");
				}
			%>
			${message}
		</table>
		</div>
	</div>
</body>
</html>