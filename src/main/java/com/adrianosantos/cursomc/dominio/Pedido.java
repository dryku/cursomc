package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
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
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpedido;

	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date dtapedido;
	// private String estadoPagamento;
	// private Integer estadoPgto;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pgto;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "enderecoentrega_id")
	private Endereco enderecoEntrega;

	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();

	public Pedido() {
	}

	public Pedido(Integer idpedido, Date dtapedido, Cliente cliente, Endereco enderecoEntrega) {
		super();
		this.setIdpedido(idpedido);
		this.setDtapedido(dtapedido);
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}

	public double getValorTotal() {
		double soma = 0.0;
		for (ItemPedido itemPedido : itens) {
			soma = soma + itemPedido.getSubTotal();
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

	public Pagamento getPgto() {
		return pgto;
	}

	public void setPgto(Pagamento pgto) {
		this.pgto = pgto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	/*
	 * public String getEstadoPAgamento() { return estadoPagamento; }
	 * 
	 * public void setEstadoPagamento(String estadoPagamento) { this.estadoPagamento
	 * = estadoPagamento; }
	 * 
	 * public Integer getEstadoPgto() { return estadoPgto; }
	 * 
	 * public void setEstadoPgto(Integer estadoPgto) { this.estadoPgto = estadoPgto;
	 * }
	 * 
	 */

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

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido Numero: ");
		builder.append(getIdpedido());
		builder.append(", Data: ");
		builder.append(sdf.format(getDtapedido()));
		builder.append(", Cliente : ");
		builder.append(getCliente().getNmcliente());
		builder.append(", Situação do Pedido: ");
		builder.append(getPgto().getEstadopgto().getDescricaoestadopgto());
		builder.append("\nDetalhe:\n");
		for (ItemPedido itemPedido : getItens()) {
			builder.append(itemPedido.toString());
		}
		builder.append("Valor Total: ");
		builder.append(nf.format(getValorTotal()));
		return builder.toString();
	}

}
