/**
 * 
 */
package cn.tedu.comment.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wsc
 * @date   2017年7月12日 
 */
@Controller
public class LogoutController extends BaseController{
	@RequestMapping("/logout")
	public String Logout (){
	 Subject subject = SecurityUtils.getSubject();
	 subject.logout();
		return "redirect:/tologin.action";
	}
}
