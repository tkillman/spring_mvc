package spring.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		//view 정보 저장
		mav.setViewName("hello");
		
		//model 데이터 저장 (key,value)
		mav.addObject("greeting", getGreeting());
		
		

		return mav;
		
	} //hello() 메소드 종료
	
	private String getGreeting(){
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour>=6 && hour<=10){
			return "좋은 아침입니다";
		}else if(hour >=12 && hour<=15){
			return "점심 식사는 하셨나요?";
		}else if(hour>=18 && hour<=22){
			return "좋은 밤 되세요";
		}
		
		return "안녕하세요";
		
	}
	

}
