package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcategoria; 
	private String nmcategoria;
	
	@JsonManagedReference
	@ManyToMany (mappedBy="categorias")	
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {};
	

	public Categoria(Integer idcategoria, String nmcategoria) {
		super();
		this.idcategoria = idcategoria;
		this.nmcategoria = nmcategoria;
	}


	public Integer getIdcategoria() {
		return idcategoria;
	}


	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}


	public String getNmcategoria() {
		return nmcategoria;
	}


	public void setNmcategoria(String nmcategoria) {
		this.nmcategoria = nmcategoria;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcategoria == null) ? 0 : idcategoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (idcategoria == null) {
			if (other.idcategoria != null)
				return false;
		} else if (!idcategoria.equals(other.idcategoria))
			return false;
		return true;
	}
	
}