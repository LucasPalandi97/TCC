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
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import pojo.Requisicao;
import pojo.User;
import util.HibernateUtil;




public class RequisicaoController extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequisicaoController() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  HttpSession session = request.getSession();
        

 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String msg = null;
  String page = "requisicao.jsp";
   String user_username = null;
  Cookie[] cookies = request.getCookies();

if (cookies != null) {
 for (Cookie cookie : cookies) {
   if (cookie.getName().equals("username")) {
     //do something
     //value can be retrieved using #cookie.getValue()
     user_username = cookie.getValue();
     
    }
  }
}
  
   Requisicao req = new Requisicao();
   
   req.setData(request.getParameter("data"));
   req.setCategoria(request.getParameter("catOpt"));
   req.setSubcategoria(request.getParameter("subcatOpt"));
   req.setPrioridade(request.getParameter("priOpt"));
   req.setTitulo(request.getParameter("titulo"));
   req.setDescricao(request.getParameter("descricao"));
   req.setUser_username(user_username);
   req.setStatus("Em aberto");
   req.setTipo("REQ");
  
    
   
   System.out.println(req.toString());
   BaseDao baseDao = new BaseDaoImpl();
   msg = baseDao.registerR(req);
   page = "ChamadoCriadoSucesso.jsp";
  
  request.setAttribute("msg2", msg);
  request.getRequestDispatcher(page).include(request, response);
 }

}