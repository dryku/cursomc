package com.adrianosantos.cursomc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrianosantos.cursomc.dominio.FormaPagamentoDRY;

@Repository
public interface FormaPagamentoRepositorio extends JpaRepository<FormaPagamentoDRY, Integer>{

}
