package br.com.example.spring.enums;

public enum TipoParametro {
	
	CONFIG_HOST_SERVIDOR_SMTP("Endereço do servidor de SMTP", TipoDadoParametro.STRING, ModuloParametro.EMAIL, null, null, "", TipoValorParametro.SISTEMA),
	CONFIG_PORTA_SERVIDOR_SMTP("Porta do servidor de SMTP", TipoDadoParametro.INTEGER, ModuloParametro.EMAIL, null, null, "587", TipoValorParametro.SISTEMA),
	CONFIG_USUARIO_SERVIDOR_SMTP("Usuário do servidor de SMTP", TipoDadoParametro.STRING, ModuloParametro.EMAIL, null, null, "", TipoValorParametro.SISTEMA),
	CONFIG_SENHA_SERVIDOR_SMTP("Senha do servidor de SMTP", TipoDadoParametro.PASSWORD, ModuloParametro.EMAIL, null, null, "", TipoValorParametro.SISTEMA),
	CONFIG_SERVIDOR_SMTP_REQUER_AUTENTICACAO("Servidor de SMTP requer autenticação", TipoDadoParametro.BOOLEAN, ModuloParametro.EMAIL, null, null, "true", TipoValorParametro.SISTEMA),
	CONFIG_TLS_ATIVO_SERVIDOR_SMTP("Utilizar a criptografia STARTTLS", TipoDadoParametro.BOOLEAN, ModuloParametro.EMAIL, null, null, "false", TipoValorParametro.SISTEMA);

	
	TipoParametro(String nome, TipoDadoParametro tipoDadoParametro, ModuloParametro moduloParametro, TipoParametro tipoPai, Object[] dominio, String valorPadrao, TipoValorParametro tipoValorParametro) {
		this.nome = nome;
		this.tipoDadoParametro = tipoDadoParametro;
		this.moduloParametro = moduloParametro;
		this.tipoPai = tipoPai;
		this.dominio = dominio;
		this.valorPadrao = valorPadrao;
		this.tipoValorParametro = tipoValorParametro;
	}

	private String nome;
	private TipoDadoParametro tipoDadoParametro;
	private ModuloParametro moduloParametro;
	private TipoParametro tipoPai;
	private Object[] dominio;
	private String valorPadrao;
	private TipoValorParametro tipoValorParametro;

	public String getNome() {
		return nome;
	}

	public TipoDadoParametro getTipoDadoParametro() {
		return tipoDadoParametro;
	}

	public ModuloParametro getModuloParametro() {
		return moduloParametro;
	}

	public TipoParametro getTipoPai() {
		return tipoPai;
	}
	
	public Object[] getDominio() {
		return dominio;
	}
	
	public String getValorPadrao() {
		return valorPadrao;
	}

	public TipoValorParametro getTipoValorParametro() {
		return tipoValorParametro;
	}

}
