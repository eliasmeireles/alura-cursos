package br.com.alura.threads;

public class ImprimeString implements Runnable {

	@Override
	public void run() {
		System.out.println("Excultando em Trhead!");
	}

}
