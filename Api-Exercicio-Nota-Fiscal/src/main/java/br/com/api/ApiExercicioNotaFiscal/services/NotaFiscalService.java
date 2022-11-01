package br.com.api.ApiExercicioNotaFiscal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.ApiExercicioNotaFiscal.models.NotaFiscal;
import br.com.api.ApiExercicioNotaFiscal.repository.repositoryNotaFiscal;

@Service
public class NotaFiscalService {

	@Autowired
	private repositoryNotaFiscal repositoryNotaFiscal;

	public NotaFiscal getNotaFiscal(long codigo) {

		Optional<NotaFiscal> notaFiscal = repositoryNotaFiscal.findById(codigo);
		
		if (!notaFiscal.isPresent()) {
			return null;
		}
		return notaFiscal.get();
	}

	public List<NotaFiscal> getNotaByNumero(int numeroNota) {

		List<NotaFiscal> notaFiscal = repositoryNotaFiscal.findByNumeroNota(numeroNota);

		if (notaFiscal.isEmpty()) {
			return null;
		}
		return notaFiscal;
	}

	public List <NotaFiscal>getAll(){
		return repositoryNotaFiscal.findAll();
	}

	public void saveNF(NotaFiscal notaFiscal) {
		repositoryNotaFiscal.save(notaFiscal);
	}
	
	public void removerNF(NotaFiscal notaFiscal) {
		repositoryNotaFiscal.delete(notaFiscal);
	}
	
	public void adicionaNFTeste() {
		if (getAll().isEmpty()) {
			
			NotaFiscal nf = new NotaFiscal();
			nf.setEmitente("111111111");
			nf.setDestinatario("22222222");
			nf.setNumeroNota(1010);
			nf.setValor(15000);
			saveNF(nf);
			
		}
		
    }
	
}
