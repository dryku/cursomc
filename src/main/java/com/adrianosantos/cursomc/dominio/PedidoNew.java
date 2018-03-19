package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PedidoNew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpedido;

	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date dtapedido;
	private String estadoPagamento;
	private Integer estadoPgto;

/*	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pgto;
*/
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente clientePedido;

	@ManyToOne
	@JoinColumn(name = "enderecoentrega_id")
	private Endereco enderecoEntrega;

	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedidoNew> itens = new HashSet<>();

	public PedidoNew() {
	}

	public PedidoNew(Integer idpedido, Date dtapedido, Cliente cliente, Endereco enderecoEntrega) {
		super();
		this.setIdpedido(idpedido);
		this.setDtapedido(dtapedido);
		this.clientePedido = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}

	public double getValorTotal() {
		double soma = 0.0;
		for (ItemPedidoNew itemPedidoNew : itens) {
			soma = soma + itemPedidoNew.getSubTotal();
		}
		return soma;
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

/*    public Pagamento getPgto() {
		return pgto;
	}

	public void setPgto(Pagamento pgto) {
		this.pgto = pgto;
	}
*/

	public Cliente getClientePedido() {
		return clientePedido;
	}

	public void setClientePedido(Cliente clientepedido) {
		this.clientePedido = clientepedido;
	}
	
	
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Set<ItemPedidoNew> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedidoNew> itens) {
		this.itens = itens;
	}
	
	public String getEstadoPAgamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(String estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

	public Integer getEstadoPgto() {
		return estadoPgto;
	}

	public void setEstadoPgto(Integer estadoPgto) {
		this.estadoPgto = estadoPgto;
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
		PedidoNew other = (PedidoNew) obj;
		if (idpedido == null) {
			if (other.idpedido != null)
				return false;
		} else if (!idpedido.equals(other.idpedido))
			return false;
		return true;
	}


}
