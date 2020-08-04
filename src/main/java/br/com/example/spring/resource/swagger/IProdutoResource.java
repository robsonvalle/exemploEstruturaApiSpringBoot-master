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
import br.com.example.spring.dto.ProdutoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(value = "produtos", description = "Operações relacionadas a Produtos")
public interface IProdutoResource {

	@ApiOperation(value = "Salvar novo produto", nickname = "salvarProduto", notes = "", response = ProdutoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "produtos", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Produto criado com sucesso"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Produto sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Produto não encontrada") })
	@PostMapping(value = "")
	ResponseEntity<ProdutoDTO> salvar(
			@ApiParam(value = "Produto criado com sucesso", required = true) @Valid @RequestBody ProdutoDTO produto);

	@ApiOperation(value = "Atualizar produto", nickname = "atualizarProduto", notes = "", response = ProdutoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "produtos", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Produto atualizado com sucesso"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Produto sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Produto não encontrado") })
	@PutMapping(value = "")
	ResponseEntity<ProdutoDTO> atualizar(
			@ApiParam(value = "Observar os campos obrigatótios do modelo para executar a requisição", required = true) @Valid @RequestBody ProdutoDTO produto);

	@ApiOperation(value = "Consultar produto", nickname = "getProdutos", notes = "", response = ProdutoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "produtos", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Produto encontrado com sucesso", response = ProdutoDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Produto sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Produto não encontrada") })
	@GetMapping(value = "")
	ResponseEntity<ProdutoDTO> consultar(@RequestParam(value = "nome", required = false) String nome);
	
	
	@ApiOperation(value = "Listar produto por nome", nickname = "getProdutos", notes = "", response = ProdutoDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "produtos", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Produto encontrado com sucesso", response = ProdutoDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Produto sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Produto não encontrada") })
	@GetMapping(value = "")
	ResponseEntity<List<ProdutoDTO>> listar();

	
}
