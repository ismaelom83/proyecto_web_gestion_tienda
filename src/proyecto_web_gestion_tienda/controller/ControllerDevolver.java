package proyecto_web_gestion_tienda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_web_gestion_tienda.service.OperacionesDB;

@WebServlet("/ControllerDevolver")
public class ControllerDevolver extends HttpServlet{

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPedido= Integer.parseInt(request.getParameter("idPedido"));
		
		OperacionesDB.borrarPedido(idPedido);
		response.sendRedirect("ControllerTrabajadorVentas");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


	
	

}
