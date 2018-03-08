<%@ page language="java" import="java.util.*, java.sql.*, com.registration.service.*" pageEncoding="GB18030"%>
<%@ page import="com.registration.service.*" %>
<%@ page import="com.registration.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = request.getParameter("username");
String password = request.getParameter("password");
String password2 = request.getParameter("password2");

User u = new User();
u.setUsername(username);
u.setPassword(password);

Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/spring", "root", "root");

UserManager um = new UserManager();
boolean exists = um.exists(u);
if(exists){
	response.sendRedirect("registerFail.jsp");
}

um.add(u);
response.sendRedirect("registerSuccess.jsp");
%>

