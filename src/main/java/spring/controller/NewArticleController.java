package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.ArticleService;
import spring.service.NewArticleCommand;

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	@Autowired
	private ArticleService articleService;

	// @RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
	@RequestMapping(method = RequestMethod.GET)
	//get 방식이 없을 때는 405 에러 발생
	public String form() {
		
		return "article/newArticleForm";
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command) {
		//RequestMapping 안에 @ModelAttribute 를 설정했을 때
				//dispatcher가 자동적으로 command 객체를 만들어주고
				// 자동적으로 parameter의 값과 command 객체의 변수명과 같은 것을 매칭시켜서 값을 저장해준다.
				
				//만약 어노테이션을 붙여주지 않으면 클래스 이름의 첫 글자를 소문자로 만들어서 객체를 만들어서 model에 담아 같은 일을 해주는데
				//이름이 너무 기니까 (화면창에서 ${dto.n1 이렇게 불러줘야함. 지금 예제는 클래스 이름이 짧네})@ModelAttribute 어노테이션에서 이름을 지정해주도록 하자.
		articleService.writeArticle(command);
		return "article/newArticleSubmit";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}