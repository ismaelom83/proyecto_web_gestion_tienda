package proyecto_web_gestion_tienda.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String apellido1;

	private String apellido2;

	@Column(name="baja_logica")
	private byte bajaLogica;

	private String dni;


	
	private byte edad;

//	@Column(name="mail")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	private String mail;

	private String nombre;

	private String pass;

	private String sexo;

	@Column(name="tipo_persona")
	private String tipoPersona;

//	//bi-directional many-to-one association to Cliente
////	@OneToMany(mappedBy="persona")
//	private List<Cliente> clientes;
//
//	//bi-directional many-to-one association to Mensajeria
////	@OneToMany(mappedBy="persona")
//	private List<Mensajeria> mensajerias;
//
//	//bi-directional many-to-one association to Trabajadore
////	@OneToMany(mappedBy="persona")
//	private List<Trabajadore> trabajadores;

	public Persona() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public byte getBajaLogica() {
		return this.bajaLogica;
	}

	public void setBajaLogica(byte bajaLogica) {
		this.bajaLogica = bajaLogica;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public byte getEdad() {
		return this.edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoPersona() {
		return this.tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

//	public List<Cliente> getClientes() {
//		return this.clientes;
//	}
//
//	public void setClientes(List<Cliente> clientes) {
//		this.clientes = clientes;
//	}

//	public Cliente addCliente(Cliente cliente) {
//		getClientes().add(cliente);
//		cliente.setPersona(this);
//
//		return cliente;
//	}
//
//	public Cliente removeCliente(Cliente cliente) {
//		getClientes().remove(cliente);
//		cliente.setPersona(null);
//
//		return cliente;
//	}

//	public List<Mensajeria> getMensajerias() {
//		return this.mensajerias;
//	}
//
//	public void setMensajerias(List<Mensajeria> mensajerias) {
//		this.mensajerias = mensajerias;
//	}

//	public Mensajeria addMensajeria(Mensajeria mensajeria) {
//		getMensajerias().add(mensajeria);
//		mensajeria.setPersona(this);
//
//		return mensajeria;
//	}
//
//	public Mensajeria removeMensajeria(Mensajeria mensajeria) {
//		getMensajerias().remove(mensajeria);
//		mensajeria.setPersona(null);
//
//		return mensajeria;
//	}

//	public List<Trabajadore> getTrabajadores() {
//		return this.trabajadores;
//	}
//
//	public void setTrabajadores(List<Trabajadore> trabajadores) {
//		this.trabajadores = trabajadores;
//	}

//	public Trabajadore addTrabajadore(Trabajadore trabajadore) {
//		getTrabajadores().add(trabajadore);
//		trabajadore.setPersona(this);
//
//		return trabajadore;
//	}
//
//	public Trabajadore removeTrabajadore(Trabajadore trabajadore) {
//		getTrabajadores().remove(trabajadore);
//		trabajadore.setPersona(null);
//
//		return trabajadore;
//	}

}