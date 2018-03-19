package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idendereco;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente çliente;

	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;

	public Endereco() {
	}

	public Endereco(Integer idendereco, String logradouro, String numero, String complemento, String bairro, String cep,
			Cliente çliente, Cidade cidade) {
		super();
		this.idendereco = idendereco;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.çliente = çliente;
		this.cidade = cidade;
	}

	public Integer getIdendereco() {
		return idendereco;
	}

	public void setIdendereco(Integer idendereco) {
		this.idendereco = idendereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setCompremento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente getÇliente() {
		return çliente;
	}

	public void setÇliente(Cliente çliente) {
		this.çliente = çliente;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setÇidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idendereco == null) ? 0 : idendereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (idendereco == null) {
			if (other.idendereco != null)
				return false;
		} else if (!idendereco.equals(other.idendereco))
			return false;
		return true;
	}

}
