package com.adrianosantos.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.ItemPedidoNew;
import com.adrianosantos.cursomc.dominio.PedidoNew;
import com.adrianosantos.cursomc.repositorios.FormaPagamentoRepositorio;
import com.adrianosantos.cursomc.repositorios.ItemPedidoRepositorioNew;
import com.adrianosantos.cursomc.repositorios.PagamentoRepositorio;
import com.adrianosantos.cursomc.repositorios.PedidoRepositorioNew;
import com.adrianosantos.cursomc.repositorios.ProdutoRepositorio;
import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

@Service
public class PedidoServiceNew {

	@Autowired
	private PedidoRepositorioNew pedrep;
	@Autowired
	private BoletoService bolrep;
	@Autowired
	private PagamentoRepositorio pgtorep;
	@Autowired
	private ProdutoRepositorio prodrep;
	@Autowired
	private ItemPedidoRepositorioNew itemrep;

	@Autowired
	FormaPagamentoRepositorio formapgtorep;

	public PedidoNew buscar(Integer idped) {
		PedidoNew obj = pedrep.findOne(idped);
		if (obj == null) {
			throw new ObjectNotFounException("Objeto não encontrado: " + idped + ", tipo: " + PedidoNew.class.getName());
		}
		return obj;
	}

	public PedidoNew salvar(PedidoNew obj) {
		obj.setIdpedido(null);
		obj.setDtapedido(new Date());
		obj.setEstadoPagamento("PENDENTE");
		obj.setEstadoPgto(1);
		/*
		 * obj.getPgto().setEstadopgto(EstadoPgto.CANCELADO);
		 * obj.getPgto().setPedidoNew(obj);
		 */
		// obj.getFormapagamentos()

		/*
		 * if (obj.getPgto() instanceof PgtoBoleto) { PgtoBoleto pgto = (PgtoBoleto)
		 * obj.getPgto(); bolrep.preencherPgtoBoleto(pgto, obj.getDtapedido()); }
		 */
		obj = pedrep.save(obj);
		// pgtorep.save(obj.getPgto());
		

		for (ItemPedidoNew itempedido : obj.getItens()) {
			itempedido.setDescontoitem(0.0);
			// itempedido.setPrecoitem(prodrep.findOne(obj.getIdpedido()).getPreco());
			itempedido.setPrecoitem(prodrep.findOne(itempedido.getProduto().getidProduto()).getPreco());

			itempedido.setPedidoNew(obj);
		}
		itemrep.save(obj.getItens());
		return obj;
	}
}
