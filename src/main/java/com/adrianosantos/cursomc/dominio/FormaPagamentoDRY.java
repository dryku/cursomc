package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class FormaPagamentoDRY implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormaPagamento;
	private String nmFormaPagamento; 
	private Date dtaCadastro;
	private Integer qtdParcelas;
	
	
/*	@ManyToMany (mappedBy="formapagamentos")	
	private List<Pedido> pedidos = new ArrayList<>();
*/
	public FormaPagamentoDRY() {}


	public FormaPagamentoDRY(Integer idFormaPagamento, String nmFormaPagamento, Date dtaCadastro, 
			Integer qtdParcelas) {
		super();
		this.idFormaPagamento = idFormaPagamento;
		this.nmFormaPagamento = nmFormaPagamento;
		this.dtaCadastro = dtaCadastro;
		this.qtdParcelas = qtdParcelas;
	}


	public Integer getIdFormaPagamento() {
		return idFormaPagamento;
	}


	public void setIdFormaPagamento(Integer idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}


	public String getNmFormaPagamento() {
		return nmFormaPagamento;
	}


	public void setNmFormaPagamento(String nmFormaPagamento) {
		this.nmFormaPagamento = nmFormaPagamento;
	}


	public Date getDtaCadastro() {
		return dtaCadastro;
	}


	public void setDtaCadastro(Date dtaCadastro) {
		this.dtaCadastro = dtaCadastro;
	}


	public Integer getQtdParcelas() {
		return qtdParcelas;
	}


	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

/*	
	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFormaPagamento == null) ? 0 : idFormaPagamento.hashCode());
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
		FormaPagamentoDRY other = (FormaPagamentoDRY) obj;
		if (idFormaPagamento == null) {
			if (other.idFormaPagamento != null)
				return false;
		} else if (!idFormaPagamento.equals(other.idFormaPagamento))
			return false;
		return true;
	}
	
	
	
}
