package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

import antlr.collections.List;
import empresa.modelo.OpreracionesTrabajadores;
import proyecto_web_gestion_tienda.model.DetallePedido;
import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.model.Producto;
import proyecto_web_gestion_tienda.service.OperacionesDB;
import proyecto_web_gestion_tienda.utils.HibernateUtil;

@WebServlet("/ControllerCarrito")
public class ControllerCarrito extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Session session = HibernateUtil.getSessionFactory().openSession();
	private static Logger logger = LogManager.getLogger(ControllerLogin.class);
	static SessionFactory sessionFactory;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mySession = request.getSession();
		int sumaTotal = 0;
		try {

			int id = Integer.parseInt(request.getParameter("idProductoCarrito"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			System.out.println("esta es la camtidad "+cantidad);
			OperacionesDB.insertarCantidad(session, id, cantidad);
			Producto p = OperacionesDB.buscarProductoId(session, id);
			System.out.println("esta deberia de ser la cantidad "+p.getCantidad());
			
			
			
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaLogeada2 = (ArrayList<Producto>) mySession.getAttribute("listaLogeada");
			
			System.out.println("a qui deberia de estar e n  el controlador " + listaLogeada2);
			
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaCarrito = (ArrayList<Producto>) mySession.getAttribute("productoCarritoLista");
			if (listaCarrito == null) {
				listaCarrito = new ArrayList<>();
				if (mySession.getAttribute("listaLogeada")!=null) {
					System.out.println("deberia entrar aqui");
					mySession.setAttribute("productoCarritoLista", listaLogeada2);
				}else {
					System.out.println("aqiu no deberia");
					mySession.setAttribute("productoCarritoLista", listaCarrito);
					
				}				
			}
			
			System.out.println("este es my carrito "+listaCarrito);


			if (listaCarrito != null) {
				listaCarrito.add(p);
			}
			for (Producto pro : listaCarrito) {
				sumaTotal += pro.getPrecioUnitarioSinIva() * cantidad;
			}
			mySession.setAttribute("sumaTotal", sumaTotal);
			request.getRequestDispatcher("carrito.jsp").forward(request, response);

		} catch (NumberFormatException e) {
				
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaLogeada2 = (ArrayList<Producto>) mySession.getAttribute("listaLogeada");
			
			System.out.println("a qui deberia de estar e n  el controlador " + listaLogeada2);
			
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaCarrito = (ArrayList<Producto>) mySession.getAttribute("productoCarritoLista");
			if (listaCarrito == null) {
				listaCarrito = new ArrayList<>();
				if (mySession.getAttribute("listaLogeada")!=null) {
					mySession.setAttribute("productoCarritoLista", listaLogeada2);
				}else {
					mySession.setAttribute("productoCarritoLista", listaCarrito);
					
				}				
			}		
			System.out.println("este es my carrito "+listaCarrito);
			request.getRequestDispatcher("carrito.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession mySession = request.getSession();

		if (mySession.getAttribute("persona") != null && mySession.getAttribute("productoCarritoLista") != null) {

			request.getRequestDispatcher("facturaCarrito.jsp").forward(request, response);

		} else {
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaLogeada = (ArrayList<Producto>) mySession.getAttribute("productoCarritoLista2");
			mySession.setAttribute("listaLogeada", listaLogeada);
			DetallePedido factura = new DetallePedido();
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
