package spring.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.util.MultiValueMap;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;

	@Controller
	public class SimpleConverterController {

		
		@RequestMapping(value = "/test/simpleTest.do", method = RequestMethod.GET)
		public String simpleTestForm() {
			return "test/simpleTestForm";
		}

		
		@RequestMapping(value = "/test/simpleTest.do", method = RequestMethod.POST)
		@ResponseBody
		public String simpleTest(@RequestBody String body) {
			//body 내용을 String 타입 혹은 byte[] 로 받을 수 있다.
			

			//@ResponseBody로 정보를 넘겨주면 crome이 알아서 뷰 페이지를 만들어서 보여준다.
			return body;
			
		}

		@RequestMapping(value = "/test/simpleTest1.do", method = RequestMethod.GET)
		public String simpleTestForm1() {
			

			//@ResponseBody로 정보를 넘겨주면 crome이 알아서 뷰 페이지를 만들어서 보여준다.
			return "test/simpleTestForm";
		}

		@RequestMapping(value = "/test/simpleTest1.do", method = RequestMethod.POST)
		@ResponseBody
		public byte[] simpleTest1(@RequestBody byte[] body) {
			
			return body;
		}

		@RequestMapping(value = "/test/simpleTest2.do", method = RequestMethod.GET)
		public String simpleTestForm2() {
			
			
			return "test/simpleTestForm";
			
			
		}

		
		@RequestMapping(value = "/test/simpleTest2.do", method = RequestMethod.POST)
		@ResponseBody
		public String simpleTest2(@RequestBody MultiValueMap<String, String> body) {
			
			//@ResponseBody로 정보를 넘겨주면 crome이 알아서 뷰 페이지를 만들어서 보여준다.
			return body.toString();
			
		}
		
		
	}