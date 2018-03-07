package com.adrianosantos.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.Categoria;
import com.adrianosantos.cursomc.repositorios.CategoriaRepositorio;
import com.adrianosantos.cursomc.services.exceptions.DataIntegrityViolationExcep;
import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepositorio catrep;

	public Categoria buscar(Integer idcat) {
		Categoria obj = catrep.findOne(idcat);
		if (obj == null) {
			throw new ObjectNotFounException(
					"Objeto não encontrado: " + idcat + ", tipo: " + Categoria.class.getName());
		}
		return obj;
	}

	public Categoria salvar(Categoria objcat) {
		// objcat.setIdcategoria(null);
		return catrep.save(objcat);
	}

	public Categoria atualizar(Categoria objcat) {
		buscar(objcat.getIdcategoria());
		return catrep.save(objcat);
	}

	public void excluir(Integer idcat) {
		buscar(idcat);
		try {

			catrep.delete(idcat);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
		throw new DataIntegrityViolationExcep("Não é possivel exluir uma categoria que contenha produtos vinculados a ela");
		}

	};
}
