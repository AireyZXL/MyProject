package com.kubuy.manage.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kubuy.dubbo.pojo.Admin;
@Controller
public class HomeController {
	@RequestMapping("/index")
	public String toIndex(){
		return "index";
	}
	//转向登陆页面
	@RequestMapping("/tologin")
	public String toLogin(){

		return "login";
	}
	@RequestMapping("/login")
	public String login(String userName,String password,Model model,HttpSession session){
		//1.判断用户名和密码是否为空
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			//证明用户名或密码为空
			model.addAttribute("errorInfo", "用户名或密码不能为空");
			
			return "/tologin";
		}
		
		//用户名和密码不为空
		
		//Shiro的登陆操作   获取用户对象
		Subject subject = SecurityUtils.getSubject();
		
		//将用户的数据封装为令牌(票)
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		
		try {
			//通过用户实现登陆 
			subject.login(token); 
			
			//获取真实的用户对象
			Admin admin = (Admin) subject.getPrincipal();
			
			//证明用户名和密码正确
			return "redirect:/index.action";
			
		} catch (AuthenticationException e) {
			e.printStackTrace();  //打印异常信息
			//证明用户名和密码错误
			model.addAttribute("errorInfo", "用户名和密码不正确");
			return "/tologin";
		}
	}
	@RequestMapping("/{firstMenu}/{secondMenu}/list")
	public String toModule(@PathVariable String firstMenu,@PathVariable String secondMenu){
		return firstMenu+"/"+secondMenu+"/"+secondMenu+"-list";
	}
}
