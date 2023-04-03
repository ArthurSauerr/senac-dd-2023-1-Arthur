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
		
		Endereco endereco1 = new Endereco("Mauro Ramos", "88000123", "10", "Centro", "Florian�polis", "SC");
		EnderecoDAO dbaDeEnderecos = new EnderecoDAO();
		//salvadorDeEnderecos.inserir(endereco1);
		/*
		if(endereco1.getId() != null) {
			System.out.println("Novo endere�o cadastrado.");
		} else {
			System.out.println("Erro ao cadastrar endere�o.");
		}
		
		Endereco endereco2 = dbaDeEnderecos.consultarPorId(2);
		System.out.println(endereco2);
		endereco2.setRua("Rua do Limoeiro");
		
		boolean atualizou = dbaDeEnderecos.atualizar(endereco2);
		endereco2 = dbaDeEnderecos.consultarPorId(2);
		
		if(atualizou) {
			System.out.println("Endere�o atualizado.");
		} else {
			System.out.println("Erro ao atualizar endere�o.");
		}
		
		if(dbaDeEnderecos.excluir(1)) {
			System.out.println("Endere�o foi exclu�do");
		}else {
			System.out.println("Erro ao excluir endere�o");
		}
		
		
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		telefonesDoSocrates.add(new Telefone("48", "988881234", true, true));
		Cliente socrates = new Cliente("S�crates", "33322233344", telefonesDoSocrates , true, null);
		Cliente pele = new Cliente ("Edson", "11122233344", null, true, endereco1 );
		*/
		Telefone telefone1 = new Telefone("48", "32328888", true, false);
		TelefoneDAO dbaDeTelefones = new TelefoneDAO();
		dbaDeTelefones.inserir(telefone1);
		
		if(telefone1.getId() != null) {
			System.out.println("Novo telefone cadastrado.");
		} else {
			System.out.println("Erro ao cadastrar telefone.");
		}
		
		Telefone telefoneJaExiste = dbaDeTelefones.consultarPorId(1);
		
		System.out.println(telefoneJaExiste);
		telefoneJaExiste.setNumero("91297069");
		
		boolean atualizouTelefone = dbaDeTelefones.atualizar(telefoneJaExiste);
		if(atualizouTelefone) {
			System.out.println("Telefone atualizado.");
		}else {
			System.out.println("Erro ao atualizar telefone");
		}
		
		System.out.println(telefoneJaExiste);
	/*
		if(dbaDeTelefones.excluirTelefone(7)) {
			System.out.println("Telefone foi exclu�do");
		} else {
			System.out.println("Erro ao exclu�r telefone");
		}
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(pele);
		clientes.add(socrates);
		
		System.out.println("---------- Clientes da Firma ----------");
		for(Cliente c: clientes) {
			System.out.println(c.toString());
		}
*/
	}

}
