package com.adrianosantos.cursomc.dominio;

import java.util.Date;

import javax.persistence.Entity;

import com.adrianosantos.cursomc.dominio.enums.EstadoPgto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pgtoBoleto")
public class PgtoBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtavencimento;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtapagamento;

	public PgtoBoleto() {
		super();
	}

	public PgtoBoleto(Integer idpgto, EstadoPgto estadopgto, Pedido pedido, Date dtavencimento, Date dtapagamento) {
		super(idpgto, estadopgto, pedido);
		this.setDtavencimento(dtavencimento);
		this.setDtapagamento(dtapagamento);

	}

	public Date getDtavencimento() {
		return dtavencimento;
	}

	public void setDtavencimento(Date dtavencimento) {
		this.dtavencimento = dtavencimento;
	}

	public Date getDtapagamento() {
		return dtapagamento;
	}

	public void setDtapagamento(Date dtapagamento) {
		this.dtapagamento = dtapagamento;
	}

}
