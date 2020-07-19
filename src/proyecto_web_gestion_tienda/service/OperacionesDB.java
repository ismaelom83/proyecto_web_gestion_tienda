package proyecto_web_gestion_tienda.service;

import java.util.ArrayList;



import org.hibernate.Session;
import org.hibernate.query.Query;

import proyecto_web_gestion_tienda.model.Persona;
import proyecto_web_gestion_tienda.model.Producto;



public class OperacionesDB {
	
	
		public static Persona logIn(Session s, String email,String pass) {
			String hQuery = "from Persona p " + " where p.mail = :email"+" and p.pass = :pass";
			Persona p = s.createQuery(hQuery, Persona.class).setParameter("email", email).setParameter("pass", pass).setMaxResults(1).uniqueResult();
			System.out.println(p);
			if (p != null) {
				System.out.println("login exitoso");
				return p;
			} else {
				System.out.println("credenciales no validas");
			}
			return null;

		}
		
		public static ArrayList<Persona> mostraTodasPersonas(Session session) {
//			List<String> aProductos;
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
		
		public static ArrayList<Producto> mostraTodoslosproductos(Session session) {
//			List<String> aProductos;
			String hQuery = " from Producto pro";
		Query query = session.createQuery(hQuery);
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
		
		
}
