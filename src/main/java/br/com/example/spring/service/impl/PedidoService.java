package br.com.example.spring.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.example.spring.constante.MensagemValidacao;
import br.com.example.spring.conversor.ConversorPedido;
import br.com.example.spring.dto.PedidoDTO;
import br.com.example.spring.exception.NegocioException;
import br.com.example.spring.model.Pedido;
import br.com.example.spring.repository.IPedidoRepository;
import br.com.example.spring.service.IPedidoService;
import br.com.example.spring.util.LogUtil;

@Service
public class PedidoService implements IPedidoService {

	@Autowired
	IPedidoRepository pedidoRepository;
	
	@Autowired
	ConversorPedido conversorPedido;

	@Override
	public PedidoDTO consultarPedido(String numpedido) {
		return conversorPedido.converterEntidadeParaDto(consultar(numpedido));
	}


	@Override
	public  Pedido consultar(String numpedido) {
		return pedidoRepository.findByNumpedido(numpedido);
	}

	@Override
	public  List<PedidoDTO> listar() {
		return conversorPedido.converterEntidadesParaDtos(pedidoRepository.findAll(orderByIdAsc()));
	}

	@Override
	public  List<PedidoDTO> listarResultado() {
		
		return conversorPedido.converterEntidadesParaDtos(pedidoRepository.ListaResultado());
	}

	
	private Sort orderByIdAsc() {
	    return new Sort(Sort.Direction.DESC, "id")
	                .and(new Sort(Sort.Direction.DESC, "data"));
	}
	/*
	@Override
	public Pedido validar(String numpedido) {
		Pedido pedido = consultar(numpedido);
		if (pedido == null) {
			throw new NegocioException(MensagemValidacao.ERRO_PRODUTO_INVALIDO);
		}

		return pedido;
	}*/

	@Override
	public PedidoDTO criar(PedidoDTO pedidoDTO) {
		
		String numpedido = gerarNumpedido();
		if (consultar(pedidoDTO.getNumpedido())  == null) {
			pedidoDTO.setNumpedido(numpedido);
			Pedido pedido = conversorPedido.converterDtoParaEntidade(pedidoDTO);
			pedidoRepository.save(pedido);
		} else {
			throw new NegocioException(MensagemValidacao.ERRO_PEDIDO_EXISTENTE);
		}

		return pedidoDTO;
	}

	@Override
	@Transactional
	public PedidoDTO atualizar(PedidoDTO pedidoDTO) {
		Pedido pedido = consultar(pedidoDTO.getNumpedido());
		if (pedido != null) {
			//produto.setStatus(produtoDTO.getStatus());
			pedidoRepository.atualizarValor(pedidoDTO.getValor(), pedidoDTO.getNumpedido());
		} else {
			throw new NegocioException(MensagemValidacao.ERRO_PRODUTO_INVALIDO);
		}

		PedidoDTO pedidoRetorno = conversorPedido.converterEntidadeParaDto(pedido);
		return pedidoRetorno;
	}
	
	
	
	private String gerarNumpedido() {
		Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minuto = calendar.get(Calendar.MINUTE);
        int secundo = calendar.get(Calendar.SECOND);
        int millisenc = calendar.get(Calendar.MILLISECOND);
        int dia = calendar.get(Calendar.DATE);
        int mes = calendar.get(Calendar.MONTH);
        int ano = calendar.get(Calendar.YEAR);
        //int resultado = ano + dia + hora + minuto + secundo + millisenc ;
		Random aleatorio = new Random();
		int  valor = ((aleatorio.nextInt(9999)) * -1 ) ;
		String numpedido ;
		
		numpedido = String.valueOf(ano) + String.valueOf(mes) + String.valueOf(dia) + String.valueOf(hora) + String.valueOf(minuto)+ String.valueOf(secundo) + String.valueOf(millisenc); //+ dia + mes + hora + minuto + secundo + millisenc);
		
       /* if (valor < 0) {
            valor = valor * -1 ;
            numpedido =  String.valueOf(valor) + ano + dia + mes + hora + minuto + secundo + millisenc;    
        }else {
            numpedido =  String.valueOf(valor) + ano + dia + mes + hora + minuto + secundo + millisenc;
        }*/
		
		return numpedido ; 
		/*SecretKey secretKey;
		try {
			SecureRandom random = new SecureRandom();
			KeyGenerator generator = KeyGenerator.getInstance("AES");
			int keyBitSize = 256;
			generator.init(keyBitSize, random);
			secretKey = generator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			LogUtil.error(e);
			throw new NegocioException(MensagemValidacao.ERRO_USUARIO_INVALIDO);
		}

		return Base64.getEncoder().encodeToString(secretKey.getEncoded()); */
	}


}