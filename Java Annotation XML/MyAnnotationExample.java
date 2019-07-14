package com.accolite.au.java;

import java.util.Date;
import java.io.FileWriter;

@Servlet(name = "Prajwal", url = "https://github.com/PrajTS")
public class MyAnnotationExample {
	MyAnnotationExample() {
		Servlet ann = this.getClass().getAnnotation(Servlet.class);
		String name = ann.name();
		String url = ann.url();
		String className = this.getClass().getName();
		createXML(name, url, className);
	}

	public static void main(String args[]) {
		new MyAnnotationExample();
	}

	public void createXML(String name, String url, String className) {
		Date d = new Date();
		try {
			FileWriter fw = new FileWriter("C:/Users/prajwal.ts/Desktop/AnnoXML" + d.getTime() + ".xml");
			fw.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n"
					+ "<!DOCTYPE web-app\n"
					+ "\tPUBLIC \"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN\"\n"
					+ "\t\"http://java.sun.com/dtd/web-app_2_3.dtd\">"
					+ "<web-app>\r\n");
			fw.write("\t<servlet>\n");
			fw.write("\t\t<servlet-name>" + name + "</servlet-name>\n");
			fw.write("\t\t<servlet-class>" + className + "</servlet-class>\n");
			fw.write("\t</servlet>\n");
			fw.write("\t<servlet-mapping>\n");
			fw.write("\t\t<servlet-name>" + name + "</servlet-name>\n");
			fw.write("\t\t<url-pattern>" + url + "</url-pattern>\n");
			fw.write("\t</servlet-mapping>\n");
			fw.write("</web-app>");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...");
	}
}
