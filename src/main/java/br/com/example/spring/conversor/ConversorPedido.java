package br.com.example.spring.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import br.com.example.spring.dto.PedidoDTO;
import br.com.example.spring.model.Pedido;

@Component
public class ConversorPedido extends ConversorBase<Pedido, PedidoDTO> {

	@Override
	public PedidoDTO converterEntidadeParaDto(Pedido entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Pedido, PedidoDTO>() {
			@Override
			protected void configure() {
				//map().setPermissao(source.getPermissao());
			}
		});
		return modelMapper.map(entidade, PedidoDTO.class);
	}

	@Override
	public Pedido converterDtoParaEntidade(PedidoDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<PedidoDTO, Pedido>() {
			@Override
			protected void configure() {
				//map().setPermisao(source.getPermissao());
			}
		});
		return modelMapper.map(dto, Pedido.class);
	}
}
