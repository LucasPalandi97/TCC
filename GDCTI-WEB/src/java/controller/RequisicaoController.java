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

import pojo.Requisicao;




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
  response.sendRedirect("requisicao.jsp");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String msg = null;
  String page = "requisicao.jsp";
  
   Requisicao req = new Requisicao();
   
   req.setData(request.getParameter("data"));
   req.setCategoria(request.getParameter("catOpt"));
   req.setSubcategoria(request.getParameter("subcatOpt"));
   req.setPrioridade(Integer.parseInt(request.getParameter("priOpt")));
   req.setTitulo(request.getParameter("titulo"));
   req.setDescricao(request.getParameter("descricao"));
   req.setStatus(1);
   req.setTipo("REQ");
  
  
   
   System.out.println(req.toString());
   BaseDao baseDao = new BaseDaoImpl();
   msg = baseDao.registerR(req);
   page = "ChamadoCriadoSucesso.jsp";
  
  request.setAttribute("msg2", msg);
  request.getRequestDispatcher(page).include(request, response);
 }

}