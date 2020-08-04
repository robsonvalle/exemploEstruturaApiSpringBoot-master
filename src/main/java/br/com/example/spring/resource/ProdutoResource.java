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

import br.com.example.spring.dto.ProdutoDTO;
import br.com.example.spring.exception.RestAPIException;
import br.com.example.spring.resource.swagger.IProdutoResource;
import br.com.example.spring.service.IProdutoService;
import br.com.example.spring.util.LogUtil;

@RestController
@RequestMapping(value = "/produtos", produces = "application/json")
public class ProdutoResource extends BaseResource<ProdutoDTO> implements IProdutoResource {

	@Autowired
	private IProdutoService produtoService;

	@PostMapping(value = "")
	public ResponseEntity<ProdutoDTO> salvar(@Valid @RequestBody ProdutoDTO produto) {
		try {
			ProdutoDTO produtoRetorno = produtoService.criar(produto);
			return responderItemCriado(produtoRetorno);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}

	@PutMapping(value = "")
	public ResponseEntity<ProdutoDTO> atualizar(@Valid @RequestBody ProdutoDTO produto) {
		try {
			ProdutoDTO produtoRetorno = produtoService.atualizar(produto);
			return responderSucessoComItem(produtoRetorno);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}

	@GetMapping(value = "")
	public ResponseEntity<ProdutoDTO> consultar(String nome) {
		try {
			ProdutoDTO produto = produtoService.consultarProduto(nome);
			return responderSucessoComItem(produto);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}
	
	@GetMapping(value = "/todos")
	public ResponseEntity<List<ProdutoDTO>> listar(){
		try {
			List<ProdutoDTO> produtos = produtoService.listar();
			return responderListaDeItens(produtos);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}
	
}
