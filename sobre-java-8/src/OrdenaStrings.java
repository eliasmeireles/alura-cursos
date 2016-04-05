import java.util.ArrayList;
import java.util.List;


public class OrdenaStrings {
	public static void main(String[] args) {
		Cliente[] cliente = new Cliente[4];

		List<Cliente> clientes = new ArrayList<Cliente>();
		
		cliente[0] = new Cliente();
		cliente[0].setNome("Elias");
		cliente[0].setEmail("eliasmflilico@gmail.com");
		cliente[0].setTelefone("99999999");
		
		cliente[1] = new Cliente();
		cliente[1].setNome("Roberto");
		cliente[1].setEmail("roberto@gmail.com");
		cliente[1].setTelefone("98899889");
		
		cliente[2] = new Cliente();
		cliente[2].setNome("Mariana");
		cliente[2].setEmail("mariana@gmail.com");
		cliente[2].setTelefone("97879886");
		
		cliente[3] = new Cliente();
		cliente[3].setNome("Gabirel");
		cliente[3].setEmail("gabriel@gmail.com");
		cliente[3].setTelefone("96595412");
		
		clientes.add(cliente[0]);
		clientes.add(cliente[1]);
		clientes.add(cliente[2]);
		clientes.add(cliente[3]);
		
		for (Cliente clienteR : clientes) {
			
			System.out.println(clienteR.getNome());
			System.out.println(clienteR.getEmail());
			System.out.println(clienteR.getTelefone());
			System.out.println("=========================================");
			
		}
	}
}
