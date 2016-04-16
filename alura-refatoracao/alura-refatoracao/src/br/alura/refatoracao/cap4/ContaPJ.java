package br.alura.refatoracao.cap4;

public class ContaPJ extends ContaBancaria {
	
	public ContaPJ(String titular, double saldo) {
		super(titular, saldo);
	}

	public void saca(double valor) {
		saldo -= valor + 0.2;
	}
	
	public void deposita(double valor) {
		saldo += valor - 0.2;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getTitular() {
		return titular;
	}
	
}
