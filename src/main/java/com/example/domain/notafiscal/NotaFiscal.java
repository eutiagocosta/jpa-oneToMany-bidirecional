package com.example.domain.notafiscal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.domain.produto.Produto;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class NotaFiscal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Embedded
	private NotaFiscalId notafiscalId;
	
	private String chave;
	private String nomeEmissor;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="notafiscal")
	@JsonBackReference
	private List<Produto> produtos;

	public NotaFiscal(NotaFiscalId notafiscalId, String chave, String nomeEmissor) {
		this.notafiscalId = notafiscalId;
		this.chave = chave;
		this.nomeEmissor = nomeEmissor;
	}
	
	public NotaFiscal(NotaFiscalId notaFiscalId, String chave, String nomeEmissor, List<Produto> produtos) {
		this.notafiscalId = notaFiscalId;
		this.chave = chave;
		this.nomeEmissor = nomeEmissor;
		this.produtos = produtos;
	}
	
	@SuppressWarnings("unused")
	private NotaFiscal(){}

	public Produto adicionarProduto(Produto produto){
		if (produtos == null)
			this.produtos = new ArrayList<>();
		
		produtos.add(produto);
		return produto;
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public NotaFiscalId getNotafiscalId() {
		return notafiscalId;
	}

	public void setNotafiscalId(NotaFiscalId notafiscalId) {
		this.notafiscalId = notafiscalId;
	}

	public String getNomeEmissor() {
		return nomeEmissor;
	}

	public void setNomeEmissor(String nomeEmissor) {
		this.nomeEmissor = nomeEmissor;
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	/*@Override
	public String toString() {
		return "NotaFiscal [id=" + id + ", notafiscalId=" + notafiscalId + ", chave=" + chave + ", nomeEmissor="
				+ nomeEmissor + ", produtos=" + produtos + "]";
	}*/
}
