package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Integer idpedido;
	private Date dtapedido;

	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pgto;


	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente  cliente;

	@ManyToOne
	@JoinColumn(name="enderecoentrega_id")
	private Endereco enderecoEntrega;
	
	public Pedido() {}

	public Pedido(Integer idpedido, Date dtapedido, Cliente cliente, Endereco enderecoEntrega) {
		super();
		this.setIdpedido(idpedido);
		this.setDtapedido(dtapedido);
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}

	public Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

	public Date getDtapedido() {
		return dtapedido;
	}

	public void setDtapedido(Date dtapedido) {
		this.dtapedido = dtapedido;
	}

	public Pagamento getPgto() {
		return pgto;
	}

	public void setPgto(Pagamento pgto) {
		this.pgto = pgto;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpedido == null) ? 0 : idpedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (idpedido == null) {
			if (other.idpedido != null)
				return false;
		} else if (!idpedido.equals(other.idpedido))
			return false;
		return true;
	}


	

}