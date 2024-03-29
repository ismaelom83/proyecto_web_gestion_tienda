package proyecto_web_gestion_tienda.controller;

import java.io.IOException;
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

@WebServlet("/ControllerCarritoNologeado")
public class ControllerCarritoNologeado extends HttpServlet {

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
	
	
	
	public ControllerCarritoNologeado() {
		super();
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mySession = request.getSession(true);
		int sumaTotal = 0;
		try {
			int id = Integer.parseInt(request.getParameter("idProductoCarrito"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			Producto p = OperacionesDB.buscarProductoId(session, id);
			p.setCantidad(cantidad);
		    mySession.setAttribute("idLogeado", id);
		    mySession.setAttribute("cantidadLogeado", cantidad);
			@SuppressWarnings("unchecked")
			ArrayList<Producto> listaCarrito = (ArrayList<Producto>) mySession.getAttribute("productoCarritoLista2");
			if (listaCarrito == null) {
				listaCarrito = new ArrayList<>();
				mySession.setAttribute("productoCarritoLista2", listaCarrito);

			}
			
			if (listaCarrito!= null) {
				listaCarrito.add(p);
			}
			for (Producto pro: listaCarrito) {
				sumaTotal += pro.getPrecioUnitarioSinIva()*cantidad;
			}
			mySession.setAttribute("cantidad", cantidad);
			mySession.setAttribute("sumaTotal", sumaTotal);
			request.getRequestDispatcher("carritoNologeado.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			request.getRequestDispatcher("carritoNologeado.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	

}
