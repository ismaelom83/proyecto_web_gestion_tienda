package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;

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

import proyecto_web_gestion_tienda.model.Producto;
import proyecto_web_gestion_tienda.service.OperacionesDB;
import proyecto_web_gestion_tienda.utils.HibernateUtil;

@WebServlet("/BorrarCarrito")
public class BorrarCarrito extends HttpServlet {

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

	
	@SuppressWarnings({ "null", "unlikely-arg-type" })
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mySession = request.getSession();
		int sumaTotal = 0;
		if (mySession.getAttribute("persona") != null) {
			int idBorrar = Integer.parseInt(request.getParameter("idProductoBorrar"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaCarrito = (ArrayList<Producto>) mySession.getAttribute("productoCarritoLista");
			Producto pro1 = null;
			for (Producto producto : listaCarrito) {
				if (producto.getId() == idBorrar) {
					pro1 = producto;
				}
			}
			if (pro1 != null) {
				listaCarrito.remove(pro1);
			}
			if (listaCarrito.isEmpty()) {
				mySession.getAttribute("sumaTotal");
				mySession.removeAttribute("sumaTotal");
			}
			for (Producto pro: listaCarrito) {
				sumaTotal -= pro.getPrecioUnitarioSinIva()*cantidad;
			}
			mySession.setAttribute("sumaTotal", sumaTotal);
			mySession.setAttribute("cantidad", cantidad);

			request.getRequestDispatcher("carrito.jsp").forward(request, response);
//				mySession.setAttribute("productoCarritoLista", listaCarrito);
		} else {
			int idBorrar = Integer.parseInt(request.getParameter("idProductoBorrar"));
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaCarrito = (ArrayList<Producto>) mySession.getAttribute("productoCarritoLista2");
			Producto pro1 = null;
			for (Producto producto : listaCarrito) {
				if (producto.getId() == idBorrar) {
					pro1 = producto;
				}
			}
			if (pro1 != null) {
				listaCarrito.remove(pro1);
			}
			if (listaCarrito.isEmpty()) {
				mySession.getAttribute("sumaTotal");
				mySession.removeAttribute("sumaTotal");
			}

			request.getRequestDispatcher("carritoNologeado.jsp").forward(request, response);

//				mySession.setAttribute("productoCarritoLista", listaCarrito)

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


}
