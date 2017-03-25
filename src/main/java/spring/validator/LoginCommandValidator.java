package spring.validator;

import spring.service.LoginCommand;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		
		return LoginCommand.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		
		//rejectIfEmptyOrWhitespace 빈문자열을 검사해주는 유틸 클래스 메소드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		//required.loginCommand.userId
		//에러코드.객체타입.필드명
		//에러코드.필드명
		//에러코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required");
		//required.password
	}

	
}