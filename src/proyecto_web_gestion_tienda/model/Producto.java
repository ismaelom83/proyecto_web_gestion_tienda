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
	
	private int cantidad;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="producto")
	private List<DetallePedido> detallePedidos;

	//bi-directional one-to-one association to ValoracionesProducto
	@OneToOne(mappedBy="producto")
	private ValoracionesProducto valoracionesProducto;
	
	

	public Producto() {
	}

	
	
	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + borradoLogico;
		result = prime * result + canjeable;
		result = prime * result + cantidad;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + descuento;
		result = prime * result + ((detallePedidos == null) ? 0 : detallePedidos.hashCode());
		result = prime * result + id;
		result = prime * result + precioUnitarioSinIva;
		result = prime * result + ((rutaImagen == null) ? 0 : rutaImagen.hashCode());
		result = prime * result + stock;
		result = prime * result + ((valoracionesProducto == null) ? 0 : valoracionesProducto.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (borradoLogico != other.borradoLogico)
			return false;
		if (canjeable != other.canjeable)
			return false;
		if (cantidad != other.cantidad)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (descuento != other.descuento)
			return false;
		if (detallePedidos == null) {
			if (other.detallePedidos != null)
				return false;
		} else if (!detallePedidos.equals(other.detallePedidos))
			return false;
		if (id != other.id)
			return false;
		if (precioUnitarioSinIva != other.precioUnitarioSinIva)
			return false;
		if (rutaImagen == null) {
			if (other.rutaImagen != null)
				return false;
		} else if (!rutaImagen.equals(other.rutaImagen))
			return false;
		if (stock != other.stock)
			return false;
		if (valoracionesProducto == null) {
			if (other.valoracionesProducto != null)
				return false;
		} else if (!valoracionesProducto.equals(other.valoracionesProducto))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Producto [id=" + id + ", cantidad=" + cantidad + ", borradoLogico=" + borradoLogico + ", canjeable="
				+ canjeable + ", descripcion=" + descripcion + ", descuento=" + descuento + ", precioUnitarioSinIva="
				+ precioUnitarioSinIva + ", rutaImagen=" + rutaImagen + ", stock=" + stock + ", detallePedidos="
				+ detallePedidos + ", valoracionesProducto=" + valoracionesProducto + "]";
	}


	

	
	
	
}