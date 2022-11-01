package br.com.api.controllers;

import static org.mockito.Mockito.*;
import static io.restassured.RestAssured.*;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.api.models.Produto;
import br.com.api.services.ProdutoService;
import io.restassured.http.ContentType;
@WebMvcTest
public class ControllerProdutoTest {

	@Autowired
	private ControllerProduto produtoController;

	@MockBean
	private ProdutoService produtoService;

	@BeforeEach
	public void setup() {
		MockMvcBuilders.standaloneSetup(this.produtoController);
	}

	@Test
	public void deveRetornarSucesso_QuandoBuscarProduto() {
		when(this.produtoService.getProduto(100)).thenReturn(new Produto(100, "Computadores", 900));
		given().accept(ContentType.JSON).when().get("/produtos/{codigo}", 100).then().statusCode(HttpStatus.SC_OK);
	}

	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarProduto() {
		when(this.produtoService.getProduto(1001)).thenReturn(null);
		given().accept(ContentType.JSON).when().get("/produtos/{codigo}", 1001).then()
				.statusCode(HttpStatus.SC_NOT_FOUND);
	}

	@Test
	public void deveRetornarBadRequest_QuandoBuscarProduto() {
		given().accept(ContentType.JSON).when().get("/produtos/{codigo}", -100).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST);
		verify(this.produtoService, never()).getProduto(-100);
	}

}
