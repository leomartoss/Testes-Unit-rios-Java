package br.com.api.integracao;

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

import br.com.api.controllers.ControllerEleitor;
import br.com.api.models.Eleitor;
import br.com.api.services.EleitorService;
import io.restassured.http.ContentType;

@WebMvcTest
public class EleitorTestIntegracao {

    @Autowired
    private ControllerEleitor controllerEleitor;

    @MockBean
    private EleitorService eleitorService;

    @BeforeEach
    public void setup() {
        MockMvcBuilders.standaloneSetup(this.controllerEleitor);
    }

    @Test
    public void criarNovoEleitorTesteIntegracao() {
        when(this.eleitorService.getEleitor(10)).thenReturn(new Eleitor(10,"Yuyu Hakusho", "1997",15145));        
        given().accept(ContentType.JSON).when().get("/eleitores/{codigo}", 10).then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void buscarEleitorTesteIntegracao() {
        when(this.eleitorService.getEleitor(11)).thenReturn(null);
        given().accept(ContentType.JSON).when().get("/eleitores/{codigo}", 2).then().statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void atualizarEleitorTesteIntegracao() {        
        given().accept(ContentType.JSON).when().get("/eleitores/{codigo}", -10).then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
        verify(this.eleitorService, never()).getEleitor(-10);
    }    
    
    @Test
    public void removerEleitorTesteIntegracao() {        
        given().accept(ContentType.JSON).when().get("/eleitores/{codigo}", -10).then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
        verify(this.eleitorService, never()).getEleitor(-10);
    }    
    

}