package proyecto_web_gestion_tienda.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String categoria;

	private int puntos;

	private double saldo;

	//bi-directional many-to-one association to CabeceraPedido
	@OneToMany(mappedBy="cliente")
	private List<CabeceraPedido> cabeceraPedidos;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<CabeceraPedido> getCabeceraPedidos() {
		return this.cabeceraPedidos;
	}

	public void setCabeceraPedidos(List<CabeceraPedido> cabeceraPedidos) {
		this.cabeceraPedidos = cabeceraPedidos;
	}

	public CabeceraPedido addCabeceraPedido(CabeceraPedido cabeceraPedido) {
		getCabeceraPedidos().add(cabeceraPedido);
		cabeceraPedido.setCliente(this);

		return cabeceraPedido;
	}

	public CabeceraPedido removeCabeceraPedido(CabeceraPedido cabeceraPedido) {
		getCabeceraPedidos().remove(cabeceraPedido);
		cabeceraPedido.setCliente(null);

		return cabeceraPedido;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}