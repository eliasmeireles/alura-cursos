import java.util.ArrayList;
import java.util.List;

public class TestaOrdenadorDeString {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		palavras.sort((s0, s1) -> Integer.compare(s0.length(),s1.length()));

		palavras.forEach(s -> System.out.println(s));
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}
}
