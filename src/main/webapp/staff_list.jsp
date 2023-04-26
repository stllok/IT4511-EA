<%-- 
    Document   : staff_list
    Created on : 2023年4月26日, 下午1:22:33
    Author     : kelvinleung
--%>

<%@page import="java.util.*, ict.bean.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Management</title>
        <style>
            td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="staffs" scope="request" class="ArrayList<Staff>" />
        <h1>Staff management</h1>

        <table border="1">
            <tr>
                <th>Username</th>
                <th>Action</th>
            </tr>
            <%
                for (Staff m :  staffs) {
                    out.println("<tr>"
                    + "<td>" + m.getUsername() + "</td>"
                    + "<td><a href=\"staff?action=modifyStaff&id=" + m.getId() + "\">Edit</a> <a href=\"staff?action=delete&id=" + m.getId() + "\">Delete</a></td>");
                }
            %>
            <tr>
                <td colspan="3" style="
                    text-align: end;
                    "><a href="staff?action=addStaff">Add staff</a></td>
            </tr>
        </table>

        <hr />
        <a href="#">Back</a>
    </body>
</html>
