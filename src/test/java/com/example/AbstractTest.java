package com.example;

import javax.persistence.EntityManager;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.notafiscal.NotaFiscal;
import com.example.domain.notafiscal.NotaFiscalRepositorio;
import com.example.domain.produto.Produto;
import com.example.domain.produto.ProdutoId;
import com.example.domain.produto.ProdutoRepositorio;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractTest {
	
	@Autowired
	protected NotaFiscalRepositorio notaRepositorio;
	
	@Autowired
	protected ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	protected EntityManager em;

	public NotaFiscal notaFiscalCom3ProdutosFixture(){
		
		NotaFiscal nota = new NotaFiscal(notaRepositorio.novaIdentidade(), "4545467468786768736574568784887", "Bruno Costa");
		nota.adicionarProduto(new Produto(new ProdutoId("5454-4587-5451"), "GELADEIRA", nota));
		nota.adicionarProduto(new Produto(new ProdutoId("5454-4587-5452"), "TV 42 POL", nota));
		nota.adicionarProduto(new Produto(new ProdutoId("5454-4587-5454"), "COMPUTADOR", nota));
		notaRepositorio.salvar(nota);
		
		return nota;
	}
	
	public NotaFiscal notaFiscalFixture(){
		
		NotaFiscal nota = new NotaFiscal(notaRepositorio.novaIdentidade(), "65665441541214777212012454547", "Tiago Costa");
		notaRepositorio.salvar(nota);
		
		return nota;
	}
	
	public void flushAndClear(){
		em.flush();
		em.clear();
	}
}
