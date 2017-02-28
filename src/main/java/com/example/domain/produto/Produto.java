package com.example.domain.produto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.domain.notafiscal.NotaFiscal;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Embedded
	private ProdutoId produtoId;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "ID_NOTAFISCAL", nullable = false)
	private NotaFiscal notafiscal;
	
	public Produto(ProdutoId produtoId, String nome, NotaFiscal notafiscal) {
		this.produtoId = produtoId;
		this.nome = nome;
		this.notafiscal = notafiscal;
	}
	
	@SuppressWarnings("unused")
	private Produto(){}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ProdutoId getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(ProdutoId produtoId) {
		this.produtoId = produtoId;
	}
	
	public NotaFiscal getNotafiscal() {
		return notafiscal;
	}

	public void setNotafiscal(NotaFiscal notafiscal) {
		this.notafiscal = notafiscal;
	}

	/*@Override
	public String toString() {
		return "Produto [id=" + id + ", produtoId=" + produtoId + ", nome=" + nome + ", notafiscal=" + notafiscal + "]";
	}*/

}

