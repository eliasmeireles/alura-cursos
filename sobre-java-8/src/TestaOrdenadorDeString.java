import java.util.ArrayList;
import static java.util.Comparator.*;
import java.util.List;

public class TestaOrdenadorDeString {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		//Lambda
		/*palavras.sort((s0, s1) -> Integer.compare(s0.length(),s1.length()));*/
		
		/*palavras.sort(Comparator.comparing(s -> s.length()));*/
		
		/*Import static*/
		palavras.sort(comparing(String::length));
		palavras.sort(String.CASE_INSENSITIVE_ORDER);

		palavras.forEach(s -> System.out.println(s));
		
		
		palavras.forEach(System.out::println);
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}
}
