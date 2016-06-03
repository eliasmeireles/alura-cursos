package br.com.caelum.acoplamento;

import java.util.List;

public class GeradorDeNotaFiscal {
	

    private List<AcaoPosGeraNota> acoes;

	public GeradorDeNotaFiscal(List<AcaoPosGeraNota> acao) {
		this.acoes = acao;
    }

    public NotaFiscal gera(Fatura fatura) {

        double valor = fatura.getValorMensal();

        NotaFiscal nf = new NotaFiscal(valor, impostoSimplesSobreO(valor));

        for (AcaoPosGeraNota acao : acoes) {
			acao.executa(nf);
		}

        return nf;
    }

    private double impostoSimplesSobreO(double valor) {
        return valor * 0.06;
    }

}
