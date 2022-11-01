package br.com.api.API.Alunos.H2.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.api.API.Alunos.H2.services.AlunoService;

@WebMvcTest
public class ControllerAlunoTest {
    
    @Autowired
    private ControllerAluno controllerAluno;
    
    @MockBean
    private AlunoService alunoService;
    
    @BeforeEach
    public void setup() { standaloneSetup(this.controllerAluno); }
    

    private void standaloneSetup(ControllerAluno controllerAluno2) {
        // TODO Auto-generated method stub
        
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarAluno() {
        
    }
    
    @Test
    public void deveRetornarNaoEncontrado_QuandoBuscarAluno() {}
    
    @Test
    public void deveRetornarBadRequest_QuandoBuscarAluno() {}
    

}
