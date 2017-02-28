package com.example.domain.produto;

import javax.persistence.Embeddable;

@Embeddable
public class ProdutoId {

	private String produtoId;
	
	public ProdutoId(String produtoId){
		this.produtoId = produtoId;
	}
	
	@SuppressWarnings("unused")
	private ProdutoId(){}

	public String id(){
		return produtoId;
	}
	
	public String getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}
}
