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
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import proyecto_web_gestion_tienda.model.CabeceraPedido;
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
	private static Logger logger = LogManager.getLogger(ControllerCarrito.class);
	static SessionFactory sessionFactory;

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
		int sumaTotal = 0;
		try {

			int id = Integer.parseInt(request.getParameter("idProductoCarrito"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			Producto p = OperacionesDB.buscarProductoId(session, id);
			p.setCantidad(cantidad);
			
			mySession.setAttribute("producto", p);
			
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaLogeada2 = (ArrayList<Producto>) mySession.getAttribute("listaLogeada");		
			
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


			if (listaCarrito != null) {
				listaCarrito.add(p);
			}
			for (Producto pro : listaCarrito) {
				sumaTotal += pro.getPrecioUnitarioSinIva() * pro.getCantidad();
			}
			mySession.setAttribute("sumaTotal", sumaTotal);
			request.getRequestDispatcher("carrito.jsp").forward(request, response);

		} catch (NumberFormatException e) {
				
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaLogeada2 = (ArrayList<Producto>) mySession.getAttribute("listaLogeada");
			
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
			
			int idLogeado2 = (int)mySession.getAttribute("idLogeado");
			request.getRequestDispatcher("carrito.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession mySession = request.getSession();

		if (mySession.getAttribute("persona") != null && mySession.getAttribute("productoCarritoLista") != null) {

	ArrayList<Producto>	listaFactuta =	(ArrayList<Producto>) mySession.getAttribute("productoCarritoLista");
	
	for (Producto producto : listaFactuta) {
		OperacionesDB.actualizarStock(producto.getId(), producto.getCantidad());
	}
	
	
	
   int sumaTotal=(int)mySession.getAttribute("sumaTotal");
	Persona per=(Persona)mySession.getAttribute("personaCompleta");
		OperacionesDB.insertCabeceraPedido(per.getId(),sumaTotal);
		CabeceraPedido cabezera = new CabeceraPedido();
		 cabezera = OperacionesDB.consultaUltimoIdCabecera();
		for (Producto producto : listaFactuta) {
			OperacionesDB.insertDetallePedido(cabezera.getId(),producto.getId(),producto.getCantidad(),producto.getPrecioUnitarioSinIva()*producto.getCantidad());
		}
	
		
	 
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
