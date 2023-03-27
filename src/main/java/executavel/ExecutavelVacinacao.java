package executavel;

import model.dao.PessoaDAO;
import model.dao.VacinaDAO;
import model.vo.vacinacao.Pessoa;
import model.vo.vacinacao.TipoPessoa;
import model.vo.vacinacao.Vacina;

public class ExecutavelVacinacao {

	public static void main(String[] args) {
		
		Pessoa pessoa1 = new Pessoa(1, "Arthur", "10/09/2003", "M", "11747407950", TipoPessoa.getTipoPessoaPorValor(3), 3);
		PessoaDAO dbaDePessoa = new PessoaDAO();		
		dbaDePessoa.inserir(pessoa1);
		
		Pessoa pessoa2 = new Pessoa(2, "Victor", "20/10/2004", "M", "11122233344", TipoPessoa.getTipoPessoaPorValor(3), 3);
		dbaDePessoa.inserir(pessoa2);
		
		pessoa2.setNome("Garcia");

		
		if(pessoa1.getId() != null) {
			System.out.println("Pessoa cadastrada com sucesso.");
		}else {
			System.out.println("Erro ao cadastrar pessoa.");
		}
		
		if(dbaDePessoa.excluir(1)) {
			System.out.println("Pessoa foi excluida.");
		}else {
			System.out.println("Erro ao excluir pessoa.");
		}
		
		Vacina vacina = new Vacina(1, "PFIZER", "ALEMANHA", "INICIAL", "10/10/2020", null);
		VacinaDAO vacinas = new VacinaDAO();
		vacinas.inserir(vacina);
		vacinas.excluir(1);
		Vacina vacinaQueExiste = vacinas.consultarPorId(1);
		System.out.println(vacinaQueExiste);
		System.out.println(vacinas.consultarTodos());
		
	}

}
