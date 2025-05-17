package es.ubu.lsi.model.multas;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CONDUCTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Conductor.findAll", query="SELECT c FROM Conductor c")
public class Conductor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String nif;

	private String apellido;

	private String ciudad;

	private String cp;

	private String direccion;

	private String idauto;

	private String nombre;

	private BigDecimal puntos;

	public Conductor() {
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getIdauto() {
		return this.idauto;
	}

	public void setIdauto(String idauto) {
		this.idauto = idauto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPuntos() {
		return this.puntos;
	}

	public void setPuntos(BigDecimal puntos) {
		this.puntos = puntos;
	}

}