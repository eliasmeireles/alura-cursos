package br.com.caelum.coesao;

public enum Cargo {
	DESENVOLVEDOR(new DezOuVintePorcento()),
	DBA(new QuinzeOuVinteECincoPorcento()),
	TESTER(new QuinzeOuVinteECincoPorcento());

	private RegraDeCalculo regra;

	Cargo(RegraDeCalculo regra) {
		this.regra = regra;
	}
	public RegraDeCalculo getRegra() {
		return regra;
	}
	
}
