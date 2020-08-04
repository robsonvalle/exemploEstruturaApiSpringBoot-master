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
@Table(name = "RESUMO", indexes = { @Index(name = "IDX_MES", columnList = "MES") })
public class Resumo implements Serializable {

	private static final long serialVersionUID = -7023455488399103384L;

	@Id
	@SequenceGenerator(name = "GENERATOR_RESUMO", sequenceName = "RESUMO_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GENERATOR_RESUMO")
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "VALOR", nullable = false)
	private Double valor;
	
	@Column(name = "mes", nullable = false)
	private String mes ;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}



}
