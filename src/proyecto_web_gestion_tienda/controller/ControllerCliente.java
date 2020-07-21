package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import proyecto_web_gestion_tienda.model.Producto;
import proyecto_web_gestion_tienda.service.OperacionesDB;
import proyecto_web_gestion_tienda.utils.HibernateUtil;

@WebServlet("/ControllerCliente")
public class ControllerCliente  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	Session session = HibernateUtil.getSessionFactory().openSession();
//	private static Logger logger = LogManager.getLogger(ControllerLogin.class);
//	static SessionFactory sessionFactory;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession mySession = request.getSession(true);
		ArrayList<Producto> aProductos2 ;
		aProductos2 = OperacionesDB.mostraTodoslosproductos();
		request.setAttribute("todosProductos2", aProductos2);
		request.getRequestDispatcher("clienteNormal.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	
	
	

}
