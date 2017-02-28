package com.example.domain.notafiscal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.AbstractTest;
import com.example.domain.produto.Produto;
import com.example.domain.produto.ProdutoId;

public class NotaFiscalTest extends AbstractTest {
	
	@Test
	public void novaNotaFiscal(){
		
		NotaFiscal nota = new NotaFiscal(notaRepositorio.novaIdentidade(), "41545878", "Tiago Costa");
		nota.adicionarProduto(new Produto(new ProdutoId("5454-4587-5451"), "GELADEIRA", nota));
		nota.adicionarProduto(new Produto(new ProdutoId("5454-4587-5452"), "TV 42 POL", nota));
		nota.adicionarProduto(new Produto(new ProdutoId("5454-4587-5454"), "COMPUTADOR", nota));
		
		assertEquals(3, nota.getProdutos().size());
		
		notaRepositorio.salvar(nota);
		
		NotaFiscal notaTeste = notaRepositorio.obterNotaFiscalPeloId(nota.getNotafiscalId());
		
		assertEquals("41545878", notaTeste.getChave());
		assertEquals("GELADEIRA", notaTeste.getProdutos().get(0).getNome());
		assertEquals("TV 42 POL", notaTeste.getProdutos().get(1).getNome());
		assertEquals("COMPUTADOR", notaTeste.getProdutos().get(2).getNome());
		assertEquals(3, notaTeste.getProdutos().size());
		
	}
	
}
