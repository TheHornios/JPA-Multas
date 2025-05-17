package es.ubu.lsi.model.multas;

import javax.persistence.*;

@Embeddable 
public class DireccionPostal {
	private String direccion;
	private String cp;
	private String ciudad;
	
	// Metodos get y set 
	
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
