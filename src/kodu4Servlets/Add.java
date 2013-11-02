package kodu4Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;
import dbNeljas.Dao;

public class Add extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setAttribute("unitList", Dao.getAllUnits());
      request.getRequestDispatcher("WEB-INF/jsps/add.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      addItem(request);
      response.sendRedirect("Search");
   }

   private void addItem(HttpServletRequest request) {
	   Unit unit = new Unit();
	   unit.setName(request.getParameter("name"));
	   unit.setCode(request.getParameter("code"));
	   
	   String superUnitID = request.getParameter("superUnitCode");
	   if(!superUnitID.equals("")) {
		   unit.setSuper_unit_id(Long.parseLong(superUnitID));
	   } else {
		   unit.setSuper_unit_id(null);
	   }

	   Dao.addItem(unit);
   }
}