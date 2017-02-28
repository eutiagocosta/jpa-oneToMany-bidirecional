package com.example.domain.notafiscal;

import java.util.UUID;

public interface NotaFiscalRepositorio {

	default NotaFiscalId novaIdentidade(){
		return new NotaFiscalId(UUID.randomUUID().toString().toUpperCase());
	};

	void salvar(NotaFiscal nota);

	NotaFiscal obterNotaFiscalPeloId(NotaFiscalId notafiscalId);
	
}
