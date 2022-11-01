package br.com.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Models.Conta;

@SpringBootTest
class ContaTeste {
	
	Conta testeConta = new Conta();

	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("Teste conta existente")
	void testeContaExiste() {
		Conta conta = new Conta();
		conta.setConta(3129380);
		
		assertEquals(3129380, conta.getConta());
	}
	
	@Test
	@DisplayName("Teste Saque")
	void testeSaque(){
		testeConta.sacar(500, 1000);
		//OK
		assertEquals(500, testeConta.getSaldo());
	}
	
	@Test
	@DisplayName("Teste Sem Saldo")
	void testeSaqueInsuficiente(){
		testeConta.sacar(500, 2);
		//NOT OK
		assertEquals(500, testeConta.getSaldo());
	}
	
	@Test
	@DisplayName("Teste Transferencia")
	void testeTransferencia(){
		testeConta.transferir(500, 5000);
		//OK
		assertEquals(500, testeConta.getSaldo());
	}
	
	@Test
	@DisplayName("Teste Transferencia")
	void testeTransferenciaNotOk(){
		testeConta.transferir(500, 0);
		//NOT OK
		assertEquals(500, testeConta.getSaldo());
	}
	
	@Test
	@DisplayName("Teste Deposito")
	void testeDeposito(){
		testeConta.depositar(500);
		//OK
		assertEquals(500, testeConta.getSaldo());
	}
	@Test
	@DisplayName("Teste Deposito Negativo")
	void testeDepositoNotOk(){
		testeConta.depositar(-500);
		//NOT OK
		assertEquals(500, testeConta.getSaldo());
	}
	
	

}
