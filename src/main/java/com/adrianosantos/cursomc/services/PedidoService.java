package com.adrianosantos.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.ItemPedido;
import com.adrianosantos.cursomc.dominio.Pedido;
import com.adrianosantos.cursomc.dominio.PgtoBoleto;
import com.adrianosantos.cursomc.dominio.enums.EstadoPgto;
import com.adrianosantos.cursomc.repositorios.FormaPagamentoRepositorio;
import com.adrianosantos.cursomc.repositorios.ItemPedidoRepositorio;
import com.adrianosantos.cursomc.repositorios.PagamentoRepositorio;
import com.adrianosantos.cursomc.repositorios.PedidoRepositorio;
import com.adrianosantos.cursomc.repositorios.ProdutoRepositorio;
import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepositorio pedrep;
	@Autowired
	private BoletoService bolrep;
	@Autowired
	private PagamentoRepositorio pgtorep;
	@Autowired
	private ProdutoRepositorio prodrep;
	@Autowired
	private ItemPedidoRepositorio itemrep;

	@Autowired
	FormaPagamentoRepositorio formapgtorep;

	public Pedido buscar(Integer idped) {
		Pedido obj = pedrep.findOne(idped);
		if (obj == null) {
			throw new ObjectNotFounException("Objeto não encontrado: " + idped + ", tipo: " + Pedido.class.getName());
		}
		return obj;
	}

	public Pedido salvar(Pedido obj) {
		obj.setIdpedido(null);
		obj.setDtapedido(new Date());

		obj.getPgto().setEstadopgto(EstadoPgto.CANCELADO);
		obj.getPgto().setPedido(obj);

		// obj.getFormapagamentos()
		if (obj.getPgto() instanceof PgtoBoleto) {
			PgtoBoleto pgto = (PgtoBoleto) obj.getPgto();
			bolrep.preencherPgtoBoleto(pgto, obj.getDtapedido());
		}

		obj = pedrep.save(obj);
		pgtorep.save(obj.getPgto());

		for (ItemPedido itempedido : obj.getItens()) {
			itempedido.setDescontoitem(0.0);
			itempedido.setPrecoitem(prodrep.findOne(itempedido.getProduto().getidProduto()).getPreco());
			itempedido.setPedido(obj);
		}
		itemrep.save(obj.getItens());
		return obj;
	}
}
