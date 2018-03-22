package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.adrianosantos.cursomc.dominio.enums.EstadoPgto;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idpgto;
	private Integer estadopgto;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {}
	
	public Pagamento(Integer idpgto, EstadoPgto estadopgto, Pedido pedido) {
		super();
		this.idpgto = idpgto;
		this.estadopgto = estadopgto.getCodestadopgto();
		this.pedido = pedido;
	}

	public Integer getIdpgto() {
		return idpgto;
	}

	public void setIdpgto(Integer idpgto) {
		this.idpgto = idpgto;
	}

	public EstadoPgto getEstadopgto() {
		return EstadoPgto.toEnum(estadopgto);
	}

	public void setEstadopgto(EstadoPgto estadopgto) {
		this.estadopgto = estadopgto.getCodestadopgto();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpgto == null) ? 0 : idpgto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (idpgto == null) {
			if (other.idpgto != null)
				return false;
		} else if (!idpgto.equals(other.idpgto))
			return false;
		return true;
	}

}
