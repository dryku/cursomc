package com.adrianosantos.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adrianosantos.cursomc.dominio.Categoria;
import com.adrianosantos.cursomc.dto.CategoriaDTO;
import com.adrianosantos.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@Autowired
	CategoriaService catservice;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarCategoriaId(@PathVariable Integer id) {

		Categoria obj = catservice.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Categoria objcat) {
		objcat = catservice.salvar(objcat);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idcategoria}")
				.buildAndExpand(objcat.getIdcategoria()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Categoria objcat, @PathVariable Integer id) {
		objcat.setIdcategoria(id);
		objcat = catservice.atualizar(objcat);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		catservice.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> listaCategoria(){
		List<Categoria> listcat = catservice.listaCategoria();
		List<CategoriaDTO> listDTO = listcat.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDTO);
	} 
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> buscaPagina(
			@RequestParam(value="pagina", defaultValue="0") Integer pagina, 
			@RequestParam(value="qtdlinha", defaultValue="24") Integer qtdlinha, 
			@RequestParam(value="direcao", defaultValue="ASC") String direcao,
			@RequestParam(value="orderBy", defaultValue="nmcategoria") String orderBy
			){
		Page<Categoria> listcat = catservice.buscaPagina(pagina, qtdlinha, direcao, orderBy);
		Page<CategoriaDTO> listDTO = listcat.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	};
	
}
