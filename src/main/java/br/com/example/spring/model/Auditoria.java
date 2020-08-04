package br.com.example.spring.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AUDITORIA", indexes = { @Index(name = "IDX_CODIGOCLIENTE", columnList = "CODIGOCLIENTE") })
public class Auditoria implements Serializable {

	private static final long serialVersionUID = -7023455488399103384L;

	@Id
	@SequenceGenerator(name = "GENERATOR_AUDITORIA", sequenceName = "AUDITORIA_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GENERATOR_AUDITORIA")
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;
	@Column(name = "CODIGOCLIENTE", nullable = false)
	private String codigo;
	@Column(name = "USUARIOID", nullable = false)
	private Long usuario;
	
	@Column(name = "NOMEUSUARIO", nullable = false)
	private String nome;
	
	@Column(name = "QTSINCRONIZACAO", nullable = false)
	private Integer sincronizacao;
	
	@Column(name = "QTVISITAS", nullable = false)
	private Integer visitas;
	
	@Column(name = "ULTIMASINCRONIZACAO", nullable = false)
	private LocalDateTime ultimaSincronizacao;
	
	@Column(name = "DATAREGISTRO", nullable = false)
	private LocalDateTime dataRegistro;

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSincronizacao() {
		return sincronizacao;
	}

	public void setSincronizacao(Integer sincronizacao) {
		this.sincronizacao = sincronizacao;
	}

	public Integer getVisitas() {
		return visitas;
	}

	public void setVisitas(Integer visitas) {
		this.visitas = visitas;
	}

	public LocalDateTime getUltimaSincronizacao() {
		return ultimaSincronizacao;
	}

	public void setUltimaSincronizacao(LocalDateTime ultimaSincronizacao) {
		this.ultimaSincronizacao = ultimaSincronizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
