package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/game/users")
public class testController {

	@RequestMapping("/character")
	public String test(){
		
		
		return "game/users/info";
	}
	
	
	
}
