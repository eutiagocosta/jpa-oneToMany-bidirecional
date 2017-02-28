package com.example.domain.notafiscal;

import javax.persistence.Embeddable;

@Embeddable
public class NotaFiscalId {

	private String notaFiscalId;

	public NotaFiscalId(String notaFiscalId) {
		this.notaFiscalId = notaFiscalId;
	}
	
	@SuppressWarnings("unused")
	private NotaFiscalId(){}

	public String id(){
		return notaFiscalId;
	}
	
	public String getNotaFiscalId() {
		return notaFiscalId;
	}

	public void setNotaFiscalId(String notaFiscalId) {
		this.notaFiscalId = notaFiscalId;
	}
	
}
