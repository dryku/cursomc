package com.adrianosantos.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.Cliente;
import com.adrianosantos.cursomc.dto.ClienteDTO;
import com.adrianosantos.cursomc.repositorios.ClienteRepositorio;
import com.adrianosantos.cursomc.services.exceptions.DataIntegrityViolationExcep;
import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepositorio clirep;

	public Cliente buscar(Integer idcli) {
		Cliente obj = clirep.findOne(idcli);
		if (obj == null) {
			throw new ObjectNotFounException("Objeto não encontrado: " + idcli + ", tipo: " + Cliente.class.getName());
		}
		return obj;
	}

	public Cliente salvar(Cliente objcli) {
		// objcat.setIdcategoria(null);
		return clirep.save(objcli);
	}

	public Cliente atualizar(Cliente obj) {
		Cliente newobj = buscar(obj.getIdcliente());
		atualizaObjCliente(newobj, obj);
		return clirep.save(newobj);
	}

	private void atualizaObjCliente(Cliente newobj, Cliente obj) {
		newobj.setNmcliente(obj.getNmcliente());
		newobj.setEmailcliente(obj.getEmailcliente());
	}

	
	public void excluir(Integer idcli) {
		buscar(idcli);
		try {

			clirep.delete(idcli);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new DataIntegrityViolationExcep("Não é possivel exluir cliente com pedidos vinculados");
		}
	}

	public List<Cliente> listaCliente() {
		return clirep.findAll();
	};

	public Page<Cliente> buscaPagina(Integer pagina, Integer qtdlinha, String direcao, String orderBy) {
		PageRequest pageRequest = new PageRequest(pagina, qtdlinha, Direction.valueOf(direcao), orderBy);
		return clirep.findAll(pageRequest);
	}

	public Cliente categoriaParaDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getIdcliente(), objDTO.getNmcliente(), objDTO.getEmailcliente(), null, null);
	}

}
