package com.adrianosantos.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.Pedido;
import com.adrianosantos.cursomc.repositorios.PedidoRepositorio;
import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

@Service
public class PedidoService {

	@Autowired
	public PedidoRepositorio pedrep;

	public Pedido buscar(Integer idped) {
		Pedido obj = pedrep.findOne(idped);
		
		if (obj == null){

			throw new ObjectNotFounException("Objeto não encontrado: "+idped
					+", tipo: "+ Pedido.class.getName());
		}
		
		return obj;
	}
}
