package spring.controller;

	import java.io.File;

	import org.springframework.beans.BeansException;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.ApplicationContextAware;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.context.WebApplicationContext;
	import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class DownloadController implements ApplicationContextAware {

		private WebApplicationContext context = null;

		@RequestMapping("/file")
		public ModelAndView download() throws Exception {
			
			//파일 객체를 받는다.
			File downloadFile = getFile();
			
			//1. 돌아갈 viewName, 2.쓸 모델 Name 3.객체
			
			return new ModelAndView("download", "downloadFile", downloadFile);
			
			
			
		}

		
		private File getFile() {
			String path = context.getServletContext().getRealPath(
					"/WEB-INF/설명.txt");
			//web-inf에 있는 설명.txt 파일의 실제 경로를 반환해서 file 객체를 생성
			
			return new File(path);
		}

		
		@Override
		public void setApplicationContext(ApplicationContext applicationContext)
				throws BeansException {
			//현제 application의 객체를 반환한다.
			this.context = (WebApplicationContext) applicationContext;
		}

	}