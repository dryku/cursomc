package com.adrianosantos.cursomc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrianosantos.cursomc.dominio.ItemPedidoNew;

@Repository
public interface ItemPedidoRepositorioNew extends JpaRepository<ItemPedidoNew, Integer>{

}
