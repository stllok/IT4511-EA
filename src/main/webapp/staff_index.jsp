<%-- 
    Document   : member_index
    Created on : 2023年4月26日, 下午2:53:41
    Author     : kelvinleung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="index.jsp"%>
<%@page import="java.util.*, ict.util.*, ict.bean.*" %>
<jsp:useBean id="userInfo" scope="session" class="Staff" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Main Page</title>
    </head>
    <body>
        <h1>Hello <%=userInfo.getUsername() %>!</h1>
        <ul style="list-style: none;">
            <li><a href="staff?action=listMember">Manage Member</a></li>
            <li><a href="staff?action=listVenue">Manage Venue</a></li>
        </ul>
        <hr/>
        <a href="logout">Logout</a>
    </body>
</html>
