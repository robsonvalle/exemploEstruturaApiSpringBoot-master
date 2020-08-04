package br.com.example.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO", indexes = { @Index(name = "IDX_NOME", columnList = "NOME") })
public class Produto implements Serializable {

	private static final long serialVersionUID = -7023455488399103384L;

	@Id
	@SequenceGenerator(name = "GENERATOR_PRODUTO", sequenceName = "PROD_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GENERATOR_PRODUTO")
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "IMAGEM", nullable = false)
	private String imagem;

	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Column(name = "VALOR", nullable = false)
	private String valor;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Column(name = "ATIVO", nullable = false)
	private Boolean status;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


}
