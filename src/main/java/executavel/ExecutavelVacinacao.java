package executavel;

import model.dao.PessoaDAO;
import model.vo.vacinacao.Pessoa;
import model.vo.vacinacao.TipoPessoa;

public class ExecutavelVacinacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pessoa pessoa1 = new Pessoa(1, "Arthur", "10/09/2003", "M", "11747407950", TipoPessoa.getTipoPessoaPorValor(3), 3);
		PessoaDAO dbaDePessoa = new PessoaDAO();
		dbaDePessoa.inserir(pessoa1);
		
	}

}
