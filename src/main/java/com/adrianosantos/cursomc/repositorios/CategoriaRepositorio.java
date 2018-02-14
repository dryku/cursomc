package com.adrianosantos.cursomc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adrianosantos.cursomc.dominio.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{

}
