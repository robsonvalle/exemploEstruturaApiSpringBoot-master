package br.com.example.spring.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import br.com.exemple.spring.vo.XLSDadosVO;


public class POIforgfgWrite {

	public void exportarDadosRelatorioXLSDados(List<XLSDadosVO> resultado, String nomeArquivo) {
		try {
			if (resultado != null && resultado.isEmpty()) {
				UtilFaces.addMensagemFacesError("Sem informações para exibir!");
				return;
			}
			Workbook livroTrabalho = new XSSFWorkbook();

			Sheet folha = livroTrabalho.createSheet();

			Font fonteCabecalho = livroTrabalho.createFont();
			fonteCabecalho.setBold(true);
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

			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			response.addHeader("Content-Disposition", "attachement; filename=\"" + nomeArquivo + "\"");
			ServletOutputStream sos = response.getOutputStream();
			context.responseComplete();
			livroTrabalho.write(sos);
			sos.flush();
			sos.close();
			livroTrabalho.close();
		} catch (IOException e) {
			UtilFaces.addMensagemFacesError(e.getMessage());
			UtilLog.getLog().error(e.getMessage(), e);
		}
	}
}
