package com.adrianosantos.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.Produto;
import com.adrianosantos.cursomc.repositorios.ProdutoRepositorio;

@Service
public class ProdutoService {

	@Autowired
	public ProdutoRepositorio prodrep;

	public Produto buscar(Integer idcat) {
		Produto obj = prodrep.findOne(idcat);
		return obj;
	}
}
