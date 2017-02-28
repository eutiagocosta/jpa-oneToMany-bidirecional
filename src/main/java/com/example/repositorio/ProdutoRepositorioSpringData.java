package com.example.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.produto.Produto;
import com.example.domain.produto.ProdutoId;

public interface ProdutoRepositorioSpringData extends CrudRepository<Produto, Long>{

	Produto findByProdutoId(ProdutoId produtoId);

}
