package br.com.example.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.spring.constante.MensagemValidacao;
import br.com.example.spring.conversor.ConversorParametro;
import br.com.example.spring.dto.ParametroDTO;
import br.com.example.spring.exception.NegocioException;
import br.com.example.spring.model.Parametro;
import br.com.example.spring.repository.IParametroRepository;
import br.com.example.spring.service.IParametroService;

@Service
public class ParametroService implements IParametroService {
	@Autowired
	IParametroRepository parametroRepository;
	
	@Autowired
	ConversorParametro conversorParametro;

	@Override
	public ParametroDTO consultarParametro(String chave) {
		return conversorParametro.converterEntidadeParaDto(consultar(chave));
	}


	@Override
	public  Parametro consultar(String chave) {
		return parametroRepository.findByChaveIgnoreCaseContaining(chave);
	}
	
	@Override
	public  List<ParametroDTO> listar() {
		return conversorParametro.converterEntidadesParaDtos(parametroRepository.findAll());
	}
	
	
	@Override
	public Parametro validar(String chave) {
		Parametro parametro = consultar(chave);
		if (parametro == null) {
			throw new NegocioException(MensagemValidacao.ERRO_PRODUTO_INVALIDO);
		}

		return parametro;
	}

	@Override
	public ParametroDTO criar(ParametroDTO parametroDTO) {
		if (consultar(parametroDTO.getChave()) == null) {
			Parametro parametro = conversorParametro.converterDtoParaEntidade(parametroDTO);
			parametroRepository.save(parametro);
		} else {
			throw new NegocioException(MensagemValidacao.ERRO_PRODUTO_EXISTENTE);
		}

		return parametroDTO;
	}



}
