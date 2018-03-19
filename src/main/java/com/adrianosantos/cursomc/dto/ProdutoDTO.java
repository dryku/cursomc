package com.adrianosantos.cursomc.dto;

import java.io.Serializable;

import com.adrianosantos.cursomc.dominio.Produto;

public class ProdutoDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer Idproduto;
	private String nmproduto;
	private Double preco;
	
	public ProdutoDTO() {}

	public ProdutoDTO(Produto obj) {
		Idproduto = obj.getidProduto();
		nmproduto = obj.getNmproduto();
		preco = obj.getPreco();
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
	
	
}
