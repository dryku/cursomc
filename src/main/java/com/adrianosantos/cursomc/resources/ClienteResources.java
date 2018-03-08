package com.adrianosantos.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adrianosantos.cursomc.dominio.Cliente;
import com.adrianosantos.cursomc.dto.ClienteCadastroDTO;
import com.adrianosantos.cursomc.dto.ClienteDTO;
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


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody ClienteCadastroDTO objDTO) {
		Cliente objcli = cliservice.clienteParaDTO(objDTO);
		objcli = cliservice.salvar(objcli);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idcliente}")
				.buildAndExpand(objcli.getIdcliente()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id) {
		Cliente objcli = cliservice.clienteParaDTO(objDTO);
		objcli.setIdcliente(id);
		objcli = cliservice.atualizar(objcli);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		cliservice.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> listaCliente(){
		List<Cliente> listcli = cliservice.listaCliente();
		List<ClienteDTO> listDTO = listcli.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDTO);
	} 
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> buscaPagina(
			@RequestParam(value="pagina", defaultValue="0") Integer pagina, 
			@RequestParam(value="qtdlinha", defaultValue="24") Integer qtdlinha, 
			@RequestParam(value="direcao", defaultValue="ASC") String direcao,
			@RequestParam(value="orderBy", defaultValue="nmcliente") String orderBy
			){
		Page<Cliente> listcli = cliservice.buscaPagina(pagina, qtdlinha, direcao, orderBy);
		Page<ClienteDTO> listDTO = listcli.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	};



}
