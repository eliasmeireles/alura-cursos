package calculadora;

public class TestaCalculadora {
	
	public static void main(String[] args) {
		Expressao esquerda = new Soma(new Subtracao(new Numero(250), new Numero(325)), new Numero(10));
		Expressao direita = new Soma(new Numero(10), new Numero(10));
		
		Expressao conta = new Soma(esquerda, direita);
		
		int res = conta.avalia();
		Expressao raizQuadrada = new RaizQuadrada(new Numero(9));
		
		
		ImpressoraVisitor impressoraVisitor = new ImpressoraVisitor();
		conta.aceita(impressoraVisitor);
		System.out.println("");
		System.out.println(res);
		
		PreFixaVisitor preFixaVisitor = new PreFixaVisitor();
		conta.aceita(preFixaVisitor);
		
		
	}
}
