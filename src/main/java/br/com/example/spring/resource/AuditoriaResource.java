package br.com.example.spring.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.mail.EmailException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.spring.dto.AuditoriaDTO;
import br.com.example.spring.exception.RestAPIException;
import br.com.example.spring.resource.swagger.IAuditoriaResource;
import br.com.example.spring.service.IAuditoriaService;
import br.com.example.spring.util.LogUtil;
import br.com.example.spring.util.UtilEmail;
import br.com.exemple.spring.vo.EmailVO;
import br.com.exemple.spring.vo.XLSDadosVO;

@RestController
@RequestMapping(value = "/auditoria", produces = "application/json")
public class AuditoriaResource extends BaseResource<AuditoriaDTO> implements IAuditoriaResource {

	@Autowired
	private IAuditoriaService auditoriaService;
	
//	@Autowired
//	private UtilEmail utilEmail;

	@PostMapping(value = "")
	public ResponseEntity<List<AuditoriaDTO>> salvar(@Valid @RequestBody List<AuditoriaDTO> auditorias) {
		try {

			List<AuditoriaDTO> auditoriaRetorno = auditoriaService.criar(auditorias);
			return responderListaDeItens(auditoriaRetorno);
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}

	@GetMapping(value = "/todos")
	public ResponseEntity<List<AuditoriaDTO>> listar() {
		try {
			List<AuditoriaDTO> auditorias = auditoriaService.listar();
			List<XLSDadosVO> itens = new ArrayList<>();
			itens.add(
					new XLSDadosVO(new Object[] { "codigo", "usuario", "nome", "visitas", "sincronizacao","ultimaSincronizacao"}));
		
			auditorias.stream().forEach(v -> {
				XLSDadosVO item = new XLSDadosVO();
				item.addColuna(v.getCodigo());
				item.addColuna(v.getUsuario());
				item.addColuna(v.getNome());
				item.addColuna(v.getVisitas());
				item.addColuna(v.getSincronizacao());
				item.addColuna(v.getUltimaSincronizacao());
				itens.add(item);
			});			
		
			POIforgfgWrite poi = new POIforgfgWrite();
					
			poi.exportarDadosRelatorioXLSDados(itens, "teste.xlsx");
			EmailVO emailVO = new EmailVO();
			emailVO.setAssunto("Auditoria");
			emailVO.setMensagem("Envio Relatorio Auditoria");

			
			UtilEmail utilEmaill = new UtilEmail();
			
			utilEmaill.enviaEmailHtml(emailVO);
			
			return responderListaDeItens(auditorias);
			
		} catch (Exception e) {
			LogUtil.error(e);
			throw new RestAPIException(e.getMessage());
		}
	}


class POIforgfgWrite {

	public void exportarDadosRelatorioXLSDados(List<XLSDadosVO> resultado, String nomeArquivo) throws EmailException {
		try {
			if (resultado != null && resultado.isEmpty()) {
				// UtilFaces.addMensagemFacesError("Sem informações para exibir!");
				return;
			}
			Workbook livroTrabalho = new org.apache.poi.xssf.usermodel.XSSFWorkbook();

			Sheet folha = livroTrabalho.createSheet();

			Font fonteCabecalho = livroTrabalho.createFont();
			//fonteCabecalho.setBold(true);
			fonteCabecalho.setFontHeightInPoints((short) 14);

			CellStyle estiloTopo = livroTrabalho.createCellStyle();
			estiloTopo.setFont(fonteCabecalho);

			int numLinha = 0;
			for (XLSDadosVO xlsDadosVO : resultado) {
				Row linha = folha.createRow(numLinha);

				int numColuna = 0;
				for (XLSDadosVO vo2 : xlsDadosVO.getColunas()) {
					Cell coluna = linha.createCell(numColuna++);
					String valor = vo2.getValor() != null ? vo2.getValor().toString() : "";
					coluna.setCellValue(valor);
					if (numLinha == 0) {
						// Se e a primeira linha, significa que e o topo da planilha
						coluna.setCellStyle(estiloTopo);
					}
				}
				numLinha++;
			}

			FileOutputStream out = new FileOutputStream(new File(nomeArquivo));
			
		
			livroTrabalho.write(out);
			out.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
  }
}
