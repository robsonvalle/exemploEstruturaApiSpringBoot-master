package br.com.example.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.spring.conversor.ConversorResumo;
import br.com.example.spring.dto.ResumoDTO;
import br.com.example.spring.repository.IResumoRepository;
import br.com.example.spring.service.IResumoService;

@Service
public class ResumoService implements IResumoService {

	@Autowired
	IResumoRepository resumoRepository;
	
	@Autowired
	ConversorResumo conversorResumo ;

	
	@Override
	public  List<ResumoDTO> listaResumomes() {
		
		return conversorResumo.converterEntidadesParaDtos(resumoRepository.ListaResumomes());
	}




}
