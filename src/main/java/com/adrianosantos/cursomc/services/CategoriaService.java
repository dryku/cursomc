package com.adrianosantos.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.Categoria;
import com.adrianosantos.cursomc.dto.CategoriaDTO;
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
	}

	public List<Categoria> listaCategoria() {
		return catrep.findAll();
	};
	
	public Page<Categoria> buscaPagina( Integer pagina, Integer qtdlinha, String direcao, String orderBy){
		PageRequest pageRequest = new PageRequest(pagina, qtdlinha, Direction.valueOf(direcao), orderBy);
		return catrep.findAll(pageRequest);
	}

public Categoria categoriaParaDTO(CategoriaDTO objDTO) {
	return new Categoria(objDTO.getIdcategoria(), objDTO.getNmcategoria());
}

}

