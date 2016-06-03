package br.com.caelum.pm73.builder;

import java.util.Calendar;

import br.com.caelum.pm73.dominio.Leilao;
import br.com.caelum.pm73.dominio.Usuario;

public class LeilaoBuilder {
	private Usuario dono;
	private double valor;
	private String nome;
	private boolean usado;
	private Calendar dataAbertura;
	private boolean encerrado;

	public LeilaoBuilder() {
		this.dono = new Usuario("Joao da Silva", "joao@silva.com.br");
		this.valor = 1500.0;
		this.nome = "XBox";
		this.usado = false;
		this.dataAbertura = Calendar.getInstance();
	}

	public LeilaoBuilder comDono(Usuario dono) {
		this.dono = dono;
		return this;
	}

	public LeilaoBuilder comValor(double valor) {
		this.valor = valor;
		return this;
	}

	public LeilaoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public LeilaoBuilder usado() {
		this.usado = true;
		return this;
	}

	public LeilaoBuilder comLance(Calendar dataDoLance, Usuario done, double valor) {
		this.dataAbertura = dataDoLance;
		this.dono = done;
		this.valor = valor;
		return this;
	}

	public LeilaoBuilder encerrado() {
		this.encerrado = true;
		return this;
	}

	public LeilaoBuilder diasAtras(int dias) {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DAY_OF_MONTH, -dias);

		this.dataAbertura = data;

		return this;
	}


	public Leilao constroi() {
		Leilao leilao = new Leilao(nome, valor, dono, usado);
		leilao.setDataAbertura(dataAbertura);
		if (encerrado)
			leilao.encerra();

		return leilao;
	}

}
