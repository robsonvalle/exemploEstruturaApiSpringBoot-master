package br.com.example.spring.enums;

public enum TipoDadoParametro {
	STRING("Texto"),
	INTEGER("Inteiro"),
	REAL("Real"),
	BOOLEAN("Sim ou Não"),
	DATE("Data"),
	HOUR("Hora"),
	DATE_HOUR("Data e Hora"),
	PASSWORD("Senha");

	private String nome;

	private TipoDadoParametro(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
