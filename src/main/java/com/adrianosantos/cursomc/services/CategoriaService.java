package com.adrianosantos.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.Categoria;
import com.adrianosantos.cursomc.repositorios.CategoriaRepositorio;
import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepositorio catrep;

	public Categoria buscar(Integer idcat) {
		Categoria obj = catrep.findOne(idcat);
		
		if (obj == null){

			throw new ObjectNotFounException("Objeto não encontrado: "+idcat
					+", tipo: "+ Categoria.class.getName());
		}
		
		return obj;
	}
}
