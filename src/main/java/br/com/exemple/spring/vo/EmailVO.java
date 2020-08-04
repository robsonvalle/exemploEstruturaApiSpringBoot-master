package br.com.exemple.spring.vo;

import java.io.BufferedInputStream;
import java.util.List;

public class EmailVO {

	private String assunto;
	private String mensagem;
	private String remetente;
	private List<String> destinatarios;
	private BufferedInputStream anexo;
	
	public String getAssunto() {
		return assunto;
	}
	
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public List<String> getDestinatarios() {
		return destinatarios;
	}
	
	public void setDestinatarios(List<String> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public BufferedInputStream getAnexo() {
		return anexo;
	}

	public void setAnexo(BufferedInputStream anexo) {
		this.anexo = anexo;
	}
}
