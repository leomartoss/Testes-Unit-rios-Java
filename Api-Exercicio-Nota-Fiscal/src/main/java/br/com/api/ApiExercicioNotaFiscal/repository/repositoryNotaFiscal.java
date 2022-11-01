package br.com.api.ApiExercicioNotaFiscal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.ApiExercicioNotaFiscal.models.NotaFiscal;

public interface repositoryNotaFiscal extends JpaRepository<NotaFiscal, Long>{
	List<NotaFiscal> findByNumeroNota(int numeroNota);
	 
}
