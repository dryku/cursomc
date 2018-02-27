package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Idproduto;
	private String nmproduto;
	private Double preco;
	
	
	@JsonBackReference
	@ManyToMany
	@JoinTable (name = "PRODUTO_CATEGORIA",
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();

	Produto() {
	}
	
	public Produto(Integer idproduto, String nmproduto, Double preco) {
		super();
		Idproduto = idproduto;
		this.nmproduto = nmproduto;
		this.preco = preco;
	}

	public Integer getIdproduto() {
		return Idproduto;
	}

	public void setIdproduto(Integer idproduto) {
		Idproduto = idproduto;
	}

	public String getNmproduto() {
		return nmproduto;
	}

	public void setNmproduto(String nmproduto) {
		this.nmproduto = nmproduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Idproduto == null) ? 0 : Idproduto.hashCode());
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
		Produto other = (Produto) obj;
		if (Idproduto == null) {
			if (other.Idproduto != null)
				return false;
		} else if (!Idproduto.equals(other.Idproduto))
			return false;
		return true;
	}

	
	

}