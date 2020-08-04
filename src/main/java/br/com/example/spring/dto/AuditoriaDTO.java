package br.com.example.spring.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AuditoriaDTO {

	@NotBlank
	private String codigo;
	private Long usuario;
	private String nome;
	private Integer visitas;
	private Integer sincronizacao;
	private LocalDateTime ultimaSincronizacao;
	private LocalDateTime dataRegistro;

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
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Integer getSincronizacao() {
		return sincronizacao;
	}
	public void setSincronizacao(Integer sincronizacao) {
		this.sincronizacao = sincronizacao;
	}
	


}
