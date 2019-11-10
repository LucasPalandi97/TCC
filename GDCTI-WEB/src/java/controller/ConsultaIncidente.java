/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import pojo.Incidente;

import util.HibernateUtil;

/**
 *
 * @author lucas
 */
public class ConsultaIncidente extends HttpServlet{
    private static final long serialVersionUID = 1L;
      
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("home.jsp");
     
  
 }

    
      public ConsultaIncidente() {
        super();
        // TODO Auto-generated constructor stub
    }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Session sessao = HibernateUtil.getSession();
    Criteria crit = sessao.createCriteria(Incidente.class);
List<Incidente> incList = crit.list();
request.getSession().setAttribute("list", incList);
 RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
rd.forward(request, response);
     System.out.println(incList);
}
}
