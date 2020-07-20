package proyecto_web_gestion_tienda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import proyecto_web_gestion_tienda.model.Producto;
import proyecto_web_gestion_tienda.service.OperacionesDB;
import proyecto_web_gestion_tienda.utils.HibernateUtil;
@WebServlet("/ControllerProductoId")
public class ControllerProductoId extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Session session =	HibernateUtil.getSessionFactory().openSession();
private static Logger logger = LogManager.getLogger(ControllerLogin.class);
	static SessionFactory sessionFactory;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int id = Integer.parseInt(request.getParameter("idProducto"));
	Producto p =	OperacionesDB.buscarProductoId(session,id);
	System.out.println(p.getPrecioUnitarioSinIva());
	request.setAttribute("productoId", p);
	request.getRequestDispatcher("producto.jsp").forward(request, response);
				
	}	
}
