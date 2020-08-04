package br.com.example.spring.resource.swagger;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.example.spring.dto.AuditoriaDTO;
import br.com.example.spring.dto.ErrorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(value = "auditoria", description = "Operações relacionadas a Auditorias")
public interface IAuditoriaResource {

	@ApiOperation(value = "Salvar novo auditoria", nickname = "salvarAuditoria", notes = "", response = AuditoriaDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "auditoria", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Auditoria criado com sucesso"),
			@ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "Auditoria sem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Auditoria não encontrada") })
	@PostMapping(value = "")
	ResponseEntity<List<AuditoriaDTO>> salvar(
			@ApiParam(value = "Auditoria criado com sucesso", required = true) @Valid @RequestBody List<AuditoriaDTO> auditorias);

}
