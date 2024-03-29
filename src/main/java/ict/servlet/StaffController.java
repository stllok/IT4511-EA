/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.servlet;

import ict.bean.Staff;
import ict.bean.Venue;
import ict.bean.VenueMember;
import ict.db.TestDatabase;
import ict.util.LoginSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kelvinleung
 */
@WebServlet(name = "StaffController", urlPatterns = {"/staff"})
public class StaffController extends HttpServlet {

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
        if (!LoginSession.isAdmin(request)) {
            response.sendRedirect("index.jsp");
        } else {
        TestDatabase db = getDB(request);
        switch (request.getParameter("action")) {
            case "listMember":
                ArrayList<VenueMember> members = (ArrayList<VenueMember>) request.getAttribute("members");
                if (members == null) {
                    request.setAttribute("members", db.getMembers());
                }
                this.getServletContext()
                        .getRequestDispatcher("/member_list.jsp")
                        .forward(request, response);
                break;
            case "modifyMember":
                try {
                    VenueMember m = db.getMember(Integer.parseInt(request.getParameter("id")));
                    if (m != null) {
                        request.setAttribute("userAction", "edit");
                        request.setAttribute("member", m);
                        this.getServletContext()
                                .getRequestDispatcher("/member_form.jsp")
                                .forward(request, response);
                    } else {
                        response.sendRedirect("staff?action=listMember");
                    }
                } catch (Exception e) {
                    response.sendRedirect("staff?action=listMember");
                }
            break;
            case "addMember":
                request.setAttribute("userAction", "create");
                request.setAttribute("member", new VenueMember());
                this.getServletContext()
                        .getRequestDispatcher("/member_form.jsp")
                        .forward(request, response);
                break;
            case "listVenue":
                ArrayList<Venue> venues = (ArrayList<Venue>) request.getAttribute("venues");
                if (venues == null) {
                    request.setAttribute("venues", db.getVenues());
                }
                this.getServletContext()
                        .getRequestDispatcher("/venue_list.jsp")
                        .forward(request, response);
                break;
            case "modifyVenue":
                Venue v = db.getVenue(Integer.parseInt(request.getParameter("id")));
                if (v != null) {
                    request.setAttribute("venueAction", "edit");
                    request.setAttribute("venue", v);
                    this.getServletContext()
                            .getRequestDispatcher("/venue_form.jsp")
                            .forward(request, response);
                } else {
                    response.sendRedirect("staff?action=listVenue");
                }
                try {

                } catch (Exception e) {
                    response.sendRedirect("staff?action=listVenue");
                }
                break;
            case "addVenue":
                request.setAttribute("venueAction", "create");
                request.setAttribute("venue", new Venue());
                this.getServletContext()
                        .getRequestDispatcher("/venue_form.jsp")
                        .forward(request, response);
                break;
            default:
                response.getWriter().println("Action not found...");
                break;
        }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TestDatabase db = getDB(request);
        Staff s = null;
        switch (request.getParameter("action")) {
            case "edit":
                break;
            case "create":
                break;
            case "login":
                if (LoginSession.isLogin(request)) {
                    LoginSession.toMainPage(request, response);
                } else {
                    s = db.getStaff(request.getParameter("username"));
                    if (s != null) {
                        if (s.isPasswordMatch(request.getParameter("password"))) {
                            LoginSession.setLoginSession(request, s);
                            LoginSession.toMainPage(request, response);                            
                        } else {
                            response.sendRedirect("login_error.jsp");
                        }
                    } else {
                        response.sendRedirect("login_error.jsp");
                    }
                    
                }
                break;
            default:
                LoginSession.toMainPage(request, response);                
                break;
        }

    }

}
