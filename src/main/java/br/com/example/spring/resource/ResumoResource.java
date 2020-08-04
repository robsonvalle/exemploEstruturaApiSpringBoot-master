package br.com.example.spring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.spring.dto.ResumoDTO;
import br.com.example.spring.exception.RestAPIException;
import br.com.example.spring.resource.swagger.IResumoResource;
import br.com.example.spring.service.IResumoService;
import br.com.example.spring.util.LogUtil;

@RestController
@RequestMapping(value = "/resumos", produces = "application/json")
public class ResumoResource extends BaseResource<ResumoDTO> implements IResumoResource {

	@Autowired
	private IResumoService resumoService;
	
	@GetMapping(value = "/mes")
	public ResponseEntity<List<ResumoDTO>> listaResumomes(){
		try {
			List<ResumoDTO> pedidos = resumoService.listaResumomes();
			return responderListaDeItens(pedidos);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}
}
