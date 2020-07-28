package proyecto_web_gestion_tienda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.service.OperacionesDB;

@WebServlet("/ControllerRegistro")
public class ControllerRegistro extends HttpServlet {

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

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String email = request.getParameter("email");
		String dni = request.getParameter("dni");
		String password = request.getParameter("password");
		String edad = request.getParameter("edad");
		String tipo = request.getParameter("tipo");
		int baja = Integer.parseInt(request.getParameter("baja"));
//		System.out.println("estoi es la prueba del registro "+nombre);
//		System.out.println("estoi es la prueba del registro "+apellido1);
//		System.out.println("estoi es la prueba del registro "+apellido2);
//		System.out.println("estoi es la prueba del registro "+email);
//		System.out.println("estoi es la prueba del registro "+dni);
//		System.out.println("estoi es la prueba del registro "+password);
//		System.out.println("estoi es la prueba del registro "+edad);
//		System.out.println("estoi es la prueba del registro "+tipo);

		OperacionesDB.registrarPersona(nombre, apellido1, apellido2, email, dni, password, edad, tipo, baja);
		Persona p = OperacionesDB.consultaUltimaPersona();
		OperacionesDB.registrarClientes(p.getId(), 1000, 1000, "normal");

		response.sendRedirect("login.jsp");
	}

}
