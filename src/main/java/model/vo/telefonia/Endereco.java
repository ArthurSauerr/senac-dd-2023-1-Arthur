package model.vo.telefonia;

public class Endereco {
	
	private Integer id;
	private String rua;
	private String cep;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;

	
	public Endereco() {

	}

	public Endereco(Integer id, String rua, String cep, String numero, String bairro, String cidade, String estado) {
		super();
		this.id = id;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Endereco(String rua, String cep, String numero, String bairro, String cidade, String estado) {
		super();
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return getEnderecoResumido();
	}

	public String getEnderecoResumido() {
		return rua + " nº" + numero + ", " + bairro + ", " + cidade + "/" + estado;
	}
}
