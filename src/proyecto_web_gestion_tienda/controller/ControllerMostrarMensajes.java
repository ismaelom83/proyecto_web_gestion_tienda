package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proyecto_web_gestion_tienda.model.Mensajeria;
import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.service.OperacionesDB;

@WebServlet("/ControllerMostrarMensajes")
public class ControllerMostrarMensajes extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mySession = request.getSession();
		Persona p = (Persona) mySession.getAttribute("personaCompleta");

		ArrayList<Mensajeria> devolucionPedidos2 = OperacionesDB.buscarDevoluconPedidos(p.getId());

		request.setAttribute("listaDevolucionPedidos2", devolucionPedidos2);
		for (Mensajeria mensajeria : devolucionPedidos2) {
			System.out.println("cuerpo: " + mensajeria.getCuerpo());
		}
		request.getRequestDispatcher("mostarMensajes.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
