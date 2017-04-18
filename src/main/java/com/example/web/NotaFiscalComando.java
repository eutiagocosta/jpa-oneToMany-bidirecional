package com.example.web;

import java.util.List;

public class NotaFiscalComando {

	private String notafiscalId;
	private String chave;
	private String nomeEmissor;
	private List<ProdutoComando> produtos;
	
	public NotaFiscalComando(String notafiscalId, String chave, String nomeEmissor, List<ProdutoComando> produtos) {
		this.notafiscalId = notafiscalId;
		this.chave = chave;
		this.nomeEmissor = nomeEmissor;
		this.produtos = produtos;
	}
	
	@SuppressWarnings("unused")
	private NotaFiscalComando(){}

	public String getChave() {
		return chave;
	}
	public String getNomeEmissor() {
		return nomeEmissor;
	}
	public List<ProdutoComando> getProdutos() {
		return produtos;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public void setNomeEmissor(String nomeEmissor) {
		this.nomeEmissor = nomeEmissor;
	}
	public void setProdutos(List<ProdutoComando> produtos) {
		this.produtos = produtos;
	}

	public String getNotafiscalId() {
		return notafiscalId;
	}

	public void setNotafiscalId(String notafiscalId) {
		this.notafiscalId = notafiscalId;
	}
	
}
