/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDao;
import dao.BaseDaoImpl;
import pojo.User;


public class RegistrationController extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("userRegistration.jsp");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String msg = "Password and Conform Passwords must be same";
  String page = "userRegistration.jsp";
  if(request.getParameter("password").equals(request.getParameter("confPassword"))){
   User user = new User();
   user.setUsername(request.getParameter("username"));
   user.setPassword(request.getParameter("password"));
   user.setName(request.getParameter("name"));
   user.setFuncao(request.getParameter("funcao"));
   user.setEmail(request.getParameter("email"));
   user.setTelefone(Integer.parseInt(request.getParameter("telefone")));
  
   
   System.out.println(user.toString());
   BaseDao baseDao = new BaseDaoImpl();
   msg = baseDao.register(user);
   page = "login.jsp";
  } 
  request.setAttribute("msg2", msg);
  request.getRequestDispatcher(page).include(request, response);
 }

}