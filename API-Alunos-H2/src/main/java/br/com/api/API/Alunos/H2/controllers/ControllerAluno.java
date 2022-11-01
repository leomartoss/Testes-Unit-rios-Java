package br.com.api.API.Alunos.H2.controllers;

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

import br.com.api.API.Alunos.H2.models.Aluno;
import br.com.api.API.Alunos.H2.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class ControllerAluno {
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Aluno>getAluno(@PathVariable("codigo")long codigo){
		
	if(codigo<0)
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	
	Aluno aluno = alunoService.getAluno(codigo);
	
	if(aluno==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	return new ResponseEntity<>(aluno, HttpStatus.OK);
	}
	
	@PostMapping("/novo")
	public ResponseEntity<Aluno> addProduto(@NonNull @Validated @RequestBody Aluno aluno){
		alunoService.saveAluno(aluno);
		return new ResponseEntity<>(aluno, HttpStatus.OK);
	}
	
	@PutMapping("/update/{codigo}")
	public ResponseEntity<Aluno> editProduto(@NonNull @Validated @RequestBody Aluno aluno, @PathVariable long codigo){
		
		Aluno alunoSearch = alunoService.getAluno(codigo);
		
		if(alunoSearch == null) {
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		aluno.setCodigo(alunoSearch.getCodigo());
		alunoService.saveAluno(alunoSearch);
		
		return new ResponseEntity<>(aluno, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<Aluno> deleteProduto(@NonNull @Validated @PathVariable long codigo){
		
		Aluno aluno = alunoService.getAluno(codigo);
		
		if(aluno == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		
		alunoService.removerAluno(aluno);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Aluno>>getAllProdutos(){
		alunoService.adicionaAlunosTeste();
		return new ResponseEntity<>(alunoService.getALL(), HttpStatus.OK);
		
	}
	
}
