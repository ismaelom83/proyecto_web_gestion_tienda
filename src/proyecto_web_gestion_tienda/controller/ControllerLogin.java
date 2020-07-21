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

		ArrayList<Persona> aPersonas;
		ArrayList<Producto> aProducto;
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Persona personas = OperacionesDB.logIn(session, email, password);
		aPersonas = OperacionesDB.mostraTodasPersonas(session);
		aProducto = OperacionesDB.mostraTodoslosproductos();

		if (personas != null) {

			request.setAttribute("todasPersonas", aPersonas);
			switch (personas.getTipoPersona()) {
			case " A":
				request.setAttribute("persona", personas);
				request.setAttribute("todasPersonas", aPersonas);
				request.getRequestDispatcher("trabajadorCompras.jsp").forward(request, response);
				logger.info(String.format("Trabajador compras logeado.", methodName));
				break;
			case " T":
				request.setAttribute("persona", personas);
				request.setAttribute("todasPersonas", aPersonas);
				request.getRequestDispatcher("trabajadorVentas.jsp").forward(request, response);
				logger.info(String.format("Trabajador ventas logeado.", methodName));
				break;
			case "CN":
				HttpSession mySession = request.getSession(true);
				@SuppressWarnings("unchecked")
				ArrayList<Producto> listaLogeada2 = (ArrayList<Producto>) mySession.getAttribute("listaLogeada");
	
				if (mySession.getAttribute("listaLogeada")!=null) {
					mySession.setAttribute("persona", personas.getNombre() + ' ' + personas.getApellido1());
					mySession.setAttribute("personaCompleta", personas);
					response.sendRedirect("http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarrito");
					System.out.println("la lista del no logeado " + listaLogeada2);
				}else {
					mySession.setAttribute("persona", personas.getNombre() + ' ' + personas.getApellido1());
					mySession.setAttribute("personaCompleta", personas);
//					mySession.setAttribute("todosProductos", aProducto);
					response.sendRedirect("http://localhost:8080/proyecto_web_gestion_tienda/ControllerCliente");
					System.out.println("la lista del no logeado " + listaLogeada2);
					logger.info(String.format("Cliente normal logeado.", methodName));
				}
				
				
				break;
			case " C":
				request.setAttribute("todasPersonas", aPersonas);
				request.getRequestDispatcher("clientePremium.jsp").forward(request, response);
				logger.info(String.format("Cliente premium logeado.", methodName));
				break;
			case " H":
				request.getRequestDispatcher("administrador.jsp").forward(request, response);
				logger.info(String.format("Administrador logeado.", methodName));
				break;
			default:
				request.getRequestDispatcher("error.jsp").forward(request, response);
				logger.info(String.format("Error al logearse.", methodName));
				break;
			}

		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			logger.info(String.format("Error al logearse.", methodName));

		}

	}
}
