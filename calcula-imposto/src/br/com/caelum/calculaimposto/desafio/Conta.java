package br.com.caelum.calculaimposto.desafio;

public class Conta {
	private double saldo;
	private String nome;
	private int numero;
	private int agencia;

    public void deposita(double valor) {
      this.saldo += valor;
    }

    public double getSaldo() {
      return this.saldo;
    }

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
}
