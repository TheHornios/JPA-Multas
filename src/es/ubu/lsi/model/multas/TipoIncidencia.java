package es.ubu.lsi.model.multas;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TIPOINCIDENCIA database table.
 * 
 */
@Entity
@NamedQuery(name="TipoIncidencia.findAll", query="SELECT t FROM TipoIncidencia t")
public class TipoIncidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String descripcion;

	private BigDecimal valor;

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

}