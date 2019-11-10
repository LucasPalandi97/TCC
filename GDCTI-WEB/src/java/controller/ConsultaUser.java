/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BaseDao;
import dao.BaseDaoImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import pojo.User;
import util.HibernateUtil;



/**
 *
 * @author lucas
 */
public class ConsultaUser extends HttpServlet {
     private static final long serialVersionUID = 1L;

     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("userRegistration.jsp");
  
 }

    
      public ConsultaUser() {
        super();
        // TODO Auto-generated constructor stub
    }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    Session sessao = HibernateUtil.getSession();
    Criteria crit = sessao.createCriteria(User.class);
List<User> usersList = crit.list();
request.getSession().setAttribute("listUser", usersList);
 RequestDispatcher rd = request.getRequestDispatcher("/userRegistration.jsp");
rd.forward(request, response);
     System.out.println(usersList);


}
}

/**
 * @see HttpServlet#HttpServlet()
 */
