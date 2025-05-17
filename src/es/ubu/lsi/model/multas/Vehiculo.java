package es.ubu.lsi.model.multas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the VEHICULO database table.
 * 
 */
@Entity
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")

@NamedEntityGraphs({
	@NamedEntityGraph(name = "Vehiculo.graph", attributeNodes = {
			@NamedAttributeNode(value = "conductores", subgraph = "conductoresGraph")
	}, subgraphs = {
			@NamedSubgraph(name = "conductoresGraph", attributeNodes = {
					@NamedAttributeNode(value = "incidencias", subgraph = "incidenciasGraph")
			}),
			@NamedSubgraph(name = "incidenciasGraph", attributeNodes = {
					@NamedAttributeNode(value = "tipoIncidencia")
			})
	})
})
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idauto;

	@Embedded 
	private DireccionPostal direccionPostal;

	private String nombre;
	
	@OneToMany(mappedBy = "vehiculo")
	private Set<Conductor> conductores;

	public Vehiculo() {
	}

	public String getIdauto() {
		return this.idauto;
	}

	public void setIdauto(String idauto) {
		this.idauto = idauto;
	}

	public void setDireccionPostal(DireccionPostal direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public DireccionPostal getDireccionPostal() {
		return this.direccionPostal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Conductor> getConductores() {
		return this.conductores;
	}

	public void setConductores(Set<Conductor> conductores) {
		this.conductores = conductores;
	}

	public void addConductor(Conductor conductor) {
	    if (conductor == null) return;

	    Set<Conductor> conductores = getConductores();

	    // Solo agregamos si no está ya en el set
	    if (conductores.add(conductor)) {
	        // Si ya tenía un vehículo lo eliminamos de ese vehículo
	        Vehiculo vehiculoAnterior = conductor.getVehiculo();
	        if (vehiculoAnterior != null && vehiculoAnterior != this) {
	            vehiculoAnterior.getConductores().remove(conductor);
	        }
	        conductor.setVehiculo(this);
	    }
	}


	public void removeConductor(Conductor conductor) {
	    if (conductor == null) return;
	    
	    if (getConductores().remove(conductor)) {
	        conductor.setVehiculo(null);
	    }
	}
}