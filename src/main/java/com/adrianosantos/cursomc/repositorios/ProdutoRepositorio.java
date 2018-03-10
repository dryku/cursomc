package com.adrianosantos.cursomc.repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adrianosantos.cursomc.dominio.Categoria;
import com.adrianosantos.cursomc.dominio.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer>{
	
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE "
			+ "obj.nmproduto LIKE %:nmproduto% AND cat IN :categorias")
	Page<Produto> buscaPaginaProduto(@Param("nmproduto") String nmproduto,
			@Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	// Com sulta com os parametros do Srping DATA
//	findDistinctByNmprodutoContainingAndCategoriasIn(String nmproduto, List<Categoria> categorias, Pageable pageRequest);


}
