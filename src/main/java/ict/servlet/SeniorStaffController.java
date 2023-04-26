/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.servlet;

import ict.bean.SeniorStaff;
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
@WebServlet(name = "SeniorStaffController", urlPatterns = {"/seniorstaff"})
public class SeniorStaffController extends StaffController {

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
        isValidLogin(response);
        TestDatabase db = getDB(request);
        switch (request.getParameter("action")) {
            case "listStaff":
                break;
            case "addStaff":
                break;
            case "editStaff":
                break;
            case "listSeniorStaff":
                break;
            case "addlistSeniorStaff":
                break;
            case "editlistSeniorStaff":
                break;
            default:
                super.doGet(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                TestDatabase db = getDB(request);
        SeniorStaff ss = null;
        switch (request.getParameter("action")) {
            case "edit":
                break;
            case "create":
                break;
            case "login":
                if (LoginSession.isLogin(request)) {
                    LoginSession.toMainPage(request, response);
                } else {
                    ss = db.getSeniorStaff(request.getParameter("username"));
                    if (ss != null) {
                        if (ss.isPasswordMatch(request.getParameter("password"))) {
                            LoginSession.setLoginSession(request, ss);
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

    private void isValidLogin(HttpServletResponse response) throws ServletException, IOException {
        if (false) {
            response.sendRedirect("index.html");
        }
    }
}
