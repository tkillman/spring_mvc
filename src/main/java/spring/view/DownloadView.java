package spring.view;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.net.URLEncoder;
	import java.util.Map;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.springframework.util.FileCopyUtils;
	import org.springframework.web.servlet.view.AbstractView;

	public class DownloadView extends AbstractView {

		public DownloadView() {
			setContentType("application/download; charset=utf-8");
		}

		@Override
		protected void renderMergedOutputModel(Map<String, Object> model,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			File file = (File) model.get("downloadFile");

			response.setContentType(getContentType());
			response.setContentLength((int) file.length());

			//유저 브라우저 정보
			String userAgent = request.getHeader("User-Agent");

			//MSIE는 인터넷 익스플로러를 의미하고
			// 접속한 유저가 익스플로러 이면 0 이상을 리턴하므로 true
			// 익스플로러가 아니라면 -1이므로 -1>-1 false를 리턴한다. 
			
			boolean ie = userAgent.indexOf("MSIE") > -1;
			String fileName = null;
			if (ie) { 
				
				fileName = URLEncoder.encode(file.getName(), "utf-8");
			} else {
				
				fileName = new String(file.getName().getBytes("utf-8"),
						"iso-8859-1");
			
			}
			
			response.setHeader("Content-Disposition" , "attachment; filename=\""+ fileName + "\";");


			response.setHeader("Content-Transfer-Encoding", "binary");
			OutputStream out = response.getOutputStream();

			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				FileCopyUtils.copy(fis, out);
			} finally {
				if (fis != null)
					try {
						fis.close();
					} catch (IOException ex) {
					}
			}
			out.flush();
		}

	}