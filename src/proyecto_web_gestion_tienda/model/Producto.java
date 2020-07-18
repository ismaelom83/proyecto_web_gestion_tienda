package proyecto_web_gestion_tienda.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="borrado_logico")
	private byte borradoLogico;

	private byte canjeable;

	private String descripcion;

	private byte descuento;

	@Column(name="precio_unitario_sin_iva")
	private int precioUnitarioSinIva;

	@Column(name="ruta_imagen")
	private String rutaImagen;

	private int stock;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="producto")
	private List<DetallePedido> detallePedidos;

	//bi-directional one-to-one association to ValoracionesProducto
	@OneToOne(mappedBy="producto")
	private ValoracionesProducto valoracionesProducto;

	public Producto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getBorradoLogico() {
		return this.borradoLogico;
	}

	public void setBorradoLogico(byte borradoLogico) {
		this.borradoLogico = borradoLogico;
	}

	public byte getCanjeable() {
		return this.canjeable;
	}

	public void setCanjeable(byte canjeable) {
		this.canjeable = canjeable;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getDescuento() {
		return this.descuento;
	}

	public void setDescuento(byte descuento) {
		this.descuento = descuento;
	}

	public int getPrecioUnitarioSinIva() {
		return this.precioUnitarioSinIva;
	}

	public void setPrecioUnitarioSinIva(int precioUnitarioSinIva) {
		this.precioUnitarioSinIva = precioUnitarioSinIva;
	}

	public String getRutaImagen() {
		return this.rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setProducto(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setProducto(null);

		return detallePedido;
	}

	public ValoracionesProducto getValoracionesProducto() {
		return this.valoracionesProducto;
	}

	public void setValoracionesProducto(ValoracionesProducto valoracionesProducto) {
		this.valoracionesProducto = valoracionesProducto;
	}

}