package br.com.example.spring.resource.swagger;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.example.spring.dto.ErrorDTO;
import br.com.example.spring.dto.PedidoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(value = "pedidos", description = "Operações relacionadas a Pedidos")
public interface IPedidoResource {

	@ApiOperation(value = "Salvar novo pedido", nickname = "salvarPedido", notes = "", response = PedidoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "pedidos", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Pedido criado com sucesso"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Pedido sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Pedido não encontrada") })
	@PostMapping(value = "")
	ResponseEntity<PedidoDTO> salvar(
			@ApiParam(value = "Pedido criado com sucesso", required = true) @Valid @RequestBody PedidoDTO pedido);

	@ApiOperation(value = "Atualizar pedido", nickname = "atualizarPedido", notes = "", response = PedidoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "pedidos", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Pedido atualizado com sucesso"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Pedido sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Pedido não encontrado") })
	@PutMapping(value = "")
	ResponseEntity<PedidoDTO> atualizar(
			@ApiParam(value = "Observar os campos obrigatótios do modelo para executar a requisição", required = true) @Valid @RequestBody PedidoDTO pedido);

	@ApiOperation(value = "Consultar pedido", nickname = "getPedidos", notes = "", response = PedidoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "pedidos", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido encontrado com sucesso", response = PedidoDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Pedido sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Pedido não encontrada") })
	@GetMapping(value = "")
	ResponseEntity<PedidoDTO> consultar(@RequestParam(value = "valor", required = false) String valor);
	
	
	@ApiOperation(value = "Listar pedido por nome", nickname = "getPedidos", notes = "", response = PedidoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "pedidos", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido encontrado com sucesso", response = PedidoDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Pedido sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Pedido não encontrada") })
	@GetMapping(value = "")
	ResponseEntity<List<PedidoDTO>> listar();
	
	@ApiOperation(value = "Listar rusumo dos pedidos", nickname = "getPedidos", notes = "", response = PedidoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "pedidos", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido encontrado com sucesso", response = PedidoDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Pedido sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Pedido não encontrada") })
	@GetMapping(value = "")
	ResponseEntity<List<PedidoDTO>> listarResultado();

	
}