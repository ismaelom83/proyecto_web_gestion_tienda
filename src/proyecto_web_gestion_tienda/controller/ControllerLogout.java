package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@WebServlet("/ControllerLogout")
public class ControllerLogout extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(ControllerLogout.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	URL appResourceURL = loader.getResource("log4java.properties");
    	String dbConfigFileRoute = appResourceURL.getPath();
    	
		PropertyConfigurator.configure(dbConfigFileRoute);
		HttpSession mySession=request.getSession();  
        mySession.invalidate();  
        response.sendRedirect(request.getContextPath() + "/ControllerIndex");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession mySession=request.getSession();  
         mySession.invalidate();  
         response.sendRedirect(request.getContextPath() + "/ControllerIndex");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	

}
