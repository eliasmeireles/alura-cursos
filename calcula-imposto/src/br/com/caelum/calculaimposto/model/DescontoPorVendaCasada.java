package br.com.caelum.calculaimposto.model;

public class DescontoPorVendaCasada implements Desconto {

	private Desconto proximo;


    private boolean aconteceuVendaCasadaEm(Orcamento orcamento) {
        return existe("CANETA", orcamento) && existe("LAPIS", orcamento);
    }

    private boolean existe(String nomeDoItem, Orcamento orcamento) {
        for (Item item : orcamento.getItens()) {
            if(item.getNome().equals(nomeDoItem)) return true;
        }
        return false;
    }

	@Override
	public double desconta(Orcamento orcamento) {
		if (aconteceuVendaCasadaEm(orcamento))
			return orcamento.getValor() * 0.05;
		else
			return proximo.desconta(orcamento);
	}

    @Override
    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }

}
