package prova.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProgramaMilhaTeste {
	ProgramaMilha cliente1 = new ProgramaMilha("Leo", "10");
	ProgramaMilha cliente2 = new ProgramaMilha("Carlos", "392");
	
	@Test
	@DisplayName("Teste Compra Valor Negativo")
	public void testeCompraValorNegativo() {
		assertFalse(cliente1.comprarMilhas(-3939));
	}
	
	@Test
	@DisplayName("Teste Compra Valor Positivo")
	public void testeCompraValorPositivo() {
		assertTrue(cliente1.comprarMilhas(1));
	}
	
	@Test
	@DisplayName("Teste Vender Milhas Saldo Insuficiente")
	public void testeVenderMilhasSaldoInsuficiente() {
		assertFalse(cliente1.venderMilhas(0));
	}
	
	@Test
	@DisplayName("Teste Vender Milhas Saldo Positivo")
	public void testeVenderMilhasSaldoPositivo() {
		assertTrue(cliente1.venderMilhas(1000));
	}
	
	@Test
	@DisplayName("Teste Sacar Saldo Negativo")
	public void testeSacarSaldoNegativo() {
		assertFalse(cliente1.sacarSaldo(-4));
	}
	
	@Test
	@DisplayName("Teste Sacar Saldo Insuficiente")
	public void testeSacarSaldoInsuficiente() {
		assertFalse(cliente1.sacarSaldo(0));
	}
	
	@Test
	@DisplayName("Teste Sacar Saldo Positivo")
	public void testeSacarSaldoPositivo() {
		assertTrue(cliente1.sacarSaldo(10));
	}
	
	@Test
	@DisplayName("Teste Transferir Milhas Valor Negativo")
	public void testeTransferirMilhasValorNegativo() {
		cliente1.comprarMilhas(500);		
		assertFalse(cliente1.transferirMilhas(-11, cliente2));
	}
	
	@Test
	@DisplayName("Teste Transferir Milhas Saldo Insuficiente")
	public void testeTransferirMilhasValorInsuficiente() {
		cliente1.comprarMilhas(0);		
		assertFalse(cliente1.transferirMilhas(500, cliente2));
	}
	
	@Test
	@DisplayName("Teste Transferir Milhas Saldo Positivo")
	public void testeTransferirMilhasValorPositivo() {
		cliente1.comprarMilhas(10);		
		assertFalse(cliente1.transferirMilhas(5, cliente2));
	}
	
}
	

