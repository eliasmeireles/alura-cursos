package br.alura.refatoracao.cap5;

public class TestaFatura {
	public static void main(String[] args) {
		
		Fatura fatura = new Fatura();

		double valor1 = fatura.emDolar();
		double valor2 = fatura.emReal();
	}
}