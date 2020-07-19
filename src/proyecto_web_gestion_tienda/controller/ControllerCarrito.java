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
				Producto p = OperacionesDB.buscarProductoId(session, id);
				@SuppressWarnings("unchecked")
				ArrayList<Producto> listaCarrito = (ArrayList<Producto>) mySession.getAttribute("productoCarritoLista");
				if (listaCarrito == null) {
					listaCarrito = new ArrayList<>();
					mySession.setAttribute("productoCarritoLista", listaCarrito);

				}
				if (listaCarrito != null) {
					listaCarrito.add(p);
				}
				for (Producto pro: listaCarrito) {
					sumaTotal += pro.getPrecioUnitarioSinIva()*cantidad;
				}
				mySession.setAttribute("cantidad", cantidad);
				mySession.setAttribute("sumaTotal", sumaTotal);
				request.getRequestDispatcher("carrito.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				request.getRequestDispatcher("carrito.jsp").forward(request, response);
			}
		
		
			

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mySession = request.getSession();
		ArrayList<Producto> listaCarrito = (ArrayList<Producto>)mySession.getAttribute("productoCarritoLista");
		DetallePedido pedido = new DetallePedido();
		request.setAttribute("listaProductos", listaCarrito);
		request.getRequestDispatcher("facturaCarrito.jsp").forward(request, response);
		

	}

}
