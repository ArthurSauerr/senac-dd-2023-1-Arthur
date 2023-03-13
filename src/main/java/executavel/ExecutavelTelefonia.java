package executavel;

import java.util.ArrayList;
import java.util.List;

import model.dao.EnderecoDAO;
import model.dao.TelefoneDAO;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Endereco endereco1 = new Endereco("Mauro Ramos", "88000123", "10", "Centro", "Florianópolis", "SC");
		Cliente pele = new Cliente ("Edson", "11122233344", null, true, endereco1 );
		
		EnderecoDAO salvadorDeEnderecos = new EnderecoDAO();
		salvadorDeEnderecos.inserir(endereco1);
		
		if(endereco1.getId() != null) {
			System.out.println("Novo endereço cadastrado.");
		} else {
			System.out.println("Erro ao cadastrar endereço.");
		}
		

		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		telefonesDoSocrates.add(new Telefone("48", "988881234", true, true));
		Cliente socrates = new Cliente("Sócrates", "33322233344", telefonesDoSocrates , true, null);
		
		Telefone telefone1 = new Telefone("48", "32328888", true, false);
		TelefoneDAO salvadorDeTelefones = new TelefoneDAO();
		salvadorDeTelefones.inserir(telefone1);
		
		if(telefone1.getId() != null) {
			System.out.println("Novo telefone cadastrado.");
		} else {
			System.out.println("Erro ao cadastrar telefone.");
		}
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(pele);
		clientes.add(socrates);
		
		System.out.println("---------- Clientes da Firma ----------");
		for(Cliente c: clientes) {
			System.out.println(c.toString());
		}

	}

}
