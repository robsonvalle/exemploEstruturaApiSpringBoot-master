package br.com.example.spring.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import br.com.example.spring.dto.ResumoDTO;
import br.com.example.spring.model.Resumo;

@Component
public class ConversorResumo extends ConversorBase<Resumo, ResumoDTO> {

	@Override
	public ResumoDTO converterEntidadeParaDto(Resumo entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Resumo, ResumoDTO>() {
			@Override
			protected void configure() {
				//map().setPermissao(source.getPermissao());
			}
		});
		return modelMapper.map(entidade, ResumoDTO.class);
	}

	@Override
	public Resumo converterDtoParaEntidade(ResumoDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<ResumoDTO, Resumo>() {
			@Override
			protected void configure() {
				//map().setPermisao(source.getPermissao());
			}
		});
		return modelMapper.map(dto, Resumo.class);
	}
}
