package com.adrianosantos.cursomc.dominio;

import javax.persistence.Entity;

import com.adrianosantos.cursomc.dominio.enums.EstadoPgto;

@Entity
public class PgtoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer nroparcelas;

	public PgtoCartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PgtoCartao(Integer idpgto, EstadoPgto estadopgto, Pedido pedido,
			Integer nroparcelas) {
		super(idpgto, estadopgto, pedido);
		
		this.setNroparcelas(nroparcelas);

	}

	public Integer getNroparcelas() {
		return nroparcelas;
	}

	public void setNroparcelas(Integer nroparcelas) {
		this.nroparcelas = nroparcelas;
	}

}
