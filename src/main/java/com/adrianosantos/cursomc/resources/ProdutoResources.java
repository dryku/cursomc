package com.adrianosantos.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrianosantos.cursomc.dominio.Produto;
import com.adrianosantos.cursomc.dto.ProdutoDTO;
import com.adrianosantos.cursomc.resources.ituls.URL;
import com.adrianosantos.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResources {

	@Autowired
	ProdutoService prodservice;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarProdutoId(@PathVariable Integer id) {

		Produto obj = prodservice.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> buscaPagina(
			@RequestParam(value="nmproduto", defaultValue="") String nmproduto, 
			@RequestParam(value="categorias", defaultValue="") String categorias, 
			@RequestParam(value="pagina", defaultValue="0") Integer pagina, 
			@RequestParam(value="qtdlinha", defaultValue="24") Integer qtdlinha, 
			@RequestParam(value="direcao", defaultValue="ASC") String direcao,
			@RequestParam(value="orderBy", defaultValue="nmproduto") String orderBy
			){
		
		String nomeDecod = URL.decodeParam(nmproduto);
		List<Integer> ids = URL.decodIntList(categorias);
		Page<Produto> listprod = prodservice.buscaPaginaProduto(nomeDecod, ids, pagina, qtdlinha, direcao, orderBy);
		Page<ProdutoDTO> listDTO = listprod.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	};

}
