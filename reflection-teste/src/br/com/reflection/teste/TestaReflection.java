package br.com.reflection.teste;

public class TestaReflection {
	
	public static void main(String[] args) throws Exception {
		
		Pessoa pessoa = new Pessoa();
		
		
		pessoa.setEmail("eliasmflili@gmail.com");
		pessoa.setIdade(37);
		pessoa.setNome("Elias");
		
		
		System.out.println(GeraXmlReflection.verificador(pessoa));
		
	}
}
