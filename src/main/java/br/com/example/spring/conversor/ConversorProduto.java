package br.com.example.spring.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import br.com.example.spring.dto.ProdutoDTO;
import br.com.example.spring.model.Produto;

@Component
public class ConversorProduto extends ConversorBase<Produto, ProdutoDTO> {

	@Override
	public ProdutoDTO converterEntidadeParaDto(Produto entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Produto, ProdutoDTO>() {
			@Override
			protected void configure() {
				//map().setPermissao(source.getPermissao());
			}
		});
		return modelMapper.map(entidade, ProdutoDTO.class);
	}

	@Override
	public Produto converterDtoParaEntidade(ProdutoDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<ProdutoDTO, Produto>() {
			@Override
			protected void configure() {
				//map().setPermisao(source.getPermissao());
			}
		});
		return modelMapper.map(dto, Produto.class);
	}
}
