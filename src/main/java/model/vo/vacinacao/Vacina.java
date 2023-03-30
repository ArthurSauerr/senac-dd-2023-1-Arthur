package model.vo.vacinacao;

import java.time.LocalDateTime;

public class Vacina {
	
	private Integer id;
	private String nome;
	private String paisOrigem;
	private String estagio;
	private String dataPesquisa;
	private Pessoa pesquisador;
	
	public Vacina(Integer id, String nome, String paisOrigem, String estagio, String dataPesquisa, Pessoa pesquisador) {
		super();
		this.id = id;
		this.nome = nome;
		this.paisOrigem = paisOrigem;
		this.estagio = estagio;
		this.dataPesquisa = dataPesquisa;
		this.pesquisador = pesquisador;
	}

	public Vacina() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getEstagio() {
		return estagio;
	}

	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}

	public String getDataPesquisa() {
		return dataPesquisa;
	}

	public void setDataPesquisa(String dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	public Pessoa getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(Pessoa pesquisador) {
		this.pesquisador = pesquisador;
	}

	@Override
	public String toString() {
		return "Vacina: " + getNome() 
				+ "\nPais de Origem: " + getPaisOrigem() 
				+ "\nEstagio: " + getEstagio() 
				+ "\nData da Pesquisa: " + getDataPesquisa() 
				+ "\nPesquisador: " + getPesquisador().getNome();
	}
	
	

}
