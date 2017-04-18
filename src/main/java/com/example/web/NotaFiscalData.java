package com.example.web;

import java.util.List;

public class NotaFiscalData {
	
	private String notaFiscalId;
	private String chave;
	private String nomeEmissor;
	private List<ProdutoComando> produtos;
	
	public NotaFiscalData(String notaFiscalId, String chave, String nomeEmissor, List<ProdutoComando> produtos) {
		this.notaFiscalId = notaFiscalId;
		this.chave = chave;
		this.nomeEmissor = nomeEmissor;
		this.produtos = produtos;
	}
	
	@SuppressWarnings("unused")
	private NotaFiscalData(){}
	
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

	public String getNotaFiscalId() {
		return notaFiscalId;
	}

	public void setNotaFiscalId(String notaFiscalId) {
		this.notaFiscalId = notaFiscalId;
	}
}
