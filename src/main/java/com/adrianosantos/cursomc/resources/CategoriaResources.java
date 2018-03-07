package com.adrianosantos.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adrianosantos.cursomc.dominio.Categoria;
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

}
