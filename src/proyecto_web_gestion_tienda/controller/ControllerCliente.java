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


@WebServlet("/ControllerCliente")
public class ControllerCliente  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Session session = HibernateUtil.getSessionFactory().openSession();
	private static Logger logger = LogManager.getLogger(ControllerCliente.class);
	static SessionFactory sessionFactory;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//    	URL appResourceURL = loader.getResource("log4java.properties");
//    	String dbConfigFileRoute = appResourceURL.getPath();
//    	
//		PropertyConfigurator.configure(dbConfigFileRoute);
		HttpSession mySession = request.getSession(true);
		ArrayList<Producto> aProductos2 ;
		String categoria = request.getParameter("categoria");
		if (categoria!=null) {
		aProductos2 =	OperacionesDB.buscarPructoCaregoria(categoria);
		} else {
			aProductos2 = OperacionesDB.mostraTodoslosproductos();		
		}
		
//	Persona p =	(Persona) mySession.getAttribute("personaCompleta");
//System.out.println(p.getId());
//	Cliente categoriaCliente = OperacionesDB.buscarCategoriaCliente(p.getId());
//	mySession.setAttribute("categoriaCliente", categoriaCliente.getCategoria());
		request.setAttribute("todosProductos2", aProductos2);
		request.getRequestDispatcher("clienteNormal.jsp").forward(request, response);
		logger.info(String.format("Cliente normal logeado."));
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	
	
	

}
