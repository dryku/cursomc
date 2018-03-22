package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	private Double descontoitem;
	private Integer qtdItem;
	private Double precoitem;

	ItemPedido() {
	}

	public ItemPedido(Pedido pedido, Produto produto, Double descontoitem, Integer qtdItem, Double precoitem) {
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
	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		StringBuilder builder = new StringBuilder();
		builder.append(getProduto().getNmproduto());
		builder.append(", Qtd: ");
		builder.append(getQtdItem());
		builder.append(", Preço Unidade: ");
		builder.append(nf.format(getPrecoitem()));
		builder.append(", Sub Total: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n\n");		
		return builder.toString();
	}

	
	
}
