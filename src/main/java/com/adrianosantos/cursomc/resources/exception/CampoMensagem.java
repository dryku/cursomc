package com.adrianosantos.cursomc.resources.exception;

import java.io.Serializable;

public class CampoMensagem implements Serializable {
	private static final long serialVersionUID = 1L;
	private String campo;
	private String mensagem;

	public CampoMensagem() {
	}
	
	public CampoMensagem(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
