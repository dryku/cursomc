package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedidoNew implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPKNew id = new ItemPedidoPKNew();
	private Double descontoitem;
	private Integer qtdItem;
	private Double precoitem;

	ItemPedidoNew() {
	}

	public ItemPedidoNew(PedidoNew pedido, Produto produto, Double descontoitem, Integer qtdItem, Double precoitem) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.descontoitem = descontoitem;
		this.qtdItem = qtdItem;
		this.precoitem = precoitem;
	}
	

	public double getSubTotal() {
		return (precoitem - descontoitem) * qtdItem;
	}


	@JsonIgnore
	public PedidoNew getPedido() {
		return id.getPedido();
	}

	public void setPedidoNew(PedidoNew pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void Produto(Produto produto) {
		id.setProduto(produto);
	}
	
	public ItemPedidoPKNew getId() {
		return id;
	}

	public void setId(ItemPedidoPKNew id) {
		this.id = id;
	}

	public Double getDescontoitem() {
		return descontoitem;
	}

	public void setDescontoitem(Double descontoitem) {
		this.descontoitem = descontoitem;
	}

	public Integer getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(Integer qtdItem) {
		this.qtdItem = qtdItem;
	}

	public Double getPrecoitem() {
		return precoitem;
	}

	public void setPrecoitem(Double precoitem) {
		this.precoitem = precoitem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItemPedidoNew other = (ItemPedidoNew) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
