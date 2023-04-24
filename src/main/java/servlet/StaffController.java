/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import bean.VenueMember;
import db.TestDatabase;
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
        if (!isValidLogin()) {

        }
        TestDatabase db = getDB(request);
        switch (request.getParameter("action")) {
            case "manageMember":
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
                    response.sendRedirect("staff?action=manageMember");
                }
            } catch (Exception e) {
                response.sendRedirect("staff?action=manageMember");
            }
            break;
            case "addMember":
                request.setAttribute("userAction", "create");
                    request.setAttribute("member", new VenueMember());
                this.getServletContext()
                        .getRequestDispatcher("/member_form.jsp")
                        .forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private boolean isValidLogin() {
        return true;
    }

}
