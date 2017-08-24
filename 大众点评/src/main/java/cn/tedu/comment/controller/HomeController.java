package cn.tedu.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 后台页面跳转
 * @author lyh
 * @Date   2017年7月11日
 */
@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(){
		return "/backend/fmain";
	}
	@RequestMapping("/title")
	public String title(){
		return "/backend/title";
	}
	@RequestMapping("/left")
	public String left(){
		return "/backend/left";
	}
	@RequestMapping("/main")
	public String main(){
		return "backend/main";
	}
}
