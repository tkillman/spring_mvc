package spring.controller;

import java.util.ArrayList;
import java.util.List;

import spring.service.SearchCommand;
import spring.service.SearchResult;
import spring.service.SearchService;
import spring.model.SearchType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameSearchController {
	
	@Autowired
	private SearchService searchService;

	
	//@ModelAttribute의 실행순서를 확인하자!!!!!!!!!!!!!!!!
	
	//RequestMapping에 맞는 메소드가 실행되기 전에 컨트롤러에 있는
	//@ModelAttribute가 먼저 발생한다.
	//
	
	@ModelAttribute("searchTypeList")
	public List<SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "아이템"));
		options.add(new SearchType(3, "캐릭터"));
		return options;
	}

	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList() {
		return new String[] { "게임", "창천2", "위메이드" };
	}

	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}

	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
		//ModelAndView생성자 첫번째 매개변수는 view name
		ModelAndView mav = new ModelAndView("search/game");
		System.out.println("검색어 = " + command.getQuery().toUpperCase());
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);
		return mav;
	}

	//이 컨트롤러의 예외만 처리가능하다.
	//
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex) {
		return "error/nullException";
	}
	
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

}

