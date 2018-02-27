package com.adrianosantos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adrianosantos.cursomc.dominio.Cliente;
import com.adrianosantos.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {

	@Autowired
	ClienteService cliservice;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarClienteId(@PathVariable Integer id) {
	
	Cliente obj = cliservice.buscar(id);
    return ResponseEntity.ok().body(obj);
	}
}
