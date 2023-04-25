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
        <title><%=venueAction %> venue</title>
    </head>
    <body>
        <h1><%=venueAction %> venue</h1>
        <form method="post" action="venue">
            <input type="hidden" value="<%=venueAction %>" name="action"  />
            <input type="hidden" value="<%=venue.getName() != null ? venue.getId() : "" %>" name="id"  />
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" value="<%=venue.getName() != null ? venue.getName() : "" %>" name="name"/></td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td><input type="text" value="<%=venue.getType() != null ? venue.getType() : "" %>" name="type"/></td>
                </tr>
                <tr>
                    <td>Location:</td>
                    <td><input type="text" value="<%=venue.getLocation() != null ? venue.getLocation() : "" %>" name="location"/></td>
                </tr>
                <tr>
                    <td>Capacity:</td>
                    <td><input type="text" value="<%=venue.getCapacity() != null ? venue.getCapacity() : "" %>" name="capacity"/></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><textarea  name="description" rows="4" cols="50"><%=venue.getDescription() != null ? venue.getDescription() : "" %></textarea></td>
                </tr>
                <tr>
                    <td>Image:</td>
                    <td><input type="text" value="<%=venue.getImg() != null ? venue.getImg() : "" %>" name="image"/></td>
                </tr>
                <tr>
                    <td>Booking Fee:</td>
                    <td><input type="number" min="0" <%=venue.getName() != null ? "value=" + venue.getBookingFee() : "" %> name="bookingfee" /></td>
                </tr>
                <tr>
                    <td>List on Booking System:</td>
                    <td><input type="checkbox" <%=venue.isListOnBookingSystem() ? "checked" : "" %> name="listonbooking" /></td>
                </tr>
                <tr>
                    <td><input type="button" onclick="history.back()" value="Back" /></td>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
