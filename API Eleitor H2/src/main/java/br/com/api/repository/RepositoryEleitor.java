package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.models.Eleitor;

public interface RepositoryEleitor extends JpaRepository<Eleitor, Long> {
	List<Eleitor> findByTitulo(int titulo);
}


