package br.com.api.API.Alunos.H2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.API.Alunos.H2.models.Aluno;

public interface repositoryAluno extends JpaRepository<Aluno, Long> {
	List<Aluno> findByNome(String nome);
}

