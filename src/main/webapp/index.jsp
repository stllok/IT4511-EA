<%-- 
    Document   : index
    Created on : 2023年4月26日, 下午2:54:30
    Author     : kelvinleung
--%>

<%@page import="java.util.*, ict.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
LoginSession.toMainPage(request, response);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Example Company Main Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Example Company Main Page</h1>
        <ul style="
            list-style: none;
            ">
            <li><a href="member_login.jsp">Member Login</a></li>
            <li><a href="staff_login.jsp">Staff Login</a></li>
            <li><a href="seniorstaff_login.jsp">Senior Staff Login</a></li>
        </ul>
    </body>
</html>
