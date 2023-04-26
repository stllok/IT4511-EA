/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.util;

import ict.bean.BaseRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author kelvinleung
 */
public class LoginSession {

    public static boolean isLogin(HttpServletRequest request) {
        return request.getSession().getAttribute("userInfo") != null;
    }

    public static boolean isAdmin(HttpServletRequest request) {
        return isLogin(request) ? getLoginSession(request).isAdmin() : false;
    }

    public static boolean isSuperAdmin(HttpServletRequest request) {
        return isLogin(request) ? getLoginSession(request).isSuperadmin() : false;
    }

    public static void setLoginSession(HttpServletRequest request, BaseRole u) {
        request.getSession(true).setAttribute("userInfo", u);
    }

    public static void removeLoginSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("userInfo");
            session.invalidate();
        }
        response.sendRedirect("index.jsp");
    }

    public static BaseRole getLoginSession(HttpServletRequest request) {
        return (BaseRole) request.getSession().getAttribute("userInfo");
    }

    public static void toMainPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (isSuperAdmin(request)) {
            response.sendRedirect("seniorstaff_index.jsp");
        } else if (isAdmin(request)) {
            response.sendRedirect("staff_index.jsp");
        } else if (isLogin(request)) {
            response.sendRedirect("member_index.jsp");
        }
    }
}
