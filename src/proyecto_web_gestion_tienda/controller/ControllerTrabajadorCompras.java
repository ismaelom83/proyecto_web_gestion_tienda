package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_web_gestion_tienda.model.CabeceraPedido;
import proyecto_web_gestion_tienda.model.DetallePedido;
import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.service.OperacionesDB;

@WebServlet("/ControllerTrabajadorCompras")
public class ControllerTrabajadorCompras extends HttpServlet {

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

		try {
			int idClientePedido = Integer.parseInt(request.getParameter("idClientePedido"));
			ArrayList<CabeceraPedido> cabeceraPedido2 = null;
			cabeceraPedido2 = OperacionesDB.mostrarCabeceraPedido(idClientePedido);
			request.setAttribute("cabeceraPedidos2", cabeceraPedido2);
			request.getRequestDispatcher("cabeceraPedidoTrabajador.jsp").forward(request, response);
			System.out.println("hola ismael");
		} catch (NumberFormatException e) {
			ArrayList<Persona> aPersonas;
			aPersonas = OperacionesDB.buscarTipoCliente("CP", "CN");
			for (Persona persona : aPersonas) {
				System.out.println("nombre1: " + persona.getNombre());
			}
			System.out.println("hola ismael");
			request.setAttribute("todasPersonas", aPersonas);
			request.getRequestDispatcher("trabajadorCompras.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int lProductos2 = 0;
		int id = Integer.parseInt(request.getParameter("idCabeceraPedido2"));
		ArrayList<DetallePedido> listaFactrura3 = OperacionesDB.mostrarLineasPedido(id);
		System.out.println("Esto es el controllr del trabjador de compras2" + listaFactrura3);
		for (DetallePedido detallePedido : listaFactrura3) {
			lProductos2 += detallePedido.getTotalLinea();
		}
		request.setAttribute("sTotal2", lProductos2);
		request.setAttribute("lineasPedido2", listaFactrura3);
		request.getRequestDispatcher("mostrarfactura.jsp").forward(request, response);
	

	}
}
