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

import com.adrianosantos.cursomc.dominio.Pedido;
import com.adrianosantos.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResources {

	@Autowired
	PedidoService pedservice;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPedidoId(@PathVariable Integer id) {
	
	Pedido obj = pedservice.buscar(id);
    return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar( @RequestBody Pedido obj) {
		obj = pedservice.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idpedido}")
				.buildAndExpand(obj.getIdpedido()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
}
