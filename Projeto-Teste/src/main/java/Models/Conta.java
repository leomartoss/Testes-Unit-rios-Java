package Models;

public class Conta {	
	    public int conta;
	    public int agencia;
	    public double valor;
	    public double saldo;
	    
	    public int getConta() {
			return conta;
		}
	    
		public void setConta(int conta) {
			this.conta = conta;
		}
		
		public int getAgencia() {
			return agencia;
		}
		
		public void setAgencia(int agencia) {
			this.agencia = agencia;
		}
		
		public double getSaldo() {
			return saldo;
		}

	    public boolean sacar(double valor, double saldo){
	        if (valor > saldo){
	            return false;
	        } else {
			return true;
	        }
	    }

	    public boolean transferir(double valor, double saldo){
	        if (valor < saldo){
	            return false;
	        } else {
	            return true;
	        }
	    }

	    public boolean depositar(double valor){
	        if (valor > 0){
	            return true;
	        } else {
	            return false;
	        }
	    }

	}


