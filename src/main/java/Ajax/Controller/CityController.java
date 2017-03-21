package Ajax.Controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CityController {
	
	@Autowired
	private CityService service;
	
	public void setService(CityService service) {
		this.service = service;
	}

	@RequestMapping(value = "/city/city.do")
	public String city() throws Exception {
		
		return "ajax/city";
	}

	@RequestMapping(value = "/city/sidoList.do", method = RequestMethod.POST)
	public void sidoList(HttpServletResponse resp) throws Exception {
		
		List<String> list = service.listSido();
		JSONObject jso = new JSONObject(); // JASON 객체생성
		jso.put("data", list); // jason은 map구조(키,값), data라는 key로 list데이터를 주입했다.

		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter(); //writer 는 2byte 씩, stream은 1byte 씩
		
		// app ---> response 통로방향 
		
		out.print(jso.toString()); // out.print 내용을 ajax의 dataType이 jason에게 데이터 쏴줌
		
		
	}

	//produces="text/plain;charset=UTF-8" 한글 처리가 안될때 써주면 좋다.
	@RequestMapping(value = "/city/cityList.do", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String cityList(HttpServletResponse resp, @RequestParam("snum")String city) throws Exception {
		
		resp.setContentType("text/html; charset=UTF-8");
		List<String> list = service.listCity(city);
		JSONObject jso = new JSONObject();
		jso.put("data1", list);
		return jso.toString();
		
	}
	
}