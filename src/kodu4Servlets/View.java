package kodu4Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;
import dbNeljas.Dao;


public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Unit unit = Dao.findUnitById(request.getParameter("id"));
		
		request.setAttribute("unit", unit);
		request.setAttribute("subUnits", Dao.getSubUnitCodes(request.getParameter("id")));

		if(unit.getSuper_unit_id() != null) {
			Unit superunit = Dao.findUnitById(unit.getSuper_unit_id());
			request.setAttribute("superUnitName", superunit.getName());
			request.setAttribute("superUnitCode", superunit.getCode());
		} else {
			request.setAttribute("superUnitName", "");
			request.setAttribute("superUnitCode", "");
		}

		request.getRequestDispatcher("WEB-INF/jsps/view.jsp").forward(request, response);
	}
}