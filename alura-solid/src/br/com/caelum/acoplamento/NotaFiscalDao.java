package br.com.caelum.acoplamento;

public class NotaFiscalDao implements AcaoPosGeraNota {

	@Override
	public void executa(NotaFiscal nf) {
        System.out.println("salva nf no banco");
    }
}
