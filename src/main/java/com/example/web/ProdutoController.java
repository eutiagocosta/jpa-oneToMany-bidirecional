package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.produto.Produto;
import com.example.domain.produto.ProdutoId;
import com.example.domain.produto.ProdutoRepositorio;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	@ResponseBody
	public Retorno buscarProduto(@RequestParam(value="produtoId")String produtoId){
		Produto produto = repositorio.obterProdutoPorId(new ProdutoId(produtoId));
		return new Retorno(new ProdutoComando(
				produto.getProdutoId().id(), produto.getNome(), produto.getNotafiscal().getNotafiscalId().id()));
	}
}
