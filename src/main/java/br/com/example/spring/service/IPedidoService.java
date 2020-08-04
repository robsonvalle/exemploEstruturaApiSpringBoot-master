package br.com.example.spring.service;

import java.util.List;

import br.com.example.spring.dto.PedidoDTO;
import br.com.example.spring.model.Pedido;

public interface IPedidoService {

	PedidoDTO consultarPedido(String numpedido);
	
	Pedido consultar(String numpedido);
	
	List<PedidoDTO> listarResultado();
	List<PedidoDTO> listar() ;
	//List<PedidoDTO> listarLancamento();
	
	//Pedido validar(String numpedido) ;

	PedidoDTO criar(PedidoDTO pedidoDTO);

		
	PedidoDTO atualizar(PedidoDTO pedidoDTO);



}
