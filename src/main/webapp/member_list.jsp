<%-- 
    Document   : user_management
    Created on : 2023年4月24日, 下午1:57:51
    Author     : kelvinleung
--%>

<%@page import="java.util.*, ict.bean.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member Management</title>
        <style>
            td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="members" scope="request" class="ArrayList<VenueMember>" />
        <h1>Member management</h1>

        <table border="1">
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <%
                for (VenueMember m :  members) {
                    out.println("<tr>"
                    + "<td>" + m.getUsername() + "</td>"
                    + "<td>" + m.getName() + "</td>"
                    + "<td><a href=\"staff?action=modifyMember&id=" + m.getId() + "\">Edit</a> <a href=\"member?action=delete&id=" + m.getId() + "\">Delete</a></td>");
                }
            %>
            <tr>
                <td colspan="3" style="
                    text-align: end;
                    "><a href="staff?action=addMember">Add user</a></td>
            </tr>
        </table>

        <hr />
        <a href="#">Back</a>
    </body>
</html>
