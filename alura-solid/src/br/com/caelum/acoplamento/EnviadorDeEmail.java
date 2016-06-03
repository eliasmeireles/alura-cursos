package br.com.caelum.acoplamento;

public class EnviadorDeEmail implements AcaoPosGeraNota {

	@Override
	public void executa(NotaFiscal nf) {
        System.out.println("envia email da nf " + nf.getId());
    }
}
