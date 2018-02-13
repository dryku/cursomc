package com.adrianosantos.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adrianosantos.cursomc.dominio.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {

		Categoria cat1 = new Categoria(1, "Categoria 1");		
		Categoria cat2 = new Categoria(2, "Categoria 2");		

		List<Categoria> listacat = new ArrayList<>();
		listacat.add(cat1);
		listacat.add(cat2);
//		return "Rest esta Funcionando!!";
		return listacat;		
	}
	

}
