package com.adrianosantos.cursomc;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adrianosantos.cursomc.dominio.Categoria;
import com.adrianosantos.cursomc.dominio.Cidade;
import com.adrianosantos.cursomc.dominio.Cliente;
import com.adrianosantos.cursomc.dominio.Endereco;
import com.adrianosantos.cursomc.dominio.Estado;
import com.adrianosantos.cursomc.dominio.FormaPagamentoDRY;
import com.adrianosantos.cursomc.dominio.Pagamento;
import com.adrianosantos.cursomc.dominio.Pedido;
import com.adrianosantos.cursomc.dominio.PgtoBoleto;
import com.adrianosantos.cursomc.dominio.PgtoCartao;
import com.adrianosantos.cursomc.dominio.Produto;
import com.adrianosantos.cursomc.dominio.enums.EstadoPgto;
import com.adrianosantos.cursomc.dominio.enums.TipoCliente;
import com.adrianosantos.cursomc.repositorios.CategoriaRepositorio;
import com.adrianosantos.cursomc.repositorios.CidadeRepositorio;
import com.adrianosantos.cursomc.repositorios.ClienteRepositorio;
import com.adrianosantos.cursomc.repositorios.EnderecoRepositorio;
import com.adrianosantos.cursomc.repositorios.EstadoRepositorio;
import com.adrianosantos.cursomc.repositorios.FormaPagamentoRepositorio;
import com.adrianosantos.cursomc.repositorios.ItemPedidoRepositorio;
import com.adrianosantos.cursomc.repositorios.PagamentoRepositorio;
import com.adrianosantos.cursomc.repositorios.PedidoRepositorio;
import com.adrianosantos.cursomc.repositorios.ProdutoRepositorio;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepositorio catrepo;
	@Autowired
	ProdutoRepositorio prodrepo;
	@Autowired
	EstadoRepositorio estrepo;
	@Autowired
	CidadeRepositorio cidrepo;
	@Autowired
	ClienteRepositorio clirepo;
	@Autowired
	EnderecoRepositorio endrepo;
	@Autowired
	PedidoRepositorio pedrepo;
	@Autowired
	PagamentoRepositorio pgtorepo;
	@Autowired
	ItemPedidoRepositorio itempedrepo;
	@Autowired
	FormaPagamentoRepositorio formapagamentorep;  
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		Random gerador = new Random();
		DecimalFormat df = new DecimalFormat("0.##");	    
		//imprime sequência de 10 números inteiros aleatórios entre 0 e 25
/*	    for (int i = 0; i < 50; i++) {
			Double numero = gerador.nextDouble();
			Double vlr = numero * 2000;
	    	System.out.println("Numero: "+i
	    			+" Double Gerado : " +numero+ ": Valor gerado:" +vlr);
		 }
*/
	    Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto prod1 = new Produto(null, "Computador", 2.000);
		Produto prod2 = new Produto(null, "Impressora", 1.500);
		Produto prod3 = new Produto(null, "Mouse", 20.15);
			
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));

		catrepo.save(Arrays.asList(cat1, cat2));

		ArrayList<Categoria> list = new ArrayList<>(); 
 		
		for (int i = 0; i < 10; i++) {
			Categoria cat = new Categoria(null, "Categoria teste " + i);
			list.add(cat);
			catrepo.save(cat);
		}
		
		
		
		for (int i = 0; i < list.size(); i++) {
			Integer nroparcelas = gerador.nextInt(8)+1;
			FormaPagamentoDRY forma = new FormaPagamentoDRY(null, "Forma Pagamento"+i, 
					new Date(), nroparcelas);
			formapagamentorep.save(forma);
			
			System.out.println("Adicionando nosas formas de pagamento: " + forma.getNmFormaPagamento());
		}
		
		
		
		
		prodrepo.save(Arrays.asList(prod1, prod2, prod3));

		
		for (int i = 0; i < 10; i++) {
			Integer nrocat = gerador.nextInt(10);
			Double preco = gerador.nextDouble() * 2000;
			
			String pre = df.format(preco);
			preco = Double.parseDouble(pre.replaceAll(",", ".")); 
			
			Produto prod = new Produto(null, "Produto Teste"+i, preco);
	//    	System.out.println("Produto gerado: "+i+4+": Posição: " +nrocat+": Nome da Categoria" +list.get(nrocat).getNmcategoria());
			prod.getCategorias().add(list.get(nrocat));
			prodrepo.save(prod);
		}

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Uberlandia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));

		estrepo.save(Arrays.asList(est1, est2));
		cidrepo.save(Arrays.asList(cid1, cid2, cid3));

		Cliente cli1 = new Cliente(null, "Maria", "dryku@hotmail.com", "08142460", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("995232651", "985632451"));

		Endereco end1 = new Endereco(null, "Rua Basilio Salazar", "72", "A", "Jd. Nazaré - Itaim Paulista", "08142-460",
				cli1, cid1);
		Endereco end2 = new Endereco(null, "Rua Basilio Salazar", "72", "A", "Jd. Nazaré - Itaim Paulista", "08142-460",
				cli1, cid2);

		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

		clirepo.save(cli1);
		endrepo.save(Arrays.asList(end1, end2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		// System.out.println("Data do sistemas: " + new Date().toLocaleString());

		Pedido ped1 = new Pedido(null, sdf.parse(new Date().toLocaleString()), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse(new Date().toLocaleString()), cli1, end2);

		Pagamento pgto1 = new PgtoCartao(null, EstadoPgto.QUITADO, ped1, 6);
		ped1.setPgto(pgto1);

		Pagamento pgto2 = new PgtoBoleto(null, EstadoPgto.PENDENTE, ped2, sdf.parse(new Date().toLocaleString()),
				sdf.parse(new Date().toLocaleString()));
		ped2.setPgto(pgto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedrepo.save(Arrays.asList(ped1, ped2));
		pgtorepo.save(Arrays.asList(pgto1, pgto2));
/*
		ItemPedidoNew ip1 = new ItemPedidoNew(ped1, prod1, 0.00, 1, 2000.00);
		ItemPedidoNew ip2 = new ItemPedidoNew(ped1, prod3, 0.00, 2, 80.00);
		ItemPedidoNew ip3 = new ItemPedidoNew(ped2, prod2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		prod1.getItens().addAll(Arrays.asList(ip1));
		prod2.getItens().addAll(Arrays.asList(ip3));
		prod3.getItens().addAll(Arrays.asList(ip2));

		itempedrepo.save(Arrays.asList(ip1, ip2, ip3));
*/	}
}
