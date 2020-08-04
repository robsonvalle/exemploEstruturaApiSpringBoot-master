package br.com.exemple.spring.vo;

import java.util.ArrayList;
import java.util.List;

public class XLSDadosVO {
	
	private List<XLSDadosVO> colunas = new ArrayList<>();

	private Object valor;

	public XLSDadosVO() {
	}

	public XLSDadosVO(Object... objetos) {
		this.addColunas(objetos);
	}

	public List<XLSDadosVO> getColunas() {
		return colunas;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	private void addColunas(Object... objetos) {
		for (Object objeto : objetos) {
			XLSDadosVO vo = new XLSDadosVO();
			vo.setValor(objeto);
			colunas.add(vo);
		}
	}

	public void addColuna(Object objeto) {
		XLSDadosVO vo = new XLSDadosVO();
		vo.setValor(objeto);
		colunas.add(vo);
	}


}
