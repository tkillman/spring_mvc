package spring.controller;

import javax.validation.Valid;

import spring.service.AuthenticationException;
import spring.service.Authenticator;
import spring.service.LoginCommand;
import spring.validator.LoginCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private String formViewName = "login/form";
	
	@Autowired
	private Authenticator authenticator; //MockAuthenticator 객체가 들어온다.

	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		//RequestMappingㅇ르 수행하기 전에 @ModelAttribute와 @initBinder가 실행된다.
		
		return formViewName;
	}

	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand();
	}

	@RequestMapping(method = RequestMethod.POST)
	
	public String submit(@Valid LoginCommand loginCommand, 
						//@Valid -> 유효성 검증을 하겠다. .validate(Object object , Errors error)실행과 유사
			BindingResult result) {
		
		//값을 입력하지 않았을 때
		if (result.hasErrors()) {
			return formViewName;
		}
		
		try {
			
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp";
			
		} catch (AuthenticationException e) {
			
			//글로벌 에러 추가 reject("에러코드","message 번들에 줄 값","디폴트 메세지")
			result.reject("invalidIdOrPassword", new Object[] { loginCommand
					.getUserId() }, null);
			return formViewName;
		}
	}

	//validator를 지정해준다...
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//validator 구현 객체만 받을 수 있다.
		binder.setValidator(new LoginCommandValidator());
		
	}

	
	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}
	

}