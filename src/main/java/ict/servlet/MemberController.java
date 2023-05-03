/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.servlet;

import ict.bean.Staff;
import ict.bean.VenueMember;
import ict.db.TestDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import ict.util.LoginSession;

/**
 *
 * @author kelvinleung
 */
@WebServlet(name = "MemberController", urlPatterns = {"/member"})
public class MemberController extends HttpServlet {

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
                response.sendRedirect("staff?action=listMember");
                break;
            case "register":
                request.setAttribute("userAction", "register");
                request.setAttribute("member", new VenueMember());
                this.getServletContext()
                        .getRequestDispatcher("/member_form.jsp")
                        .forward(request, response);
            default:
                LoginSession.toMainPage(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TestDatabase db = getDB(request);
        VenueMember m = null;
        switch (request.getParameter("action")) {
            case "edit":
                m = db.getMember(Integer.parseInt(request.getParameter("id")));
                if (m != null) {
                    m.setName(request.getParameter("name"));
                    m.setUsername(request.getParameter("username"));
                    m.setPassword(request.getParameter("password"));
                }
                response.sendRedirect("staff?action=listMember");
                break;
            case "create":
                db.addMember(request.getParameter("username"),
                        request.getParameter("password"),
                        request.getParameter("name"));
                response.sendRedirect("staff?action=listMember");
                break;
            case "login":
                if (LoginSession.isLogin(request)) {
                    LoginSession.toMainPage(request, response);
                } else {
                    m = db.getMember(request.getParameter("username"));
                    if (m != null) {
                        if (m.isPasswordMatch(request.getParameter("password"))) {
                            LoginSession.setLoginSession(request, m);
                            LoginSession.toMainPage(request, response);
                        } else {
                            response.sendRedirect("login_error.jsp");
                        }
                    } else {
                        response.sendRedirect("login_error.jsp");
                    }

                }
                break;
            case "register":
                db.addMember(request.getParameter("username"),
                        request.getParameter("password"),
                        request.getParameter("name"));
                response.sendRedirect("member_login.jsp");
            default:
                LoginSession.toMainPage(request, response);
                break;
        }
    }
}
