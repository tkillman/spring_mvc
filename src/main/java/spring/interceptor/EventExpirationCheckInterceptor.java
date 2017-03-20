package spring.interceptor;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




//인터셉터 클래스는 HandlerInterceptorAdapter를 상속받아서 만든다.
public class EventExpirationCheckInterceptor extends HandlerInterceptorAdapter {
	
	// Adapter란 litener 를 구현한 클래스로 빈 메소드를 가지고 있다.
	//

	//preHandle 요청이 있기 전에 실행
	//postHandle 요청 후 실행 , 에러 발생 시 실행되지 않음.
	//afterHandle 요청 후 실행, 에러 발생 시에도 실행됨.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { // 혹시 또 실행할 handler가 있는가
		if (checkEvent(request) && checkEventExpiration()) {
			//요청이 맞는지, 날짜가 넘어가지 않았는지.
			
			displayEventExpirationPage(request, response);
			return false;
		}
		return true;
	}

	private boolean checkEvent(HttpServletRequest request) {
		return request.getRequestURI().equals(request.getContextPath() + "/event/list.do");
	}

	private boolean checkEventExpiration() {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(2016, 9, 9); //2017년, 10월 , 10일
		Date now = new Date();
		return now.after(calendar.getTime());
	}

	private void displayEventExpirationPage(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.sendRedirect("eventExpired.do");
	}

}
