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

import proyecto_web_gestion_tienda.model.CabeceraPedido;
import proyecto_web_gestion_tienda.model.DetallePedido;
import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.service.OperacionesDB;

@WebServlet("/ControllerMisPedidos")
public class ControllerMisPedidos extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(ControllerMisPedidos.class);

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
		ArrayList<CabeceraPedido> cabeceraPedido = null;
		try {
			Persona p = (Persona) mySession.getAttribute("personaCompleta");
			cabeceraPedido = OperacionesDB.mostrarCabeceraPedido(p.getId());

			request.setAttribute("cabeceraPedidos", cabeceraPedido);
		} catch (Exception e) {
			// TODO: handle exception
		}

		request.getRequestDispatcher("misPedidos.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int lProductos = 0;
			int id = Integer.parseInt(request.getParameter("idCabeceraPedido"));
			ArrayList<DetallePedido> listaFactrura2 = OperacionesDB.mostrarLineasPedido(id);

			for (DetallePedido detallePedido : listaFactrura2) {
				lProductos += detallePedido.getTotalLinea();
			}
			request.setAttribute("sTotal", lProductos);
			
			System.out.println(lProductos);
			request.setAttribute("lineasPedido", listaFactrura2);
			request.getRequestDispatcher("detallePedido.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}

	}

}
