package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import proyecto_web_gestion_tienda.model.Producto;
import proyecto_web_gestion_tienda.service.OperacionesDB;
import proyecto_web_gestion_tienda.utils.HibernateUtil;

@WebServlet("/ControllerIndex")
public class ControladorIndex extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Session session = HibernateUtil.getSessionFactory().openSession();
	private static Logger logger = LogManager.getLogger(ControllerLogin.class);
	static SessionFactory sessionFactory;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	

	public ControladorIndex() {
		super();
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Producto> aProducto;	
		aProducto = OperacionesDB.mostraTodoslosproductos(session);	
		request.setAttribute("todosProductos", aProducto);
		System.out.println(aProducto);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}