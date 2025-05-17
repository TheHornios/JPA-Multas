package es.ubu.lsi.model.multas;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INCIDENCIA database table.
 * 
 */
@Entity
@NamedQuery(name="Incidencia.findAll", query="SELECT i FROM Incidencia i")
public class Incidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IncidenciaPK id;

	@Lob
	private String anotacion;

	private java.math.BigDecimal idtipo;

	public Incidencia() {
	}

	public IncidenciaPK getId() {
		return this.id;
	}

	public void setId(IncidenciaPK id) {
		this.id = id;
	}

	public String getAnotacion() {
		return this.anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	public java.math.BigDecimal getIdtipo() {
		return this.idtipo;
	}

	public void setIdtipo(java.math.BigDecimal idtipo) {
		this.idtipo = idtipo;
	}

}