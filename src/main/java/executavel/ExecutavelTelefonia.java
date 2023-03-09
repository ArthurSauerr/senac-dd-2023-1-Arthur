package executavel;

import java.util.ArrayList;
import java.util.List;

import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Endereco endereco1 = new Endereco("88000123", "Mauro Ramos", "10", "Centro", "Florianópolis", "SC");
		Cliente pele = new Cliente ("Edson", "11122233344", null, true, endereco1 );
		
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		Telefone telefone1 = new Telefone("48", "32328888", true, false);
		telefonesDoSocrates.add(new Telefone("48", "988881234", true, true));
		Cliente socrates = new Cliente("Sócrates", "33322233344", telefonesDoSocrates , true, null);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(pele);
		clientes.add(socrates);
		
		System.out.println("---------- Clientes da Firma ----------");
		for(Cliente c: clientes) {
			System.out.println(c.toString());
		}

	}

}
