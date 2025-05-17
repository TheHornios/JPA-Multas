package es.ubu.lsi.model.multas;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the CONDUCTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Conductor.findAll", query="SELECT c FROM Conductor c")
public class Conductor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nif;

	private String apellido;

	@ManyToOne
	@JoinColumn(name = "IDAUTO")
	private Vehiculo vehiculo;

	@OneToMany(mappedBy = "conductor")
	private Set<Incidencia> incidencias;
	
	private String nombre;

	private BigDecimal puntos;

	@Embedded
	private DireccionPostal direccionPostal;
	
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
	
	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
	    if (this.vehiculo != null && this.vehiculo != vehiculo) {
	        this.vehiculo.getConductores().remove(this);
	    }

	    this.vehiculo = vehiculo;

	    if (vehiculo != null) {
	        vehiculo.getConductores().add(this);
	    }
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
	        Conductor anterior = incidencia.getConductor();
	        if (anterior != null && anterior != this) {
	            anterior.getIncidencias().remove(incidencia);
	        }
	        incidencia.setConductor(this);
	    }
	}

	public void removeIncidencia(Incidencia incidencia) {
	    if (incidencia == null) return;

	    if (getIncidencias().remove(incidencia)) {
	        if (incidencia.getConductor() == this) {
	            incidencia.setConductor(null);
	        }
	    }
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
	
	
	public void setDireccionPostal(DireccionPostal direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public DireccionPostal getDireccionPostal() {
		return this.direccionPostal;
	}

	@Override
	public String toString() {

		return "Conductor [nif=" + this.getNif() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido()
				+ ", direccionPostal=" + this.getDireccionPostal() + ", puntos=" + this.getPuntos() + "]";
	}

}