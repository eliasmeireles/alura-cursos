package br.com.caelum.leilao.servico;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.data.Relogio;

public class GeradorDePagamento {
	private final Avaliador avaliador;
	private final RepositorioDePagamentos pagamentos;
	private final RepositorioDeLeiloes leiloes;
	private final Relogio relogio;

	public GeradorDePagamento(RepositorioDeLeiloes leiloes, RepositorioDePagamentos pagamentos, Avaliador avaliador,
			Relogio relogio) {
		this.leiloes = leiloes;
		this.pagamentos = pagamentos;
		this.avaliador = avaliador;
		this.relogio = relogio;
	}
	
	public GeradorDePagamento(RepositorioDeLeiloes leiloes, RepositorioDePagamentos pagamentos, Avaliador avaliador) {
		this(leiloes, pagamentos, avaliador, new RelogioDoSistema());
	}

	public void geral() {
		List<Leilao> leiloesEncerrados = leiloes.encerrados();

		for (Leilao leilao : leiloesEncerrados) {
			avaliador.avalia(leilao);
			Pagamento novoPagamento = new Pagamento(avaliador.getMaiorLance(), primeiroDiaUtil());
			pagamentos.salvar(novoPagamento);
		}
	}

	private Calendar primeiroDiaUtil() {
		Calendar data = relogio.hoje();
		int dayOfTheWeek = data.get(Calendar.DAY_OF_WEEK);

		if (dayOfTheWeek == Calendar.SATURDAY) {
			data.add(Calendar.DAY_OF_MONTH, 2);
		} else if (dayOfTheWeek == Calendar.SUNDAY) {
			data.add(Calendar.DAY_OF_MONTH, 1);
		}

		return data;
	}
}
