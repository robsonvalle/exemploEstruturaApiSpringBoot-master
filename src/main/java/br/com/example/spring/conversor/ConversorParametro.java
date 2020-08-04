package br.com.example.spring.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import br.com.example.spring.dto.ParametroDTO;
import br.com.example.spring.model.Parametro;

@Component
public class ConversorParametro extends ConversorBase<Parametro, ParametroDTO> {

	@Override
	public ParametroDTO converterEntidadeParaDto(Parametro entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Parametro, ParametroDTO>() {
			@Override
			protected void configure() {
				//map().setPermissao(source.getPermissao());
			}
		});
		return modelMapper.map(entidade, ParametroDTO.class);
	}

	@Override
	public Parametro converterDtoParaEntidade(ParametroDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<ParametroDTO, Parametro>() {
			@Override
			protected void configure() {
				//map().setPermisao(source.getPermissao());
			}
		});
		return modelMapper.map(dto, Parametro.class);
	}
}
