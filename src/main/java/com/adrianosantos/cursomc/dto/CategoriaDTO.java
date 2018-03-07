package com.adrianosantos.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.adrianosantos.cursomc.dominio.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idcategoria; 

	@NotEmpty(message="Campo não pode ser vazio")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nmcategoria;

	public CategoriaDTO(){};

	public CategoriaDTO(Categoria catDTO){
		this.idcategoria = catDTO.getIdcategoria();
		this.nmcategoria = catDTO.getNmcategoria();
	};
	
	
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

}
