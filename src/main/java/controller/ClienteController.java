package controller;

import java.util.List;

import model.bo.ClienteBO;
import model.exception.CampoInvalidoException;
import model.exception.ClienteComTelefoneException;
import model.exception.CpfAlteradoException;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;

public class ClienteController {

	private ClienteBO bo = new ClienteBO();
	
	public Cliente inserir(Cliente novoCliente) throws CpfJaUtilizadoException, 
			EnderecoInvalidoException, CampoInvalidoException {
		
		//TODO validar o preenchimento dos campos obrigatórios
		return bo.inserir(novoCliente);
	}
	
	public boolean atualizar(Cliente clienteAlterado) throws EnderecoInvalidoException, CpfAlteradoException {
		//TODO validar o preenchimento dos campos obrigatórios
		return bo.atualizar(clienteAlterado);
	}
	
	public void validarCamposObrigatorios(Cliente c) throws CampoInvalidoException {
		if(c.getNome() != null && c.getNome().trim().length() < 2) {
			throw new CampoInvalidoException("Nome invalido.");
		}
		validarCpf(c);
	}
	
	private void validarCpf(Cliente c) throws CampoInvalidoException {
		String cpfSemMascara = c.getCpf();
		cpfSemMascara = c.getCpf().replace(".", "");
		c.setCpf(cpfSemMascara);
		
		if(c.getCpf() != null) {
			if(c.getCpf().length() != 11) {
				throw new CampoInvalidoException("CPF deve possuir 11 digitos");
			}
			try {
				Integer.valueOf(c.getCpf());
			} catch (NumberFormatException ex) {
				throw new CampoInvalidoException("CPF deve possuir apenas numeros");
			}
		}
		
	}

	public boolean excluir(int id) throws ClienteComTelefoneException {
		return bo.excluir(id);
	}
	
	public Cliente consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Cliente> consultarTodos() {
		return bo.consultarTodos();
	}
}