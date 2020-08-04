package br.com.example.spring.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.spring.dto.PedidoDTO;
import br.com.example.spring.exception.RestAPIException;
import br.com.example.spring.resource.swagger.IPedidoResource;
import br.com.example.spring.service.IPedidoService;
import br.com.example.spring.util.LogUtil;

@RestController
@RequestMapping(value = "/pedidos", produces = "application/json")
public class PedidoResource extends BaseResource<PedidoDTO> implements IPedidoResource {

	@Autowired
	private IPedidoService pedidoService;

	@PostMapping(value = "")
	public ResponseEntity<PedidoDTO> salvar(@Valid @RequestBody PedidoDTO pedido) {
		try {
			PedidoDTO pedidoRetorno = pedidoService.criar(pedido);
			return responderItemCriado(pedidoRetorno);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}

	@PutMapping(value = "")
	public ResponseEntity<PedidoDTO> atualizar(@Valid @RequestBody PedidoDTO pedido) {
		try {
			PedidoDTO pedidoRetorno = pedidoService.atualizar(pedido);
			return responderSucessoComItem(pedidoRetorno);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}

	@GetMapping(value = "")
	public ResponseEntity<PedidoDTO> consultar(String numpedido) {
		try {
			PedidoDTO pedido = pedidoService.consultarPedido(numpedido);
			return responderSucessoComItem(pedido);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}
	
	@GetMapping(value = "/todos")
	public ResponseEntity<List<PedidoDTO>> listar(){
		try {
			List<PedidoDTO> pedidos = pedidoService.listar();
			return responderListaDeItens(pedidos);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}

	@GetMapping(value = "/resumo")
	public ResponseEntity<List<PedidoDTO>> listarResultado(){
		try {
			List<PedidoDTO> pedidos = pedidoService.listarResultado();
			return responderListaDeItens(pedidos);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}
	
	/*@GetMapping(value = "/resumomes")
	public ResponseEntity<List<ResumoDTO>> listaResumomes(){
		try {
			List<ResumoDTO> pedidos = pedidoService.listaResumomes();
			return responderListaDeItens(pedidos);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}*/
}
