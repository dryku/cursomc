package com.adrianosantos.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.Categoria;
import com.adrianosantos.cursomc.dominio.Produto;
import com.adrianosantos.cursomc.repositorios.CategoriaRepositorio;
import com.adrianosantos.cursomc.repositorios.ProdutoRepositorio;
import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

@Service
public class ProdutoService {

	@Autowired
	public ProdutoRepositorio prodrep;
	@Autowired
	public CategoriaRepositorio catrep;

	public Produto buscar(Integer idcat) {
		Produto obj = prodrep.findOne(idcat);
		if (obj == null) {
			throw new ObjectNotFounException("Objeto não encontrado: " + idcat + ", tipo: " + Produto.class.getName());
		}
		return obj;
	}

	public Page<Produto> buscaPaginaProduto(String nmproduto, List<Integer> idcategoria, Integer pagina, Integer qtdlinha, String direcao, String orderBy) {
		PageRequest pageRequest = new PageRequest(pagina, qtdlinha, Direction.valueOf(direcao), orderBy);
		List<Categoria> categorias = catrep.findAll(idcategoria);
		return prodrep.buscaPaginaProduto(nmproduto, categorias, pageRequest);
	}

}
