/**
 * 
 */
package cn.tedu.comment.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.pojo.User;
import cn.tedu.comment.service.UserService;
import cn.tedu.comment.tool.VerifyCode;

/**
 * @author wsc
 * @date   2017年7月14日 
 */
@Controller
public class StageLoginController {
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/stage/toLogin")
	public String userLogin (){
		return "stage/login/login";		
	}
	
	@RequestMapping("/stage/stageValiImage")
	public void stageValiImage (HttpServletRequest request,HttpServletResponse response) throws IOException{
		//控制浏览器不要缓存验证码图片
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		
		//画一张验证码图片, 响应给浏览器
		VerifyCode vc = new VerifyCode();
		vc.drawImage(response.getOutputStream());
		
		//获取验证码图片上的验证码文本
		String code = vc.getCode();
		
		System.out.println("进"+code);
		//将验证码文本保存在session中
		request.getSession().setAttribute("code", code);
		
		
	}
	
	@RequestMapping("/stage/Login")
	public String StageLogin (HttpServletRequest request,String username,String password,String valistr,Model model){
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			//证明用户名或密码为空
			model.addAttribute("errorInfo", "用户名或密码不能为空");
			
			return "/stage/login/login";
		}
		
		//获取储存在session中验证码
		String code = (String) request.getSession().getAttribute("code");
		
		System.out.println("出"+code);
		
		if(valistr.isEmpty()||(!valistr.equalsIgnoreCase(code))){
			
			model.addAttribute("errorInfo", "请输入正确的验证码");
			
			return "/stage/login/login";
		}
		
		User user = userservice.findUserByUserName(username);
		
		if(user.getState()==0){
			//证明用户名或密码为空
			model.addAttribute("errorInfo", "该用户已被停用!");
			
			return "/stage/login/login";
		}
		
		request.getSession().setAttribute("user", user);
		
		return "redirect:/stage/home.action";
	}
	@RequestMapping("/stage/logout")
	public String StageLogout (HttpServletRequest request){
		request.getSession().removeAttribute("user");
		 return "redirect:/stage/home.action";
	}

}
