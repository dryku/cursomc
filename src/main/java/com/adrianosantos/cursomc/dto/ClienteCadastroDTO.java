package com.adrianosantos.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.adrianosantos.cursomc.services.validation.InserirCliente;

@InserirCliente
public class ClienteCadastroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nmcliente;
	private String emailcliente;

	@NotEmpty(message="Preenchimento Obrigátorio")
	private String cpfOuCnpj;
	private Integer tipoCliente;

	private Integer idendeco;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	private String telefone1; 
	private String telefone2; 
	private String telefone3;
	

	public ClienteCadastroDTO() {}
	
	public String getNmcliente() {
		return nmcliente;
	}

	public void setNmcliente(String nmcliente) {
		this.nmcliente = nmcliente;
	}

	public String getEmailcliente() {
		return emailcliente;
	}

	public void setEmailcliente(String emailcliente) {
		this.emailcliente = emailcliente;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Integer getIdendeco() {
		return idendeco;
	}

	public void setIdendeco(Integer idendeco) {
		this.idendeco = idendeco;
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

	public void setComplemento(String complemento) {
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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	private Integer cidade;
	
}
