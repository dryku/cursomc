package com.adrianosantos.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidaErro extends ErroPadrao {

	private static final long serialVersionUID = 1L;

	private List<CampoMensagem> erros = new ArrayList<>();

	public ValidaErro(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
		// TODO Auto-generated constructor stub
	}

	public List<CampoMensagem> getErros() {
		return erros;
	}

	public void addErro(String nomecampo, String mensagem) {
		erros.add(new CampoMensagem(nomecampo, mensagem));
		
	}	

}
