package br.com.example.spring.util;

import java.io.File;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.example.spring.dto.ParametroDTO;
import br.com.example.spring.service.impl.ParametroService;
import br.com.exemple.spring.vo.EmailVO;


public class UtilEmail {


	private static final String PARAMETRO_SMTP = "SMTP";
	private static final String PARAMETRO_PORTASMTP = "PORTASMTP";
	private static final String PARAMETRO_REQUER_AUTENTICACAO = "REQUERAUTENTICACAO";
	private static final String PARAMETRO_USUARIO = "USUARIO";
	private static final String PARAMETRO_SENHA = "SENHA";
	private static final String PARAMETRO_TLS_ATIVO = "TLSATIVO";
	private String smtp; 
	private String portaSmtp;
	private String requerAutenticacao;
	private String usuario;
	private String senha;
	private String tlsAtivo;
		
	@Autowired
	private ParametroService parametroService;

	private void iniciarParametrosEmail() {
		List<ParametroDTO> listar = parametroService.listar();
		
		smtp = "smtp.gmail.com" ;//listar.stream().filter(v -> v.getChave().equals(PARAMETRO_SMTP)).map(m -> m.getValor()).findAny().get();
		portaSmtp = "461"; //listar.stream().filter(v -> v.getChave().equals(PARAMETRO_PORTASMTP)).map(m -> m.getValor()).findAny().get();
		requerAutenticacao = "true";//listar.stream().filter(v -> v.getChave().equals(PARAMETRO_REQUER_AUTENTICACAO)).map(m -> m.getValor()).findAny().get();
		usuario = "robson.valle@gmail.com";//listar.stream().filter(v -> v.getChave().equals(PARAMETRO_USUARIO)).map(m -> m.getValor()).findAny().get();
		senha = "45631gfa";//listar.stream().filter(v -> v.getChave().equals(PARAMETRO_SENHA)).map(m -> m.getValor()).findAny().get();
		tlsAtivo = "tls";//listar.stream().filter(v -> v.getChave().equals(PARAMETRO_TLS_ATIVO)).map(m -> m.getValor()).findAny().get();

		
	}



	public Boolean verificarParametrosEmail() {
		this.iniciarParametrosEmail();
		return StringUtils.isNotEmpty(smtp) && StringUtils.isNotEmpty(portaSmtp) && StringUtils.isNotEmpty(requerAutenticacao)
				&& StringUtils.isNotEmpty(requerAutenticacao) && StringUtils.isNotEmpty(usuario) && StringUtils.isNotEmpty(senha);
	}

	public void enviaEmailHtml(EmailVO emailVO) throws EmailException {
		
		HtmlEmail email = new HtmlEmail();
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("teste.xlsx"); //caminho da imagem
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Relatorio em anexo");
		attachment.setName("Relatorio.xlsx");
		
		
		
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("robson.valle@gmail.com", "45631gfa"));
		email.setStartTLSEnabled(true);
		email.attach(attachment);
		try {
			email.setFrom("robson.valle@gmail.com", "Realatorio Auditoria");
			email.setDebug(true);
			email.setSubject(emailVO.getAssunto());
			email.setHtmlMsg(emailVO.getMensagem());
			email.setCharset("UTF-8");
			email.addTo("robson.miranda@maximatech.com.br");
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}


	public ParametroService getParametroService() {
		return parametroService;
	}

	public void setParametroService(ParametroService parametroService) {
		this.parametroService = parametroService;
	}
	
}

