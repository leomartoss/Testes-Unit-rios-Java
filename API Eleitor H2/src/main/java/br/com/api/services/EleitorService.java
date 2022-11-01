package br.com.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.models.Eleitor;
import br.com.api.repository.RepositoryEleitor;

@Service
public class EleitorService {

	@Autowired
	private RepositoryEleitor repositoryEleitor;
	
	public Eleitor getEleitor(long codigo) {
		
		Optional<Eleitor> eleitor = repositoryEleitor.findById(codigo);
		
		if (!eleitor.isPresent()) {
			return null;
		}
		
		return eleitor.get();
	}
	
	public List<Eleitor> getByTitulo(int titulo) {
		
		List<Eleitor> eleitor = repositoryEleitor.findByTitulo(titulo);
		
		if (eleitor.isEmpty()) {
			return null;
		}
		
		return eleitor;
	}
	
	public List<Eleitor> getALL(){
		return repositoryEleitor.findAll();
	}
	
	public void saveEleitor(Eleitor eleitor) {
		repositoryEleitor.save(eleitor);
	}
	
	public void removerEleitor(Eleitor eleitor) {
		repositoryEleitor.delete(eleitor);
	}
	
	public void adicionaEleitorTeste() {
		
		if (getALL().isEmpty()) {
		
			Eleitor e = new Eleitor();
			e.setCpf("1111111111");
			e.setNome("Joao Aula Teste");
			e.setTitulo(1313);
			saveEleitor(e);
			
			e = new Eleitor();
			e.setCpf("3333333333");
			e.setNome("Pedro Aula Teste");
			e.setTitulo(1414);
			saveEleitor(e);
		}
		
	}
	
}	
