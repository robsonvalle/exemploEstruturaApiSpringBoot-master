package br.com.example.spring.service;

import java.util.List;

import br.com.example.spring.dto.ProdutoDTO;
import br.com.example.spring.model.Produto;

public interface IProdutoService {

	ProdutoDTO consultarProduto(String nome);
	
	Produto consultar(String nome);
	
	List<ProdutoDTO> listar() ;
	
	Produto validar(String nome) ;

	ProdutoDTO criar(ProdutoDTO produtoDTO);
	
	ProdutoDTO atualizar(ProdutoDTO produtoDTO);


}
