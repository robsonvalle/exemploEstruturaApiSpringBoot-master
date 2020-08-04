package br.com.example.spring.service;

import java.util.List;

import br.com.example.spring.dto.ParametroDTO;
import br.com.example.spring.model.Parametro;

public interface IParametroService {

	ParametroDTO consultarParametro(String chave);
	
	Parametro consultar(String chave);
	
	List<ParametroDTO> listar() ;
	
	Parametro validar(String parametro) ;

	ParametroDTO criar(ParametroDTO pedidoDTO);



}
