package com.adrianosantos.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.adrianosantos.cursomc.dominio.Cliente;
import com.adrianosantos.cursomc.services.validation.AtualizarCliente;

@AtualizarCliente
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idcliente; 

	@NotEmpty(message="Campo não pode ser vazio")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nmcliente;
	@Email
	private String emailcliente;

	public ClienteDTO(){};

	public ClienteDTO(Cliente obj){
		this.idcliente = obj.getIdcliente();
		this.nmcliente = obj.getNmcliente();
		this.emailcliente = obj.getEmailcliente();
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

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
	
}
