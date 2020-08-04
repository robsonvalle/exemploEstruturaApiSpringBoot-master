package br.com.example.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.spring.conversor.ConversorAuditoria;
import br.com.example.spring.dto.AuditoriaDTO;
import br.com.example.spring.model.Auditoria;
import br.com.example.spring.repository.IAuditoriaRepository;
import br.com.example.spring.service.IAuditoriaService;

@Service
public class AuditoriaService implements IAuditoriaService {

	@Autowired
	IAuditoriaRepository auditoriaRepository;
	@Autowired
	ConversorAuditoria conversorAuditoria;

	/*@Override
	public  Auditoria consultar(String codigo) {
		return auditoriaRepository.findByCodigo(codigo);
	}*/
	
//	@Override
//	public Auditoria validar(String codigo) {
//		Auditoria auditoria = consultar(codigo);
//		if (auditoria == null) {
//			throw new NegocioException(MensagemValidacao.ERRO_USUARIO_INVALIDO);
//		}
//
//		return auditoria;
//	}
	
	
	@Override
	public  List<AuditoriaDTO> listar() {
		return conversorAuditoria.converterEntidadesParaDtos(auditoriaRepository.findAll());
	}
	

	@Override
	public List<AuditoriaDTO> criar(List<AuditoriaDTO> auditoriaDTOs) {
		
		List<Auditoria> auditorias = conversorAuditoria.converterDtosParaEntidades(auditoriaDTOs);
		auditoriaRepository.saveAll(auditorias);
		return auditoriaDTOs;
	}

	
}
