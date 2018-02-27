package com.adrianosantos.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.Cliente;
import com.adrianosantos.cursomc.repositorios.ClienteRepositorio;
import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepositorio clirep;

	public Cliente buscar(Integer idcli) {
		Cliente obj = clirep.findOne(idcli);
		
		if (obj == null){

			throw new ObjectNotFounException("Objeto não encontrado: "+idcli
					+", tipo: "+ Cliente.class.getName());
		}
		
		return obj;
	}
}
