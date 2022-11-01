package br.com.api.controllers;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.api.models.Eleitor;
import br.com.api.services.EleitorService;
import io.restassured.http.ContentType;

@WebMvcTest
public class EleitorTestController {

    @Autowired
    private ControllerEleitor controllerEleitor;

    @MockBean
    private EleitorService eleitorService;

    @BeforeEach
    public void setup() {
        MockMvcBuilders.standaloneSetup(this.controllerEleitor);
    }

    @Test
    public void deveRetornarComSucessoEleitorEncontrado() {
        when(this.eleitorService.getEleitor(10)).thenReturn(new Eleitor(1,"Joao Aula Teste", "1111111111",1313));        
        given().accept(ContentType.JSON).when().get("api/eleitores/novo/{codigo}", 10).then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deveRetornarEleitorNaoEncontrado() {
        when(this.eleitorService.getEleitor(13)).thenReturn(null);
        given().accept(ContentType.JSON).when().get("/api/eleitores/{codigo}", 225).then().statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void deveRetornarBadRequestPorCodigoNegativo() {        
        given().accept(ContentType.JSON).when().get("/api/eleitores/{codigo}", -9).then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
        verify(this.eleitorService, never()).getEleitor(9);
    }    

}