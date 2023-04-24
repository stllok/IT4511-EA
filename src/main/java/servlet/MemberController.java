/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import bean.Staff;
import bean.VenueMember;
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
                VenueMember m = db.getMember(Integer.parseInt(request.getParameter("id")));
                if (m != null) {
                    m.setName(request.getParameter("name"));
                    m.setUsername(request.getParameter("username"));
                    m.setPassword(request.getParameter("password"));
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
