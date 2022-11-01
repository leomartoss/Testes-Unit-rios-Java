package br.com.api.services;

import org.springframework.stereotype.Service;

import br.com.api.models.Produto;

@Service
public class ProdutoService {
	
	public Produto getProduto(long codigo) {
		
		if(codigo > 1000)
			return null;
		
		return new Produto(codigo, "Notebook Apple", 900);
	}
}
