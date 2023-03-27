package model.vo.vacinacao;

public enum TipoPessoa {
	
	PESQUISADOR (1),
	VOLUNTARIOS (2),
	PUBLICO (3);

	private int valor;

	private TipoPessoa(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}

	public static TipoPessoa getTipoPessoaPorValor(int valor) {
		TipoPessoa tipoPessoa = null;
		for(TipoPessoa elemento: TipoPessoa.values()) {
			if(elemento.getValor() == valor) {
				tipoPessoa = elemento;
			}
		}
		return tipoPessoa;
	}
}
