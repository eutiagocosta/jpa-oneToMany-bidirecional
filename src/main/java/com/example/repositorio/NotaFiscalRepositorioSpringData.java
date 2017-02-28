package com.example.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.notafiscal.NotaFiscal;
import com.example.domain.notafiscal.NotaFiscalId;

public interface NotaFiscalRepositorioSpringData extends CrudRepository<NotaFiscal, Long>{

	NotaFiscal findByNotafiscalId(NotaFiscalId notafiscalId);

}
