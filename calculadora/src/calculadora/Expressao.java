package calculadora;

public interface Expressao {
	int avalia();
	void aceita(Visitor visitor);
}
