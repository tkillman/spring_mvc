	package spring.controller;

	import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.multipart.MultipartFile;
	import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.model.fileInfo;
import spring.model.fileInfo2;
import spring.service.fileDao;

	@Controller
	public class ReportSubmissionController {
	
  	@Autowired
  	fileDao dao;
		
		
	public void setDao(fileDao dao) {
		this.dao = dao;
	}

	
	@RequestMapping(value = "/report/submission.do", method = RequestMethod.GET)
	public String form() {
			return "report/submissionForm";
		}

	@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber,
				@RequestParam("report") MultipartFile report) {
			
		
			printInfo(studentNumber, report);
			
			
			String fileName = report.getOriginalFilename();
			//System.out.println(fileName);
			
			String o_name= report.getOriginalFilename();
			long now = System.currentTimeMillis();
			Random r = new Random();
			int i=r.nextInt(50);
			o_name = now +"_"+i;
			
			File file = new File("f:\\item\\"+o_name);
		
			
			//3번 방식
			try {
				
				report.transferTo(file);
			
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
		
		   //2. 디비에 경로 넣기	
			/*fileInfo fileinfo = new fileInfo();
			
			fileinfo.setOriginalFilename(o_name);
		
			fileinfo.setFileSize(report.getSize());
			
			fileinfo.setFilePath(file.getAbsolutePath());
			
			dao.insertFileInfo(fileinfo);*/
				
			//3. 디비에 바이트 배열 넣기
			fileInfo2 fileinfo2 = new fileInfo2();
			fileinfo2.setFileSize(report.getSize());
			fileinfo2.setOriginalFilename(o_name);
			try {
				fileinfo2.setFileSource(report.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dao.insertFileInfo2(fileinfo2);
			
			
			String str;
			try {
				str = new String(report.getBytes());
				//System.out.println(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "report/submissionComplete";
		}

	private void printInfo(String studentNumber, MultipartFile report) {
			System.out.println(studentNumber + "가 업로드 한 파일: "
					+ report.getOriginalFilename());
		}

	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
			String studentNumber = request.getParameter("studentNumber");
			MultipartFile report = request.getFile("report");
			printInfo(studentNumber, report);
			return "report/submissionComplete";
		}

	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
			printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
			return "report/submissionComplete";
		}
		
	}