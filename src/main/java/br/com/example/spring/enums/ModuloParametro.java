package br.com.example.spring.enums;

public enum ModuloParametro {

	GERAL("Gerais", true),
	CERCA_VIRTUAL("Cerca Virtual", true),
	EMAIL("E-mail", false),
	MONDELEZ("Mondelez", false),
	ANDROID("Mobile - Android", true),
	NUVEM("Nuvem", false),
	CALENDARIO("Calendário", true),
	JORNADA_TRABALHO("Jornada de Trabalho", true),
	AJUDA_CUSTO("Ajuda de Custo", true);
	
	private String nome;
	private boolean moduloConfiguradoPorUsuario;

	private ModuloParametro(String nome, boolean moduloConfiguradoPorUsuario) {
		this.nome = nome;
		this.moduloConfiguradoPorUsuario = moduloConfiguradoPorUsuario;
	}

	public String getNome() {
		return nome;
	}
	
	public boolean isModuloConfiguradoPorUsuario() {
		return moduloConfiguradoPorUsuario;
	}

}
