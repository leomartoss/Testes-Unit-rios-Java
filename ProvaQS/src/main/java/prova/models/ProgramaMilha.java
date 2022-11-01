package prova.models;

import java.util.Scanner;

public class ProgramaMilha {
private String nomeCliente;
private String cpf;
private int saldoMilhas;
private int qtdOperacoes;
private double saldoSaque;

Scanner scan = new Scanner(System.in);

public ProgramaMilha(String nomeCliente, String cpf) {
	super();
	
	this.nomeCliente = nomeCliente;
	this.cpf = cpf;
	this.saldoMilhas = 0;
	this.qtdOperacoes = 0;
	this.saldoSaque = 0;	
}

public String getNomeCliente() {
	return nomeCliente;
}

public String setNomeCliente(String nomeCliente) {
	return this.nomeCliente = nomeCliente;
}

public String getCpf() {
	return cpf;
}

public String setCpf(String cpf) {
	return this.cpf = cpf;
}

public int getSaldoMilhas() {
	return saldoMilhas;
}

public int getQtdOperacoes() {
	return qtdOperacoes;
}

public double getSaldoSaque() {
	return saldoSaque;
}

public boolean comprarMilhas(double valor) {
	if(this.getQtdOperacoes() < 10 && valor > 0)
	{
		this.saldoMilhas = (int)(valor * 5);
		this.qtdOperacoes += 1;
		return true;			
	}
	if(this.getQtdOperacoes() >= 10 && valor > 0) {
		this.saldoMilhas = (int)(valor * 8);
		this.qtdOperacoes += 1;
		return true;
	}
	else {
		return false;
	}	
}

public boolean venderMilhas(int milhas) {	
	
	saldoSaque = 50.00;
	
	if(this.getSaldoSaque() > 0) {
		milhas = (int)(saldoSaque * 3);
		this.saldoMilhas -= milhas;
		return true;
	}
	return false;	
}

public boolean sacarSaldo(double valor) {
	if(this.getSaldoSaque() > 0 && valor < this.getSaldoSaque()) {
		this.saldoSaque -= valor;
		return true;
	}
	return false;
}

public boolean incluirMilhas(int milhas) {
	if(milhas > 0) {
		this.saldoMilhas += milhas;
		return true;
	}
	return false;
}

public boolean transferirMilhas(int milhas, ProgramaMilha destino) {
	
		
	if(this.getSaldoMilhas() >= milhas && milhas > 0) {
		this.saldoMilhas -= milhas;
		destino.comprarMilhas(milhas);
		qtdOperacoes += saldoMilhas;
		return true;
	}
	return false;
	
}
}


