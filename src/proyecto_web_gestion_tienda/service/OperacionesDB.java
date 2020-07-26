package proyecto_web_gestion_tienda.service;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import proyecto_web_gestion_tienda.controller.ControllerLogin;
import proyecto_web_gestion_tienda.model.CabeceraPedido;
import proyecto_web_gestion_tienda.model.Cliente;
import proyecto_web_gestion_tienda.model.DetallePedido;
import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.model.Producto;
import proyecto_web_gestion_tienda.utils.HibernateUtil;

public class OperacionesDB {
	static Session session = HibernateUtil.getSessionFactory().openSession();
	private static Logger logger = LogManager.getLogger(ControllerLogin.class);
	static SessionFactory sessionFactory;

	public static Persona logIn(Session s, String email, String pass) {
		String hQuery = "from Persona p " + " where p.mail = :email" + " and p.pass = :pass";
		Persona p = s.createQuery(hQuery, Persona.class).setParameter("email", email).setParameter("pass", pass)
				.setMaxResults(1).uniqueResult();
		if (p != null) {
			System.out.println("login exitoso");
			logger.info(String.format("Cliente normal logeado."));
			return p;
		} else {
			System.out.println("credenciales no validas");
		}
		return null;

	}

	public static ArrayList<Persona> mostraTodasPersonas() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hQuery = " from Persona p";
		Query query = session.createQuery(hQuery);
		ArrayList<Persona> aProductos = (ArrayList<Persona>) query.list();
		if (aProductos != null) {
			return aProductos;
		} else {
//				System.out.println("credenciales no validas");
		}
		return null;

	}

	public static ArrayList<Producto> mostraTodoslosproductos() {
//			List<String> aProductos;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hQuery = " from Producto pro";
		Query query = session.createQuery(hQuery);
		@SuppressWarnings("unchecked")
		ArrayList<Producto> aProductos = (ArrayList<Producto>) query.list();
		if (aProductos != null) {
			return aProductos;
		} else {
//				System.out.println("credenciales no validas");
		}
		return null;

	}

	public static Producto buscarProductoId(Session s, int id) {

		String hQuery = "from Producto p " + " where p.id = :id";
		Producto p = s.createQuery(hQuery, Producto.class).setParameter("id", id).setMaxResults(1).uniqueResult();
		if (p != null) {
			System.out.println("poducto encontrado");
			return p;
		} else {
			System.out.println("no existe el id");
		}
		return null;

	}

	public static void actualizarStock(int id, int cantidad) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Query updateQuery = session
				.createQuery("UPDATE Producto p set p.stock=p.stock - '" + cantidad + "' where id='" + id + "'");
		updateQuery.executeUpdate();
		txn.commit();

	}

	public static void insertCabeceraPedido(int id, int importe_total) {

		Transaction txn = session.beginTransaction();
		Query query = session.createNativeQuery("INSERT INTO cabecera_pedido  (id_cliente,importe_total) VALUES(?,?)");
		query.setParameter(1, id);
		query.setParameter(2, importe_total);
		query.executeUpdate();
		txn.commit();

	}

	public static void insertDetallePedido(int idCabezera, int cabezera, int cantidad, int total) {
		Transaction txn = session.beginTransaction();
		Query query = session.createNativeQuery(
				"INSERT INTO detalle_pedido  (id_pedido, id_producto,cantidad,total_linea) VALUES(?,?,?,?)");
		query.setParameter(1, idCabezera);
		query.setParameter(2, cabezera);
		query.setParameter(3, cantidad);
		query.setParameter(4, total);
		query.executeUpdate();
		txn.commit();

	}

	public static CabeceraPedido consultaUltimoIdCabecera() {
		Query query = session.createQuery("from CabeceraPedido order by id  DESC");
		query.setMaxResults(1);
		CabeceraPedido last = (CabeceraPedido) query.uniqueResult();

		return last;
	}

	public static ArrayList<CabeceraPedido> mostrarCabeceraPedido(int cliente) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hQuery = "from CabeceraPedido c where c.cliente = '" + cliente + "'";
		Query query = session.createQuery(hQuery);
		ArrayList<CabeceraPedido> cabezeraPedido = (ArrayList<CabeceraPedido>) query.list();

		if (cabezeraPedido != null) {
			return cabezeraPedido;
		} else {
//			System.out.println("credenciales no validas");
		}
		return null;

	}

	public static ArrayList<DetallePedido> mostrarLineasPedido(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hQuery = "from DetallePedido de where de.cabeceraPedido ='" + id + "' ";
		Query query = session.createQuery(hQuery);
		@SuppressWarnings("unchecked")
		ArrayList<DetallePedido> listaFactura = (ArrayList<DetallePedido>) query.list();

		return listaFactura;

	}

	public static ArrayList<Producto> mostraTodoslosproductosLineasPedido(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hQuery = " from Producto pro where pro.id = '" + id + "'";
		Query query = session.createQuery(hQuery);
		@SuppressWarnings("unchecked")
		ArrayList<Producto> aProductos = (ArrayList<Producto>) query.list();
		if (aProductos != null) {
			return aProductos;
		} else {
//			System.out.println("credenciales no validas");
		}
		return null;

	}
	
	public static ArrayList<Producto> buscarPructoCaregoria(String categoria) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hQuery = " from Producto pro where pro.categoria = '" + categoria + "'";
		Query query = session.createQuery(hQuery);
		@SuppressWarnings("unchecked")
		ArrayList<Producto> aProductos = (ArrayList<Producto>) query.list();
		if (aProductos != null) {
			return aProductos;
		} else {
//			System.out.println("credenciales no validas");
		}
		return null;

	}
	
	public static Cliente buscarCategoriaCliente(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hQuery = " from Cliente c " + "  where c.persona =:persona";
		Cliente cli =  session.createQuery(hQuery, Cliente.class).setParameter("persona", id).setMaxResults(1).uniqueResult();
		if (cli!=null) {
			return cli;
		}else {
		System.out.println("categoria no encontrada");	
		}
		return null;
	} 
	
	public static ArrayList<Persona> buscarTipoCliente(String cliente1, String cliente2) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hQuery = " from Persona p where p.tipoPersona='"+cliente1+"'" + " or p.tipoPersona='"+cliente2+"'";
		Query query =  session.createQuery(hQuery);
		ArrayList<Persona> clientesTipo = (ArrayList<Persona>) query.list();
		if (clientesTipo!=null) {
			return clientesTipo;
		}else {
		System.out.println("categoria no encontrada");	
		}
		return null;
	}

}
