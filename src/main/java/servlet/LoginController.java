/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import bean.VenueMember;
import bean.Staff;
import db.TestDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author kelvinleung
 */
@WebServlet(name = "LoginController", urlPatterns = {"/api/member"})
public class LoginController extends HttpServlet {

    @Override
    public void init() {
    }
    
    private TestDatabase getDB(HttpServletRequest request) {
        TestDatabase db = (TestDatabase) request.getSession().getAttribute("db");
        if (db == null)
            request.getSession().setAttribute("db", db = new TestDatabase());
        return db;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("test");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TestDatabase db = getDB(request);
        switch (request.getParameter("action")) {
            case "login":
                switch (request.getParameter("user_type")) {
                    case "member":
                        VenueMember m = db.getMember(request.getParameter("username"), request.getParameter("password"));
                        if (m != null) {
                            // do Success
                        } else {
                            // do Fail
                        }
                        break;
                    case "staff":
                        Staff s = db.getStaff(request.getParameter("username"), request.getParameter("password"));
                        if (s != null) {
                            // do Success
                        } else {
                            // do Fail
                        }
                        break;
                    default:
                        break;
                }
                break;
            case "logout":
                response.sendRedirect("TODO!");
                doLogin(request, response);
                break;
            case "register":
                switch (request.getParameter("user_type")) {
                    case "member":
                        db.addMember(request.getParameter("username"), request.getParameter("password"), request.getParameter("name"));
                        break;
                    case "staff":
                        db.addStaff(request.getParameter("username"), request.getParameter("password"));
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        getServletContext()
                .getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("userInfo");
            session.invalidate();
        }
        doLogin(request, response);
    }
}
