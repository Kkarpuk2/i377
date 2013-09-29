

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePage
 */
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
    		   HttpServletResponse response) throws ServletException, IOException {
    		  
    		  String param = request.getParameter("param");
    		  String session_attribute = (String)request.getSession().getAttribute("param");
    		  
    		  if ( param != null ) {
    		   request.getSession().setAttribute("param", param);
    		   session_attribute = param;
    		  }

    		  response.getWriter().println("Hello");
    		  response.getWriter().println("Your session id is " + request.getSession().getId());
    		  response.getWriter().println("Session attribute is " + session_attribute);  
    		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
