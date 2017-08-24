package cn.tedu.comment.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.comment.pojo.Admin;
import cn.tedu.comment.service.AdminService;
import cn.tedu.comment.tool.WebUtils;
/**
 * 后台登录
 * @author wsc
 *
 */
@Controller
public class LoginController extends BaseController{
	@Autowired
	private AdminService adminService;
	
	/* 进入登录页面  */
	@RequestMapping("/tologin")
	public String toLogin(){
		return "/backend/login/Login";
	}
	
	/* 登录页面的逻辑控制 */
	@RequestMapping("/login")
	public String login(String userName,String password,Model model,HttpSession session){
	
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			//证明用户名或密码为空
			model.addAttribute("errorInfo", "用户名或密码不能为空");
			
			return "/backend/login/Login";
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
			//获取用户状态
			int state = admin.getState();
			
			//将用户对象存入session中
			subject.getSession().setAttribute("sessionadmin", admin);
			//证明用户名和密码正确
			
			//判断用户的状态
			if(state==0){
				//用户未激活,前往激活页面
				return "/backend/login/adminActivate";
			}else if(state == 1){
				
				return "redirect:/home.action";
				
			}else{
				//证明用户已被停用或其他
				session.invalidate();
				
				model.addAttribute("errorInfo", "用户已被停用或其他");
				
				return "/backend/login/Login";
			}
			
		} catch (AuthenticationException e) {
			e.printStackTrace();  //打印异常信息
			//证明用户名和密码错误
			
			model.addAttribute("errorInfo", "用户名和密码不正确");
			
			return "/backend/login/Login";
		}
	}
	
	/*激活页面控制*/
	@RequestMapping("/active")
	public String Active(MultipartFile photo,HttpServletRequest request,Admin admin,String password2,Model model) throws IOException{
		request.getSession().setAttribute("sessionadmin", admin);
		if(password2.isEmpty()||(!password2.equals(admin.getPassword()))){
			model.addAttribute("errorInfo", "确认密码不能为空!");
			return  "/backend/login/adminActivate";
		}
					
		/**
		 * 图片上传代码
		 */
		
		if(!WebUtils.isNull(photo.getOriginalFilename())){
			//-----------------------------------------
			ServletContext context=request.getSession().getServletContext();
			String url=context.getRealPath("/WEB-INF/upload/advertisement");
			String photoName=photo.getOriginalFilename();
			//文件后缀
			String suffix=photoName.substring(photoName.lastIndexOf("."));
			
			String filename=url+"/"+admin.getAdminId()+suffix;
			
			admin.getInfo().setImgurl(("/WEB-INF/upload/advertisement"+"/"+admin.getAdminId()+suffix));
			//-------------------------------
			FileUtils.writeByteArrayToFile(new File(filename), photo.getBytes());
			
		}
					
		//修改用户状态为启用
		admin.setState(1);
		System.out.println(admin);
		adminService.actionAdmin(admin);
	
		request.getSession().setAttribute("sessionadmin", admin);
		
		return "redirect:/home.action";
	}
}
