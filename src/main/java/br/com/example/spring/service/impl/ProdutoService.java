package br.com.example.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.example.spring.constante.MensagemValidacao;
import br.com.example.spring.conversor.ConversorProduto;
import br.com.example.spring.dto.ProdutoDTO;
import br.com.example.spring.exception.NegocioException;
import br.com.example.spring.model.Produto;
import br.com.example.spring.repository.IProdutoRepository;
import br.com.example.spring.service.IProdutoService;

@Service
public class ProdutoService implements IProdutoService {

	@Autowired
	IProdutoRepository produtoRepository;
	
	@Autowired
	ConversorProduto conversorProduto;

	@Override
	public ProdutoDTO consultarProduto(String nome) {
		return conversorProduto.converterEntidadeParaDto(consultar(nome));
	}


	@Override
	public  Produto consultar(String nome) {
		return produtoRepository.findByNomeIgnoreCaseContaining(nome);
	}
	
	@Override
	public  List<ProdutoDTO> listar() {
		return conversorProduto.converterEntidadesParaDtos(produtoRepository.findAll());
	}
	
	
	@Override
	public Produto validar(String nome) {
		Produto produto = consultar(nome);
		if (produto == null) {
			throw new NegocioException(MensagemValidacao.ERRO_PRODUTO_INVALIDO);
		}

		return produto;
	}

	@Override
	public ProdutoDTO criar(ProdutoDTO produtoDTO) {
		if (consultar(produtoDTO.getNome()) == null) {
			Produto produto = conversorProduto.converterDtoParaEntidade(produtoDTO);
			produtoRepository.save(produto);
		} else {
			throw new NegocioException(MensagemValidacao.ERRO_PRODUTO_EXISTENTE);
		}

		return produtoDTO;
	}

	@Override
	@Transactional
	public ProdutoDTO atualizar(ProdutoDTO produtoDTO) {
		Produto produto = consultar(produtoDTO.getNome());
		String nome;
		if (produto != null) {
//			produto.setValor(produtoDTO.getValor());
			//produto.setStatus(produtoDTO.getStatus());
			//produtoRepository.atualizarValor(produtoDTO.getValor(), produtoDTO.getNome());
		} else {
			throw new NegocioException(MensagemValidacao.ERRO_PRODUTO_INVALIDO);
		}

		ProdutoDTO produtoRetorno = conversorProduto.converterEntidadeParaDto(produto);
		return produtoRetorno;
	}


}
