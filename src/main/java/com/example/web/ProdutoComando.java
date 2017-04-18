package com.example.web;

public class ProdutoComando {

	private String produtoId;
	private String nome;
	private String notafiscalId;

	public ProdutoComando(String produtoId, String nome, String notafiscalId) {
		this.produtoId = produtoId;
		this.nome = nome;
		this.notafiscalId = notafiscalId;
	}
	
	@SuppressWarnings("unused")
	private ProdutoComando(){}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}

	public String getNotafiscalId() {
		return notafiscalId;
	}

	public void setNotafiscalId(String notafiscalId) {
		this.notafiscalId = notafiscalId;
	}
	
}
