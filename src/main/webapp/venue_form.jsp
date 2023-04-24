<%-- 
    Document   : venue_form
    Created on : 2023年4月24日, 下午9:23:55
    Author     : kelvinleung
--%>

<%@page import="java.util.*, bean.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="venue" scope="request" class="Venue" />
    <jsp:useBean id="venueAction" scope="request" class="String" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=userAction %> venue</title>
    </head>
    <body>
        <h1><%=userAction %> venue</h1>
        <form method="post" action="venue">
            <input type="hidden" value="<%=userAction %>" name="action"  />
            <input type="hidden" value="<%=venue.getName() != null ? venue.getId() : "" %>" name="id"  />
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" value="<%=member.getName() != null ? member.getName() : "" %>" name="name"/></td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td><input type="text" value="<%=member.getType() != null ? member.getType() : "" %>" name="type"/></td>
                </tr>
                <tr>
                    <td>Location:</td>
                    <td><input type="text" value="<%=member.getLocation() != null ? member.getLocation() : "" %>" name="location"/></td>
                </tr>
                <tr>
                    <td>Capacity:</td>
                    <td><input type="text" value="<%=member.getCapacity() != null ? member.getCapacity() : "" %>" name="capacity"/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><textarea id="w3review" name="description" rows="4" cols="50"><%=member.getDescription() != null ? member.getDescription() : "" %></textarea></td>
                </tr>
                <tr>
                    <td>Image:</td>
                    <td><input type="text" value="<%=member.getImg() != null ? member.getImg() : "" %>" name="image"/></td>
                </tr>
                <tr>
                    <td>Booking Fee:</td>
                    <td><input type="number" min="0" value="<%=member.getName() != null ? member.getPassword() : "0" %>" name="password" /></td>
                </tr>
                <tr>
                    <td><input type="button" onclick="history.back()" value="Back" /></td>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
