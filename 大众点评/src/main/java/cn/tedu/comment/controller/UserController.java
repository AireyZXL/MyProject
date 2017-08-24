/**
 * 
 */
package cn.tedu.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.comment.pojo.User;
import cn.tedu.comment.service.UserService;

/**
 * @author ych
 * @Date   2017年7月11日
 */
@Controller
@RequestMapping("/sysadmin/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/list")
	public String stageMain(Model model){
		List<User> userList = userService.findAll();
		model.addAttribute("userList",userList);
		return "/backend/user/userlist";
	}
	@RequestMapping("/stop")
	public String stop(@RequestParam("userId")String[] userIds){
		userService.updateUserStateByUserId(userIds,0);
		return "redirect:/sysadmin/user/list";
	}
	@RequestMapping("/start")
	public String start(@RequestParam("userId")String[] userIds){
		userService.updateUserStateByUserId(userIds,1);
		return "redirect:/sysadmin/user/list";
	}
}
