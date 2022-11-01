package br.com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.models.Produto;
import br.com.api.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ControllerProduto {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> getProduto(@PathVariable long codigo){
		
		if(codigo < 0) {
			return ResponseEntity.badRequest().build();
		}
		
		Produto produto = produtoService.getProduto(codigo);
		
		if(produto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);
	}
	

}
