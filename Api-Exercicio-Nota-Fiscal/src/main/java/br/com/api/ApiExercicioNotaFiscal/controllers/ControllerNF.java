package br.com.api.ApiExercicioNotaFiscal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.ApiExercicioNotaFiscal.models.NotaFiscal;
import br.com.api.ApiExercicioNotaFiscal.services.NotaFiscalService;


@RestController
@RequestMapping("/notasfiscais")
public class ControllerNF {
	
	@Autowired
	private NotaFiscalService notaFiscalService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<NotaFiscal>getNF(@PathVariable("codigo")long codigo){
		
	if(codigo<0)
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	
	NotaFiscal nf = notaFiscalService.getNotaFiscal(codigo);
	
	if(nf==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	return new ResponseEntity<>(nf, HttpStatus.OK);
	}
	
	@PostMapping("/novo")
	public ResponseEntity<NotaFiscal> addNF(@NonNull @Validated @RequestBody NotaFiscal nf){
		notaFiscalService.saveNF(nf);
		return new ResponseEntity<>(nf, HttpStatus.OK);
	}
	
	@PutMapping("/update/{codigo}")
	public ResponseEntity<NotaFiscal> updateNF(@NonNull @Validated @RequestBody NotaFiscal nf, @PathVariable long codigo){
		
		NotaFiscal nfSearch = notaFiscalService.getNotaFiscal(codigo);
		
		if(notaFiscalService == null) {
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		nf.setCodigo(nfSearch.getCodigo());
		notaFiscalService.saveNF(nfSearch);
		
		return new ResponseEntity<>(nfSearch, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<NotaFiscal> deleteNF(@NonNull @Validated @PathVariable long codigo){
		
		NotaFiscal nf = notaFiscalService.getNotaFiscal(codigo);
		
		if(nf == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		
		notaFiscalService.removerNF(nf);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<NotaFiscal>>getAllNFs(){
		notaFiscalService.adicionaNFTeste();
		return new ResponseEntity<>(notaFiscalService.getAll(), HttpStatus.OK);
		
	}
	
}