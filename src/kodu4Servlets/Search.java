package kodu4Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbNeljas.Dao;

public class Search extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      setSearchResults(request);
      request.getRequestDispatcher("WEB-INF/jsps/search.jsp").forward(request,
            response);
   }

   @Override
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      String searchString = request.getParameter("searchString");
      response.sendRedirect("Search?searchString=" + searchString);
   }

   private void setSearchResults(HttpServletRequest request) {

      String searchString = request.getParameter("searchString");

      if (searchString == null || searchString.equals("")) {
         request.setAttribute("searchResults", Dao.getAllUnits());
      }
      else {
         request.setAttribute("searchResults", Dao.searchByKeyword(searchString));
      }
   }
}
