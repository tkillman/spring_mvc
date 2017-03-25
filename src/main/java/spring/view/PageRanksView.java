package spring.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


import spring.controller.PageRank;

public class PageRanksView extends AbstractXlsView {

	
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition",
				"attachment; filename=\"abc.xls\";");

		Sheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet);

		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRanks");
		int rowNum = 1;
		for (PageRank rank : pageRanks) {
			
			createPageRankRow(sheet, rank, rowNum++);
			
		}
		
		// 메소드가 종료되면 자동으로 다운로드가 가능하도록 설정되어 있다.
	}

	
	private Sheet createFirstSheet(Workbook workbook) {
		Sheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "페이지 순위");
		
		sheet.setColumnWidth(1, 256 * 20); // 사이즈 지정
		
		return sheet;
		
	}

	private void createColumnLabel(Sheet sheet) {
		
		Row firstRow = sheet.createRow(0);
		Cell cell = firstRow.createCell(0);
		cell.setCellValue("순위");

		cell = firstRow.createCell(1);
		cell.setCellValue("페이지");
	}

	private void createPageRankRow(Sheet sheet, PageRank rank, int rowNum) {
		
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(0);
		cell.setCellValue(rank.getRank());

		cell = row.createCell(1);
		cell.setCellValue(rank.getPage());

	}

}

