package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Pagamento;

public interface RepositorioDePagamentos {
	void salvar(Pagamento pagamento);
}
