package com.example.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.produto.Produto;
import com.example.domain.produto.ProdutoId;
import com.example.domain.produto.ProdutoRepositorio;

@Repository
public class ProdutoRepositorioJpa implements ProdutoRepositorio {
	
	@Autowired
	private ProdutoRepositorioSpringData repositorio;

	@Override
	public void salvar(Produto produto) {
		repositorio.save(produto);
	}

	@Override
	public Produto obterProdutoPorId(ProdutoId produtoId) {
		return repositorio.findByProdutoId(produtoId);
	}

}
