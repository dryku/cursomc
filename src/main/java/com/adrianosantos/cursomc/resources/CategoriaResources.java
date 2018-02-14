package com.adrianosantos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adrianosantos.cursomc.dominio.Categoria;
import com.adrianosantos.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@Autowired
	CategoriaService catservice;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarCategoriaId(@PathVariable Integer id) {
	
	Categoria obj = catservice.buscar(id);
    return ResponseEntity.ok().body(obj);
	}
}
