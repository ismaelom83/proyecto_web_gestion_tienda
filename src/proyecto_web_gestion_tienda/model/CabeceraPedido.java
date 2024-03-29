package proyecto_web_gestion_tienda.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the cabecera_pedido database table.
 * 
 */
@Entity
@Table(name="cabecera_pedido")
@NamedQuery(name="CabeceraPedido.findAll", query="SELECT c FROM CabeceraPedido c")
public class CabeceraPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="importe_total")
	private int importeTotal;

//	@Column(name="num_pedido")
//	private int numPedido;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to DetallePedido
//	@OneToMany(mappedBy="cabeceraPedido")
//	private List<DetallePedido> detallePedidos;

	public CabeceraPedido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getImporteTotal() {
		return this.importeTotal;
	}

	public void setImporteTotal(int importeTotal) {
		this.importeTotal = importeTotal;
	}

//	public int getNumPedido() {
//		return this.numPedido;
//	}
//
//	public void setNumPedido(int numPedido) {
//		this.numPedido = numPedido;
//	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

//	public List<DetallePedido> getDetallePedidos() {
//		return this.detallePedidos;
//	}
//
//	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
//		this.detallePedidos = detallePedidos;
//	}

//	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
//		getDetallePedidos().add(detallePedido);
//		detallePedido.setCabeceraPedido(this);
//
//		return detallePedido;
//	}
//
//	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
//		getDetallePedidos().remove(detallePedido);
//		detallePedido.setCabeceraPedido(null);
//
//		return detallePedido;
//	}

}