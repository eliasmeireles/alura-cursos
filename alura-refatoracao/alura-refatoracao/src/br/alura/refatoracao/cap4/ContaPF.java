package br.alura.refatoracao.cap4;

public class ContaPF extends ContaBancaria {
	
	public ContaPF(String titular, double saldo) {
		super(titular, saldo);
	}

	public void saca(double valor) {
		saldo -= valor + 0.1;
	}
	
	public void deposita(double valor) {
		saldo += valor - 0.1;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getTitular() {
		return titular;
	}
	
}
