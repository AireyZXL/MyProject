/**
 * 
 */
package cn.tedu.comment.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.pojo.User;
import cn.tedu.comment.pojo.UserInfo;
import cn.tedu.comment.service.UserService;
import cn.tedu.comment.tool.WebUtils;

/**
 * @author ZXL
 * @Date 2017年7月14日
 */
@Controller
@RequestMapping("/stage/stageregister")
public class StageRegisterController extends BaseController{
	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String stageMain() {
		// System.out.println(123);
		return "/stage/register";
	}

	@RequestMapping("/save")
	public String toRegister(User user,String password2,Model model){
		
		String msg=null;

		//System.out.println(user);
		//System.out.println(password2);
		if (WebUtils.isNull(user.getUsername())) {
			msg = "用户名不能为空";
			model.addAttribute("msg", msg);
			return "/stage/register";
		}
		if (WebUtils.isNull(user.getUsername())) {
			msg = "密码不能为空";
			model.addAttribute("msg", msg);
			return "/stage/register";
		}
		if (WebUtils.isNull(password2)) {
			msg = "确认密码不能为空";
			model.addAttribute("msg", msg);
			return "/stage/register";
		}
		if (!password2.equals(user.getPassword())) {
			msg = "两次密码不一致";
			model.addAttribute("msg", msg);
			return "/stage/register";
		}
		user.setUserId(UUID.randomUUID().toString());
		userService.addUser(user);
		model.addAttribute("user", user);
		return "/stage/userInfo";
	}
	
	@RequestMapping("/userinforegist")
	public String userinforegist(UserInfo userInfo){
		System.out.println(userInfo);
		userService.userinforegist(userInfo);
		return "redirect:/stage/home";
	}

	@RequestMapping("/ajax")
	public void toAjax(String username, HttpServletResponse response) throws IOException {
		//System.out.println("username:" + username);
		if (userService.hasUser(username)) {
			response.getWriter().write("对不起,用户名已存在");
		} else {
			response.getWriter().write("恭喜！用户名可以使用~~~");
		}

	}

}
