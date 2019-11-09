/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */

    
    public class LogoutServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
         String username = request.getParameter("username");
        Cookie logoutCookie = new Cookie("username", username);

                //setting cookie to expiry in 30 mins
                logoutCookie.setMaxAge(0);
                response.addCookie(logoutCookie);
                response.sendRedirect("login.jsp");

                //mantem a sessao 
               
                session.setAttribute("connecte", "false");
               request.getSession().invalidate();
     
    }


}
