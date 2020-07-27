package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proyecto_web_gestion_tienda.model.Mensajeria;
import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.service.OperacionesDB;

@WebServlet("/ControllerDevolucionPedido")
public class ControllerDevolucionPedido  extends HttpServlet{

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
	
		
		HttpSession mySession=request.getSession();
		try {
			
			Persona p = (Persona) mySession.getAttribute("personaCompleta");
			int idPedido= Integer.parseInt(request.getParameter("idPedido"));
		ArrayList<Persona> persona =	OperacionesDB.buscarDepartamentoVentas(" T");
		
		for (Persona persona2 : persona) {	
			OperacionesDB.insertarMensajesDevolucion(persona2.getId(),p.getId() ,"devolucion","devolucion","http://localhost:8080/proyecto_web_gestion_tienda/ControllerDevolver?idPedido="+idPedido+"" , 0, 0);
		}
			
			response.sendRedirect("ControllerCliente");
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}



}
