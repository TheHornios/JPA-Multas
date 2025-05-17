package es.ubu.lsi.model.multas;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INCIDENCIA database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i"),
	@NamedQuery(name = "Incidencia.deleteAllWithNIF", query = "DELETE FROM Incidencia i WHERE i.id.nif = :p"),
	@NamedQuery(name = "Incidencia.findByConductor", query = "SELECT i FROM Incidencia i WHERE i.id.nif = :nif")
})
public class Incidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IncidenciaPK id;

	@Lob
	private String anotacion;

	@MapsId("nif")
	@ManyToOne
	@JoinColumn(name = "NIF")
	private Conductor conductor;
	
	@ManyToOne
	@JoinColumn(name = "IDTIPO")
	private TipoIncidencia tipoIncidencia;

	public Incidencia() {
	}
	
	public Incidencia(IncidenciaPK id, String anotacion, Conductor conductor, TipoIncidencia tipoIncidencia) {
		this.id = id;
		this.anotacion = anotacion;
		this.conductor = conductor;
		this.tipoIncidencia = tipoIncidencia;
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

	public Conductor getConductor() {
		return this.conductor;
	}

	public void setConductor(Conductor conductor) {
	    if (this.conductor != null && this.conductor != conductor) {
	        this.conductor.getIncidencias().remove(this);
	    }

	    this.conductor = conductor;

	    if (conductor != null) {
	        conductor.getIncidencias().add(this);
	    }
	}
	
	public TipoIncidencia getTipoIncidencia() {
		return this.tipoIncidencia;
	}

	public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
	    if (this.tipoIncidencia != null && this.tipoIncidencia != tipoIncidencia) {
	        this.tipoIncidencia.getIncidencias().remove(this);
	    }

	    this.tipoIncidencia = tipoIncidencia;

	    if (tipoIncidencia != null) {
	        tipoIncidencia.getIncidencias().add(this);
	    }
	}
	
	@Override
	public String toString() {
		return "Incidencia [id= " + this.getId() + ", anotacion=" + this.getAnotacion() + ", conductor="
				+ this.getConductor() + ", tipoIncidencia=" + this.getTipoIncidencia() + "]";
	}
}