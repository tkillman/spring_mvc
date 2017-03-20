	package spring.controller;

	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.springframework.beans.propertyeditors.CustomDateEditor;
	import org.springframework.stereotype.Controller;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.WebDataBinder;
	import org.springframework.web.bind.annotation.InitBinder;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;

import spring.service.QueryLogCommand;

	@Controller
	public class QueryLogController {

		@ModelAttribute("command")
		public QueryLogCommand formBacking() {
			return new QueryLogCommand();
		}

		@RequestMapping("/log/query.do")
		public String query(@ModelAttribute("command") QueryLogCommand command,
				BindingResult result) {
			return "log/logList";
		}

		//initBinder의 또다른 역할 
		// 1. setvalidate 할수 있다.
		// 2. 형식 변환이 가능하게 해준다.
		
		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); 
			
			// 바꿔줄 클래스
			// 변환할 때 사용할 에디터 DateFormat(에디터 형식, true 의미)
			//true는 빈 문자열도 허용하겠다. 입력하지 않고 조회를 눌러도 에러가 발생하지 않는다.
		}
	}