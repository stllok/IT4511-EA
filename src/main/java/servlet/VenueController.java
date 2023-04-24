/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import bean.VenueMember;
import bean.Staff;
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
@WebServlet(name = "VenueController", urlPatterns = {"/api/venue"})
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
                db.removeMember(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("staff?action=manageMember");
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
                Venue m = db.getVenue(Integer.parseInt(request.getParameter("id")));
                if (m != null) {
                    m.setName(request.getParameter("name"));
                }
                response.sendRedirect("staff?action=manageMember");
                break;
            case "create":
                db.addMember(request.getParameter("username"),
                        request.getParameter("password"),
                        request.getParameter("name"));
                response.sendRedirect("staff?action=manageMember");
                break;
            default:
                break;
        }
    }

}
