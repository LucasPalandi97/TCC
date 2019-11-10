/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;

import service.BaseService;
import service.BaseServiceImpl;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
   

        System.out.println(username + " :: " + password);
        String page = "login.jsp";
        if (username.trim().length() >= 0 && username != null
                && password.trim().length() >= 0 && password != null) {
            BaseService loginService = new BaseServiceImpl();
            boolean flag = loginService.login(username, password);
            if (flag) {
                System.out.println("Logado com sucesso!!!");
                request.setAttribute("username", username);           
                request.setAttribute("msg", "Login Success.....");
                Cookie loginCookie = new Cookie("username", username);
                
      
                //setting cookie to expiry in 30 mins
                loginCookie.setMaxAge(30 * 60);
                response.addCookie(loginCookie);
                response.sendRedirect("home.jsp");

                //mantem a sessao 
                HttpSession session = request.getSession();
                session.setAttribute("connecte", "true");
                session.setAttribute("login", request.getAttribute("username"));
                

            } else {
                
                request.setAttribute("msg", "Usuário ou senha incorretos, tente de novo!!!");
            }
        } else {
            request.setAttribute("msg", "Por favor entre com usuário e senha...");
        }
        request.getRequestDispatcher(page).include(request, response);
    }
 
}
