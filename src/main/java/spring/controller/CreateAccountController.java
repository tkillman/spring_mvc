	package spring.controller;

import javax.servlet.http.HttpServletRequest;

import spring.model.Address; 
import spring.model.MemberInfo;
import spring.validator.MemberInfoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {

	@ModelAttribute("command")
	public MemberInfo formBacking(HttpServletRequest request) {
		
		//대소문자 무시
		if (request.getMethod().equalsIgnoreCase("GET")) {
			
			MemberInfo mi = new MemberInfo();
			
			
			//우편번호 형식을 보여주기 위해서
			Address address = new Address();
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));
			mi.setAddress(address);
			return mi;
			
		} else {
			
			return new MemberInfo();
			
		}
	}

	private String autoDetectZipcode(String remoteAddr) {
		
		return "000-000";
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "account/creationForm";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") MemberInfo memberInfo,
			BindingResult result) { //유효성 검사를 위해서 BindingResult를 받아온다.
		
		new MemberInfoValidator().validate(memberInfo, result);
		
		if (result.hasErrors()) { //reject() , rejectValue() 메소드가 한번이라도 실행되면 true 리턴
			
			return "account/creationForm";
			
		}
		
		return "account/created";
		
	}
	
}
