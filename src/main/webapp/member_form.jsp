<%-- 
    Document   : user_modify
    Created on : 2023年4月24日, 下午2:38:46
    Author     : kelvinleung
--%>

<%@page import="java.util.*, bean.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="member" scope="request" class="VenueMember" />
    <jsp:useBean id="userAction" scope="request" class="String" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=userAction %> member</title>
    </head>
    <body>
        <h1><%=userAction %> member</h1>
        <form method="post" action="member">
            <input type="hidden" value="<%=userAction %>" name="action"  />
            <input type="hidden" value="<%=member.getName() != null ? member.getId() : "" %>" name="id"  />
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" value="<%=member.getName() != null ? member.getUsername() : "" %>" name="username"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" value="<%=member.getName() != null ? member.getName() : "" %>" name="name"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" value="<%=member.getName() != null ? member.getPassword() : "" %>" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="button" onclick="history.back()" value="Back" /></td>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
