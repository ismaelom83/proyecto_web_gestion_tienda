package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import proyecto_web_gestion_tienda.model.Producto;
import proyecto_web_gestion_tienda.service.OperacionesDB;
import proyecto_web_gestion_tienda.utils.HibernateUtil;

@WebServlet("/ControllerIndex")
public class ControllerIndex extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Session session = HibernateUtil.getSessionFactory().openSession();
	private static Logger logger = LogManager.getLogger(ControllerIndex.class);
	static SessionFactory sessionFactory;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	

	public ControllerIndex() {
		super();
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	URL appResourceURL = loader.getResource("log4java.properties");
    	String dbConfigFileRoute = appResourceURL.getPath();
    	
		PropertyConfigurator.configure(dbConfigFileRoute);
		HttpSession mySession=request.getSession();
		ArrayList<Producto> aProducto;		
		aProducto = OperacionesDB.mostraTodoslosproductos();	
		mySession.setAttribute("todosProductos", aProducto);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		logger.info(String.format("Cliente normal logeado."));
	}

}
