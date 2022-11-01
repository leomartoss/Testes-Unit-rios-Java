package br.com.api.API.Alunos.H2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.API.Alunos.H2.models.Aluno;
import br.com.api.API.Alunos.H2.repository.repositoryAluno;


@Service
public class AlunoService {
	
	@Autowired
	private repositoryAluno repositoryAluno;

	public Aluno getAluno(long codigo){

	Optional<Aluno> aluno = repositoryAluno.findById(codigo);
	if (!aluno.isPresent()){
	return null;
	}
	
	
	return aluno.get();
	}
	
	public List<Aluno> getALL(){
	return repositoryAluno.findAll();
	}
	
	public void saveAluno(Aluno aluno){
		repositoryAluno.save(aluno);
	}
	
	public void removerAluno(Aluno aluno){
		repositoryAluno.delete(aluno);
		}
	
	public void adicionaAlunosTeste(){
		if(getALL().isEmpty()) {
			Aluno aluno = new Aluno();
			aluno.setNome("Carolina");
			aluno.setNota(100);
			saveAluno(aluno);
			
			aluno = new Aluno();
			aluno.setNome("Eduardo");
			aluno.setNota(80);
			saveAluno(aluno);
			
		}
		
		}
	public List<Aluno> getAlunoByNome(String nome){
		
		List<Aluno> alunos= repositoryAluno.findByNome(nome);
		if (alunos.isEmpty()) {
			return null;
		}
		return alunos;
		
	}


}
