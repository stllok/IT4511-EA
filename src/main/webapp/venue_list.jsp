 <%-- 
    Document   : user_management
    Created on : 2023年4月24日, 下午1:57:51
    Author     : kelvinleung
--%>

<%@page import="java.util.*, bean.*" %>
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
        <jsp:useBean id="venues" scope="request" class="ArrayList<Venue>" />
        <h1>Member management</h1>

        <table border="1">
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Location</th>
                <th>Capacity</th>
                <th>Description</th>
                <th>Image</th>
                <th>Booking Fee</th>
                <th>Listing on Booking System</th>
                <th>Action</th>
            </tr>
            <%
                for (Venue v :  venues) {
                    out.println("<tr>"
                    + "<td>" + v.getName() + "</td>"
                    + "<td>" + v.getType() + "</td>"
                    + "<td>" + v.getLocation() + "</td>"
                    + "<td>" + v.getCapacity() + "</td>"
                    + "<td>" + v.getDescription() + "</td>"
                    + "<td>" + v.getImg() + "</td>"
                    + "<td>" + v.getBookingFee() + "</td>"
                    + "<td>" + v.isListOnBookingSystem() + "</td>"
                    + "<td><a href=\"staff?action=modifyVenue&id=" + v.getId() + "\">Edit</a> <a href=\"venue?action=delete&id=" + v.getId() + "\">Delete</a></td>");
                }
            %>
            <tr>
                <td colspan="9" style="
                    text-align: end;
                    "><a href="staff?action=addVenue">Add venue</a></td>
            </tr>
        </table>

        <hr />
        <a href="#">Back</a>
    </body>
</html>
