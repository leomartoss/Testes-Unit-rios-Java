package br.com.api.controllers;

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

import br.com.api.models.Eleitor;
import br.com.api.services.EleitorService;

@RestController
@RequestMapping("/api/eleitores")
public class ControllerEleitor {
	
	@Autowired
	private EleitorService eleitorService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Eleitor> getEleitor(@PathVariable("codigo") long codigo){
		
		if (codigo < 0)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		Eleitor e = eleitorService.getEleitor(codigo);
		
		if (e == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@PostMapping("/novo")
	public ResponseEntity<Eleitor> addEleitor(@NonNull @Validated @RequestBody Eleitor e){	
		eleitorService.saveEleitor(e);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@PutMapping("/update/{codigo}")
	public ResponseEntity<Eleitor> updateEleitor(@NonNull @Validated @RequestBody Eleitor e, 
											   @PathVariable long codigo){
		
		Eleitor eSearch = eleitorService.getEleitor(codigo);
		
		if (eleitorService == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		e.setCodigo(eSearch.getCodigo());
		eleitorService.saveEleitor(e);
		
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<Eleitor> deleteEleitor(@NonNull @Validated @PathVariable long codigo){
		
		Eleitor e = eleitorService.getEleitor(codigo);
		
		if (e == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		eleitorService.removerEleitor(e);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Eleitor>> getALLEleitores(){
		eleitorService.adicionaEleitorTeste();
		return new ResponseEntity<>(eleitorService.getALL(), HttpStatus.OK);
	}
	
}


