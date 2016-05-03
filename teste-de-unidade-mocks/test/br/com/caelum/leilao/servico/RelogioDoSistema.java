package br.com.caelum.leilao.servico;

import java.util.Calendar;

import br.com.caelum.leilao.infra.data.Relogio;

public class RelogioDoSistema implements Relogio {

	@Override
	public Calendar hoje() {
		return Calendar.getInstance();
	}

}
