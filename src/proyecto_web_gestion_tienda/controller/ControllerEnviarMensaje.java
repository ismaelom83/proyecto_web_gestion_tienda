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

import proyecto_web_gestion_tienda.model.CabeceraPedido;
import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.service.OperacionesDB;

@WebServlet("/ControllerEnviarMensaje")
public class ControllerEnviarMensaje extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(ControllerEnviarMensaje.class);

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	URL appResourceURL = loader.getResource("log4java.properties");
    	String dbConfigFileRoute = appResourceURL.getPath();
    	
		PropertyConfigurator.configure(dbConfigFileRoute);
	
			HttpSession mySession = request.getSession();
			Persona p = (Persona) mySession.getAttribute("personaCompleta");
			int idPedido= Integer.parseInt(request.getParameter("IdDestinatario"));
			String asunto = request.getParameter("asunto");
			String cuerpo = request.getParameter("cuerpo");

			System.out.println("esto deberia ser el asunto: "+asunto);
			System.out.println("esto deberia ser la cabecera: "+cuerpo);
			OperacionesDB.insertarMensajesDevolucion(idPedido, p.getId(), "hola", asunto, cuerpo, 0, 0);

			
		
		response.sendRedirect("ControllerCliente");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
