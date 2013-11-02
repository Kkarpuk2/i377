package kodu4Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbNeljas.Dao;


public class Delete extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      deleteItems(request);
      response.sendRedirect("Search");
   }

   private void deleteItems(HttpServletRequest request) {

      if(request.getParameter("id").equalsIgnoreCase("All")) {
         Dao.deleteAll();
      }
      else {
         Dao.deleteUnitById(request.getParameter("id"));
      }
   }
}