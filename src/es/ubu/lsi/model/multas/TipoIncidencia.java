package es.ubu.lsi.model.multas;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the TIPOINCIDENCIA database table.
 * 
 */
@Entity
@NamedQuery(name="TipoIncidencia.findAll", query="SELECT t FROM TipoIncidencia t")
public class TipoIncidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String descripcion;

	private BigDecimal valor;
	
	@OneToMany(mappedBy = "tipoIncidencia")
	private Set<Incidencia> incidencias;

	public TipoIncidencia() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Set<Incidencia> getIncidencias() {
		return this.incidencias;
	}

	public void setIncidencias(Set<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}
	
	public void addIncidencia(Incidencia incidencia) {
	    if (incidencia == null) return;

	    Set<Incidencia> incidencias = getIncidencias();

	    if (incidencias.add(incidencia)) {
	        // Si la incidencia ya está asociada a otro tipo, se elimina de allí
	        TipoIncidencia tipoAnterior = incidencia.getTipoIncidencia();
	        if (tipoAnterior != null && tipoAnterior != this) {
	            tipoAnterior.getIncidencias().remove(incidencia);
	        }
	        // Asociar la incidencia a este tipo
	        incidencia.setTipoIncidencia(this);
	    }
	}

	public void removeIncidencia(Incidencia incidencia) {
	    if (incidencia == null) return;

	    if (getIncidencias().remove(incidencia)) {
	        if (incidencia.getTipoIncidencia() == this) {
	            incidencia.setTipoIncidencia(null);
	        }
	    }
	}
}