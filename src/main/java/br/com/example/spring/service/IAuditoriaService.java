package br.com.example.spring.service;

import java.util.List;

import br.com.example.spring.dto.AuditoriaDTO;

public interface IAuditoriaService {

	//AuditoriaDTO consultarAuditoria(String codigo);
	
	//Auditoria consultar(String codigo);	
	
	List<AuditoriaDTO> listar() ;
	
	//Auditoria validar(String nomecliente) ;

	List<AuditoriaDTO> criar(List<AuditoriaDTO> auditoriaDTO);
	
	//AuditoriaDTO atualizar(AuditoriaDTO auditoriaDTO);


}
