package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.service.OperacionesDB;

@WebServlet("/ControllerTrabajadorCompras")
public class ControllerTrabajadorCompras extends HttpServlet{

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
		ArrayList<Persona> aPersonas;
		aPersonas = OperacionesDB.mostraTodasPersonas();
		for (Persona persona : aPersonas) {
			System.out.println("nombre: "+persona.getNombre());
		}
		request.setAttribute("todasPersonas", aPersonas);
		
    request.getRequestDispatcher("trabajadorCompras.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}	
}
