package br.com.example.spring.resource.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.example.spring.dto.ErrorDTO;
import br.com.example.spring.dto.ResumoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(value = "resumos", description = "Operações relacionadas a Pedidos")
public interface IResumoResource {

	
	@ApiOperation(value = "Listar rusumo dos pedidos", nickname = "getMes", notes = "", response = ResumoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "resumos", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido encontrado com sucesso", response = ResumoDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Pedido sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Pedido não encontrada") })
	@GetMapping(value = "")
	ResponseEntity<List<ResumoDTO>> listaResumomes();

	
}
