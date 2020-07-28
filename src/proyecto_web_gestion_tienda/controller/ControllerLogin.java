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
import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.model.Producto;
import proyecto_web_gestion_tienda.service.OperacionesDB;
import proyecto_web_gestion_tienda.utils.HibernateUtil;

@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Session session = HibernateUtil.getSessionFactory().openSession();
	private static Logger logger = LogManager.getLogger(ControllerLogin.class);
	String methodName = ControllerLogin.class.getSimpleName() + ".ControllerLogin()";
	static SessionFactory sessionFactory;

	public ControllerLogin() {
		super();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//    	URL appResourceURL = loader.getResource("log4java.properties");
//    	String dbConfigFileRoute = appResourceURL.getPath();
//    	
//		PropertyConfigurator.configure(dbConfigFileRoute);
		ArrayList<Producto> aProducto;
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Persona personas = OperacionesDB.logIn(session, email, password);
	
		aProducto = OperacionesDB.mostraTodoslosproductos();

		if (personas != null) {

//			request.setAttribute("todasPersonas", aPersonas);
			switch (personas.getTipoPersona()) {
			case " A":
				HttpSession mySession3 = request.getSession(true);
				mySession3.setAttribute("persona", personas.getNombre() + ' ' + personas.getApellido1());
				mySession3.setAttribute("personaCompleta", personas);
				response.sendRedirect("ControllerTrabajadorCompras");
				logger.info(String.format("Trabajador compras logeado.", methodName));
				logger.warn("Te has logeado correctamente");
				break;
			case " T":
				HttpSession mySession4 = request.getSession(true);
				mySession4.setAttribute("persona", personas.getNombre() + ' ' + personas.getApellido1());
				mySession4.setAttribute("personaCompleta", personas);
//				request.setAttribute("persona", personas);
//				request.setAttribute("todasPersonas", aPersonas);
				response.sendRedirect("ControllerTrabajadorVentas");
				logger.info(String.format("Trabajador ventas logeado.", methodName));
				logger.warn("Te has logeado correctamente");
				break;
			case "CN":
				HttpSession mySession = request.getSession(true);
				@SuppressWarnings("unchecked")
				ArrayList<Producto> listaLogeada2 = (ArrayList<Producto>) mySession.getAttribute("listaLogeada");
	
				if (mySession.getAttribute("listaLogeada")!=null) {
					mySession.setAttribute("persona", personas.getNombre() + ' ' + personas.getApellido1());
					mySession.setAttribute("personaCompleta", personas);
					response.sendRedirect("http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarrito");
					logger.warn("Te has logeado correctamente");
				}else {
					mySession.setAttribute("persona", personas.getNombre() + ' ' + personas.getApellido1());
					mySession.setAttribute("personaCompleta", personas);
//					mySession.setAttribute("todosProductos", aProducto);
					response.sendRedirect("http://localhost:8080/proyecto_web_gestion_tienda/ControllerCliente");
					System.out.println("la lista del no logeado " + listaLogeada2);
					logger.info(String.format("Cliente normal logeado.", methodName));
					logger.warn("Te has logeado correctamente");
				}
						
				break;
			case "CP":
				HttpSession mySession2 = request.getSession(true);
				@SuppressWarnings("unchecked")
				ArrayList<Producto> listaLogeada = (ArrayList<Producto>) mySession2.getAttribute("listaLogeada");
				if (mySession2.getAttribute("listaLogeada")!=null) {
					mySession2.setAttribute("persona", personas.getNombre() + ' ' + personas.getApellido1());
					mySession2.setAttribute("personaCompleta", personas);
					response.sendRedirect("http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarrito");
					logger.warn("Te has logeado correctamente");
				}else {
					mySession2.setAttribute("persona", personas.getNombre() + ' ' + personas.getApellido1());
					mySession2.setAttribute("personaCompleta", personas);
//					mySession.setAttribute("todosProductos", aProducto);
					response.sendRedirect("http://localhost:8080/proyecto_web_gestion_tienda/ControllerCliente");
					System.out.println("la lista del no logeado " + listaLogeada);
					logger.info(String.format("Cliente normal logeado.", methodName));
					logger.warn("Te has logeado correctamente");
				}
				break;
			case " H":
				HttpSession mySession6 = request.getSession(true);
				mySession6.setAttribute("persona", personas);
				request.getRequestDispatcher("administrador.jsp").forward(request, response);
				logger.info(String.format("Administrador logeado.", methodName));
				logger.warn("Te has logeado correctamente");
				break;
			default:
				request.getRequestDispatcher("error.jsp").forward(request, response);
				logger.info(String.format("Error al logearse.", methodName));
				logger.warn("Te has logeado correctamente");
				break;
			}

		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			logger.info(String.format("Error al logearse.", methodName));
			logger.warn("Te has logeado correctamente");

		}

	}
}
