package proyecto_web_gestion_tienda.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the valoraciones_productos database table.
 * 
 */
@Entity
@Table(name="valoraciones_productos")
@NamedQuery(name="ValoracionesProducto.findAll", query="SELECT v FROM ValoracionesProducto v")
public class ValoracionesProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String comentarios;

	private String valoración;

	//bi-directional one-to-one association to Producto
	@OneToOne
	@JoinColumn(name="id")
	private Producto producto;

	public ValoracionesProducto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getValoración() {
		return this.valoración;
	}

	public void setValoración(String valoración) {
		this.valoración = valoración;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}