import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TesteDeOrdenadorDeAlfabetico {

	public static void main(String[] args) {

	/*	List<String> alfabeto = new ArrayList<>();
		
		String teste = ("testando a ordem em alfabeto");
		String[] ordenado = new String[teste.length()];
		
		
		for (int i = 0; i < teste.length(); i++) {
			ordenado[i] = teste.charAt(i) + "";
			alfabeto.add(ordenado[i]);
			
		}
		
		
		alfabeto.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(alfabeto);
		
		*/
		
		
		
		Set<Integer> sorteados = new HashSet<>();
		
		while (sorteados.size() < 6) {
			sorteados.add(1 + (int) (Math.random() * 60 ));
		}
		List<Integer> numeros = new ArrayList<>(sorteados);
		Collections.sort(numeros);
		
		System.out.println(numeros);
		
		
		
		
		
	}

}
