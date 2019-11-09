package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDao;
import dao.BaseDaoImpl;
import pojo.Incidente;



public class IncidenteController extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncidenteController() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("incidente.jsp");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String msg = null;
  String page = "incidente.jsp";
  
   Incidente inc = new Incidente();
  
   inc.setData(request.getParameter("data"));
   inc.setCategoria(request.getParameter("catOpt"));
   inc.setSubcategoria(request.getParameter("subcatOpt"));
   inc.setPrioridade(Integer.parseInt(request.getParameter("priOpt")));
   inc.setTitulo(request.getParameter("titulo"));
   inc.setDescricao(request.getParameter("descricao"));
   inc.setSerie(request.getParameter("serie"));
   inc.setStatus(1);
   inc.setTipo("INC");
  
  
   
   System.out.println(inc.toString());
   BaseDao baseDao = new BaseDaoImpl();
   msg = baseDao.registerI(inc);
   page = "ChamadoCriadoSucesso.jsp";
  
  request.setAttribute("msg2", msg);
  request.getRequestDispatcher(page).include(request, response);
 }

}