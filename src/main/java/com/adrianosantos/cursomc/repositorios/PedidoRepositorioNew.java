package com.adrianosantos.cursomc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrianosantos.cursomc.dominio.PedidoNew;

@Repository
public interface PedidoRepositorioNew extends JpaRepository<PedidoNew, Integer>{

}
