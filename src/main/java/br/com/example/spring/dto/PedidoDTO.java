package br.com.example.spring.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PedidoDTO {

	/*@NotNull
	private TipoPermissao permissao;*/
	@NotBlank
	private String nomecliente;
	private String numpedido;
	private Double valor;
	private String tipovenda;
	public String getNomecliente() {
		return nomecliente;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	
	public String getNumpedido() {
		return numpedido;
	}
	public void setNumpedido(String numpedido) {
		this.numpedido = numpedido;
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
	public String getTipovenda() {
		return tipovenda;
	}
	public void setTipovenda(String tipovenda) {
		this.tipovenda = tipovenda;
	}
	private Date data;
}
