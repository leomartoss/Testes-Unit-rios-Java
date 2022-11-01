package br.com.api.ApiExercicioNotaFiscal.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.api.ApiExercicioNotaFiscal.services.NotaFiscalService;

@WebMvcTest
public class NFTestController {
	
	@Autowired
	private ControllerNF controllerNF;
	
	@MockBean
    private NotaFiscalService notaFiscalService;

	@BeforeEach
	public void setup() { MockMvcBuilders.standaloneSetup(this.controllerNF); }

	   @Test
	   public void deveRetornarSucesso_QuandoBuscarNF(){}
	

	    @Test
	    public void deveRetornarNaoEncontrado_QuandoBuscarNF(){}

	    @Test
	    public void deveRetornarBadRequest_QuandoBuscarNF(){}

	}
