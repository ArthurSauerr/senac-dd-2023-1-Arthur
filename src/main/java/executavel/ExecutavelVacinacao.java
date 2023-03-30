package executavel;

import model.dao.PessoaDAO;
import model.dao.VacinaDAO;
import model.vo.vacinacao.Pessoa;
import model.vo.vacinacao.TipoPessoa;
import model.vo.vacinacao.Vacina;

public class ExecutavelVacinacao {

	public static void main(String[] args) {
		
		Pessoa pessoa1 = new Pessoa(1, "Arthur", "10/09/2003", "M", "11747407950", TipoPessoa.PESQUISADOR, 5);
		PessoaDAO dbaDePessoa = new PessoaDAO();		
		dbaDePessoa.inserir(pessoa1);
		
		Pessoa pessoa2 = new Pessoa(2, "Victor", "20/10/2004", "M", "11122233344", TipoPessoa.PUBLICO, 3);
//		dbaDePessoa.inserir(pessoa2);
		
		pessoa2.setNome("Garcia");
		dbaDePessoa.atualizar(pessoa2);
		System.out.println(pessoa2);
		
		if(pessoa1.getId() != null) {
			System.out.println("Pessoa cadastrada com sucesso.");
		}else {
			System.out.println("Erro ao cadastrar pessoa.");
		}
		
//		if(dbaDePessoa.excluir(1)) {
//			System.out.println("Pessoa foi excluida.");
//		}else {
//			System.out.println("Erro ao excluir pessoa.");
//		}
		
		Vacina vacina1 = new Vacina(1, "PFIZER", "ALEMANHA", "INICIAL", "10/10/2020", pessoa1);
		VacinaDAO dbaDeVacina = new VacinaDAO();
//		vacinas.inserir(vacina1);
		
//		Vacina vacinaQueExiste = dbaDeVacina.consultarPorId(1);
//		System.out.println(vacinaQueExiste);
//		System.out.println(dbaDeVacinas.consultarTodos());
		
		if(vacina1.getId() != null) {
			System.out.println("Vacina cadastrada com sucesso.");
		}else {
			System.out.println("Erro ao cadastrar vacina");
		}
		
//		if(dbaDeVacina.excluir(1)) {
//			System.out.println("Vacina excluida com sucesso.");
//		}else {
//			System.out.println("Erro ao excluir vacina.");
//		}
		
	}

}
