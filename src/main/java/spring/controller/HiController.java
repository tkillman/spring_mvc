package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HiController {

	
	@RequestMapping("/jsp/hello.do")
	public String form(){
		return "hello";
	}
	
}
