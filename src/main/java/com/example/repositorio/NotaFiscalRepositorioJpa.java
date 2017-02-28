package com.example.repositorio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.notafiscal.NotaFiscal;
import com.example.domain.notafiscal.NotaFiscalId;
import com.example.domain.notafiscal.NotaFiscalRepositorio;

@Repository
@Transactional
public class NotaFiscalRepositorioJpa implements NotaFiscalRepositorio{

	@Autowired
	private NotaFiscalRepositorioSpringData repositorio;
	
	@Override
	public void salvar(NotaFiscal nota) {
		repositorio.save(nota);
	}

	@Override
	public NotaFiscal obterNotaFiscalPeloId(NotaFiscalId notafiscalId) {
		return repositorio.findByNotafiscalId(notafiscalId);
	}

}
