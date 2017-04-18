package com.example.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.notafiscal.NotaFiscal;
import com.example.domain.notafiscal.NotaFiscalId;
import com.example.domain.notafiscal.NotaFiscalRepositorio;
import com.example.domain.produto.Produto;
import com.example.domain.produto.ProdutoRepositorio;

@RestController
public class NotaFiscalController {

	@Autowired
	private NotaFiscalRepositorio repositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	@ResponseBody
	public Retorno novaNota(@RequestBody NotaFiscalComando comando){
		NotaFiscal nota = construir(comando);
		repositorio.salvar(nota);
		return new Retorno(retorno(nota));
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	@ResponseBody
	public Retorno buscar(@RequestParam(value="notafiscalId")String notafiscalId){
		
		NotaFiscal nota = repositorio.obterNotaFiscalPeloId(new NotaFiscalId(notafiscalId));
		
		List<ProdutoComando> produtos = new ArrayList<>();
		
		nota.getProdutos().forEach(p ->
				produtos.add(new ProdutoComando(p.getProdutoId().id(), p.getNome(), notafiscalId)));
		
		return new Retorno(new NotaFiscalComando(nota.getNotafiscalId().id(), nota.getChave(), nota.getNomeEmissor(), produtos));
	}

	private NotaFiscalData retorno(NotaFiscal nota) {
		
		List<ProdutoComando> produtos = new ArrayList<>();
		
		nota.getProdutos().forEach(p -> 
				produtos.add(new ProdutoComando(p.getProdutoId().id(), p.getNome(), nota.getNotafiscalId().id())));
		
		return new NotaFiscalData(nota.getNotafiscalId().id(), nota.getChave(), nota.getNomeEmissor(), produtos);
	}

	private NotaFiscal construir(NotaFiscalComando comando) {
		
		NotaFiscal nota = new NotaFiscal(repositorio.novaIdentidade(), comando.getChave(), comando.getNomeEmissor());
		
		comando.getProdutos().forEach(
				e -> nota.adicionarProduto(
						new Produto(produtoRepositorio.novaIdentidade(), e.getNome(), nota)));
		
		return nota;
	}
}
