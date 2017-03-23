	package spring.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import spring.controller.PageRank;

public class PageReportView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRanks");
		
		Table table = new Table(2, pageRanks.size() + 1); // 칸수,줄수
		table.setPadding(5); //패딩 설정

		BaseFont bfKorean = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED); //한글 폰트 설정
		

		Font font = new Font(bfKorean);
		
		
		Cell cell = new Cell(new Paragraph("순위", font)); //Paragraph 단락 , 절
		cell.setHeader(true);
		table.addCell(cell);
		cell = new Cell(new Paragraph("페이지", font));
		table.addCell(cell);
		table.endHeaders();

		for (PageRank rank : pageRanks) {
			
			table.addCell(Integer.toString(rank.getRank()));
			table.addCell(rank.getPage());
			//table.addCell(new Paragraph("크릉라", font));
			
			
			
		}
		
		document.add(table);
	}

}
