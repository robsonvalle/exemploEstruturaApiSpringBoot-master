package br.com.example.spring.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import br.com.example.spring.dto.AuditoriaDTO;
import br.com.example.spring.model.Auditoria;

@Component
public class ConversorAuditoria extends ConversorBase<Auditoria, AuditoriaDTO> {

	@Override
	public AuditoriaDTO converterEntidadeParaDto(Auditoria entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Auditoria, AuditoriaDTO>() {
			@Override
			protected void configure() {
				//map().setPermissao(source.getPermissao());
			}
		});
		return modelMapper.map(entidade, AuditoriaDTO.class);
	}

	@Override
	public Auditoria converterDtoParaEntidade(AuditoriaDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<AuditoriaDTO, Auditoria>() {
			@Override
			protected void configure() {
				//map().setPermisao(source.getPermissao());
			}
		});
		return modelMapper.map(dto, Auditoria.class);
	}

}
