package br.com.api.ApiExercicioNotaFiscal.integracao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.api.ApiExercicioNotaFiscal.models.NotaFiscal;
import br.com.api.ApiExercicioNotaFiscal.services.NotaFiscalService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class NFTestIntegracao {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	NotaFiscalService notaFiscalService;
	

	@Test
	@Order(1)
	public void criarNovaNFTesteIntegracao() {
		System.out.println("Teste de criar nf!");
		NotaFiscal nf = new NotaFiscal("NotaFiscal123","444", 100, 50);
		
		HttpEntity<NotaFiscal> httpEntity = new HttpEntity<NotaFiscal>(nf);
		ResponseEntity<NotaFiscal> response = this.testRestTemplate.exchange("/notasfiscais/novo", HttpMethod.POST, httpEntity, NotaFiscal.class);
		
		System.out.println(response.getBody());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(100, response.getBody().getNumeroNota());
	}
	
	@Test
	@Order(2)
	public void buscarNFTesteIntegracao() {
		System.out.println("Teste de buscar nf!");
		List<NotaFiscal> notaFiscal = notaFiscalService.getNotaByNumero(100);
		
		if (!notaFiscal.isEmpty()) {
		
		HttpEntity<NotaFiscal> httpEntity = new HttpEntity<NotaFiscal>(notaFiscal.get(0));
		ResponseEntity<NotaFiscal> response = this.testRestTemplate.exchange("/notasfiscais/"+notaFiscal.get(0).getCodigo(), HttpMethod.GET, httpEntity, 
				NotaFiscal.class);
		
		System.out.println(response.getBody());
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		}	
	}
	
	@Test
	@Order(3)
	public void atualizarNFTesteIntegracao() {
		System.out.println("Teste de atualizar nf!");
		List<NotaFiscal> notasFiscais = notaFiscalService.getNotaByNumero(100);
		
		if (!notasFiscais.isEmpty()) {
			
			NotaFiscal notaFiscal = notasFiscais.get(0);
			notaFiscal.setNumeroNota(50);
		
		HttpEntity<NotaFiscal> httpEntity = new HttpEntity<NotaFiscal>(notaFiscal);
		ResponseEntity<NotaFiscal> response = this.testRestTemplate.exchange("/notasfiscais/update/"+notaFiscal.getCodigo(), HttpMethod.PUT, httpEntity, 
				NotaFiscal.class);
		
		System.out.println(response.getBody());
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		}	
	
	}
	

	@Test
	@Order(4)
	public void removerNFTesteIntegracao() {
		System.out.println("Teste de remover nf!");
		List<NotaFiscal> notasFiscais = notaFiscalService.getNotaByNumero(100);
		
		if (!notasFiscais.isEmpty()) {
			notasFiscais.forEach(notaFiscal ->{

			
			HttpEntity<NotaFiscal> httpEntity = new HttpEntity<NotaFiscal>(notaFiscal);
			ResponseEntity<NotaFiscal> response = this.testRestTemplate.exchange("/notasfiscais/delete/"+notaFiscal.getCodigo(), HttpMethod.DELETE, httpEntity, 
				NotaFiscal.class);
		
			System.out.println(response.getBody());
			Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
			
			});
		}
	}

}
