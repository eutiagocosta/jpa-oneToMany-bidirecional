package com.example.domain.produto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.AbstractTest;
import com.example.domain.notafiscal.NotaFiscal;

public class ProdutoTest extends AbstractTest {
	
	@Test
	public void adicionarProdutoEmNotaFiscalQueJaContemProdutos(){
		
		NotaFiscal nota = notaFiscalCom3ProdutosFixture();
		
		Produto produto = new Produto(produtoRepositorio.novaIdentidade(), "TV 42 POLEGADASS", nota);

		produtoRepositorio.salvar(produto);
		
		produto = produtoRepositorio.obterProdutoPorId(produto.getProdutoId());
		assertEquals("TV 42 POLEGADASS", produto.getNome());
		
		nota = notaRepositorio.obterNotaFiscalPeloId(nota.getNotafiscalId());
		
		assertEquals("4545467468786768736574568784887", nota.getChave());
		assertEquals(4, nota.getProdutos().size());

	}
	
	@Test
	public void adicionarProdutosEmNotaVazia(){
		
		NotaFiscal nota = notaFiscalFixture();
		
		Produto produto1 = new Produto(produtoRepositorio.novaIdentidade(), "TV 42 POLEGADAS", nota);
		Produto produto2 = new Produto(produtoRepositorio.novaIdentidade(), "PC", nota);
		Produto produto3 = new Produto(produtoRepositorio.novaIdentidade(), "CEL", nota);
		Produto produto4 = new Produto(produtoRepositorio.novaIdentidade(), "PHONE", nota);
		
		produtoRepositorio.salvar(produto1);
		produtoRepositorio.salvar(produto2);
		produtoRepositorio.salvar(produto3);
		produtoRepositorio.salvar(produto4);
		
		nota = notaRepositorio.obterNotaFiscalPeloId(nota.getNotafiscalId());
		
		assertEquals("TV 42 POLEGADAS", nota.getProdutos().get(0).getNome());
		assertEquals("PC", nota.getProdutos().get(1).getNome());
		assertEquals("CEL", nota.getProdutos().get(2).getNome());
		assertEquals("PHONE", nota.getProdutos().get(3).getNome());
		assertEquals("65665441541214777212012454547", nota.getChave());
		
		assertEquals(4, nota.getProdutos().size());

	}

}
