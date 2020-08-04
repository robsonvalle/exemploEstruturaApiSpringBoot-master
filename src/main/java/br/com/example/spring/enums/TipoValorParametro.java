package br.com.example.spring.enums;

public enum TipoValorParametro {
	USUARIO("Usuário"),
	SISTEMA("Sistema");

	private String nome;

	private TipoValorParametro(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
