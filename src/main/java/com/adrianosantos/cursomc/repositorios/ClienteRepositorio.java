package com.adrianosantos.cursomc.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrianosantos.cursomc.dominio.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

	//@Transactional(readOrly=true)
	 @Transactional
	Cliente findByEmailcliente(String emailcliente);

}
