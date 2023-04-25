/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import bean.Venue;
import db.TestDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author kelvinleung
 */
@WebServlet(name = "VenueController", urlPatterns = {"/venue"})
public class VenueController extends HttpServlet {

    @Override
    public void init() {
    }

    private TestDatabase getDB(HttpServletRequest request) {
        TestDatabase db = (TestDatabase) request.getSession().getAttribute("db");
        if (db == null) {
            request.getSession().setAttribute("db", db = new TestDatabase());
        }
        return db;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TestDatabase db = getDB(request);
        switch (request.getParameter("action")) {
            case "delete":
                db.removeVenue(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("staff?action=listVenue");
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TestDatabase db = getDB(request);
        switch (request.getParameter("action")) {
            case "edit":
                Venue v = db.getVenue(Integer.parseInt(request.getParameter("id")));
                if (v != null) {
                    v.setImg(request.getParameter("image"));
                    v.setName(request.getParameter("name"));
                    v.setType(request.getParameter("type"));
                    v.setCapacity(request.getParameter("capacity"));
                    v.setLocation(request.getParameter("location"));
                    v.setDescription(request.getParameter("description"));
                    v.setBookingFee(Integer.parseInt(request.getParameter("bookingfee")));
                    v.setListOnBookingSystem(request.getParameter("listonbooking") != null);
                }
                response.sendRedirect("staff?action=listVenue");
                break;

            case "create":
                db.addVenue(Integer.parseInt(request.getParameter("bookingfee")),
                        request.getParameter("image"),
                        request.getParameter("name"),
                        request.getParameter("type"),
                        request.getParameter("capacity"),
                        request.getParameter("location"),
                        request.getParameter("description"),
                        request.getParameter("listonbooking") != null);
                response.sendRedirect("staff?action=listVenue");
                break;
            default:
                break;
        }
    }

}
