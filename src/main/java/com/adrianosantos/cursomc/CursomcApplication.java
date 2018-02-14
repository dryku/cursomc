package com.adrianosantos.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adrianosantos.cursomc.dominio.Categoria;
import com.adrianosantos.cursomc.dominio.Produto;
import com.adrianosantos.cursomc.repositorios.CategoriaRepositorio;
import com.adrianosantos.cursomc.repositorios.ProdutoRepositorio;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepositorio catrepo;
	@Autowired
	ProdutoRepositorio prodrepo;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto prod1 = new Produto(null, "Computador", 2.000);
		Produto prod2 = new Produto(null, "Impressora", 1.500);
		Produto prod3 = new Produto(null, "Mouse", 20.00);

		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));

		catrepo.save(Arrays.asList(cat1, cat2));
		prodrepo.save(Arrays.asList(prod1,prod2,prod3));
	}
}
