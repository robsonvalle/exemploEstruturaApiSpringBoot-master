package br.com.example.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO", indexes = { @Index(name = "IDX_EMAIL", columnList = "EMAIL") })
public class PedidoItem implements Serializable {

	private static final long serialVersionUID = -7023455488399103384L;

	@Id
	@SequenceGenerator(name = "GENERATOR_PEDIDO", sequenceName = "PEDIDO_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GENERATOR_PEDIDO")
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "NUMPEDIDO", nullable = false)
	private String numpedido;
	
	@Column(name = "NOMECLIENTE", nullable = false)
	private String nomecliente;

	@Column(name = "VALOR", nullable = false)
	private Double valor;
	
	public String getNumpedido() {
		return numpedido;
	}

	public void setNumpedido(String numpedido) {
		this.numpedido = numpedido;
	}

	public String getNomecliente() {
		return nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "DATA", nullable = false)
	private Date data;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
