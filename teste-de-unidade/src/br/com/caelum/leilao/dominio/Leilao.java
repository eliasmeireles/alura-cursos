package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		if (lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance);
		}
	}

	public void propoeDobroDoUltimoLance(Usuario usuario) {
		if (podeDarLance(usuario)) {
			Lance ultimotLanceDobrado = dobraUltimoLanceDadoPor(usuario);
			propoe(ultimotLanceDobrado);
		}
	}

	private Lance dobraUltimoLanceDadoPor(Usuario usuario) {
		Lance dobro = null;
		for (Lance lance : lances) {
			if (lance.getUsuario().equals(usuario)) {
				dobro = new Lance(usuario, lance.getValor() * 2);
			}
		}
		return dobro;
	}


	private boolean podeDarLance(Usuario usuario) {
		return !ultimoLanceDado().getUsuario().equals(usuario) && qtdDelancesDo(usuario) < 5;
	}

	private int qtdDelancesDo(Usuario usuario) {
		int total = 0;
		for (Lance lance : lances) {
			if (lance.getUsuario().equals(usuario))
				total++;
		}
		return total;
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

}
