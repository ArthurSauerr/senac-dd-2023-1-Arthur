package model.vo.vacinacao;

import java.time.LocalDateTime;

public class Pessoa {
	
	private int id;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String cpf;
	private TipoPessoa tipoPessoa;
	private double notaVacina;
	
	public Pessoa(int id, String nome, String dataNascimento, String sexo, String cpf, TipoPessoa tipoPessoa, double notaVacina) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipoPessoa = tipoPessoa;
		this.notaVacina = notaVacina;
	}

	public Pessoa() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public double getNotaVacina() {
		return notaVacina;
	}

	public void setNotaVacina(double notaVacina) {
		this.notaVacina = notaVacina;
	}

	public void imprimir() {
		System.out.printf("\n%3d  %-13s  %-20s  %-11s  %-25s  %-13s", 
		this.getId(),
		this.getNome(),
		this.getDataNascimento(),
		this.getSexo(),
		this.getCpf(),
		this.getNotaVacina());
	}
	
}
