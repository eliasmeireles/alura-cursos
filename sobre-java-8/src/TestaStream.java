import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class TestaStream {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//Expressão lambda
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		
		//Com resferencia
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		
		//Referencia
		cursos.forEach(System.out::println);
	
		
		//Seleceção dos maiores que ?
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .map(Curso::getAlunos)
		   .forEach(System.out::println);

		//Pegando os relativos maiores que ?
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50);
		   cursos.forEach(c -> System.out.println(c.getNome()));
		   
		   cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .map(c -> c.getAlunos())
		   .forEach(System.out::println);
		   
		   
		   //Filtrando e pegando elementos
		   cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst();
		   
		 //Filtrando e calculando a media
		   OptionalDouble average = cursos.stream()
		    .mapToInt(c -> c.getAlunos())
		    .average();

		   System.out.println(average);
		   
		   //Filtrando os selecionados em uma nova lista
		   cursos = cursos.stream()
				   .filter(c -> c.getAlunos() > 50)
				   .collect(Collectors.toList());
		   
		   System.out.println(cursos);
	}

}
