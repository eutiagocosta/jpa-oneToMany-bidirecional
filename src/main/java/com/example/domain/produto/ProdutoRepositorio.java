package com.example.domain.produto;

import java.util.UUID;

public interface ProdutoRepositorio {

	default ProdutoId novaIdentidade(){
		return new ProdutoId(UUID.randomUUID().toString().toUpperCase());
	}

	void salvar(Produto produto);

	Produto obterProdutoPorId(ProdutoId produtoId);;
}
