package cn.tedu.comment.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tedu.comment.pojo.Admin;
import cn.tedu.comment.pojo.Role;
import cn.tedu.comment.service.AdminService;
import cn.tedu.comment.service.RoleService;
import cn.tedu.comment.tool.WebUtils;
/**
 * 
 * @author lyh
 * @Date   2017年7月12日
 * 管理员管理的controller
 */
@Controller
@RequestMapping("/sysadmin/admin")
public class AdminController extends BaseController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private RoleService roleService;
	//管理员列表的查询
	@RequestMapping("/list")
	public String findAllAdmins(Model model){
		List<Admin> adminList=adminService.findAllAdmins();
		model.addAttribute("adminList", adminList);
		return "/backend/sysadmin/admin/adminList";
	}
	//管理员的停用
	@RequestMapping("/stop")
	public String stop(@RequestParam("adminId")String[] adminIds){
		adminService.updateAdminStateByAdminIds(adminIds,2);
		return "redirect:/sysadmin/admin/list";
	}
	//跳转至管理员用户页面
	@RequestMapping("/toAdd")
	public String toAddAdmin(){
		return "/backend/sysadmin/admin/adminAdd";
	}
	//管理员新增
	@RequestMapping("/add")
	public String addAdmin(Admin admin,HttpSession session,Model model){
		if(WebUtils.isNull(admin.getUsername())||WebUtils.isNull(admin.getPassword())){
			model.addAttribute("msg", "用户名和密码不能为空");
			return "/backend/sysadmin/admin/adminAdd";
		}
		//获取用户名,根据用户名查询该用户明是否已存在
		Admin ad=adminService.findAdminByUserName(admin.getUsername());
		if(ad!=null){
			model.addAttribute("msg", "该用户名已存在");
			return "/backend/sysadmin/admin/adminAdd";
		}
		
		//获取当前登录用户
		Admin adminUser=(Admin) session.getAttribute("sessionadmin");
		String username=adminUser.getUsername();
		//将创建人设置为当前登录的用户
		admin.setCreateBy(username);
		admin.setUpdateBy(username);
		adminService.saveAdmin(admin);
		return "redirect:/sysadmin/admin/list";
	}
	//管理员删除
	@RequestMapping("/delete")
	public String delete(@RequestParam("adminId")String[] adminIds){
		adminService.deleteAdminByIds(adminIds);
		return "redirect:/sysadmin/admin/list";
	}
	//管理员信息查询
	@RequestMapping("/view")
	public String view(String adminId,Model model){
		Admin adminMsg=adminService.findAdminById(adminId);
		model.addAttribute("adminMsg", adminMsg);
		return "/backend/sysadmin/admin/adminView";
	}
	//跳转至更新页面
	@RequestMapping("/toUpdate")
	public String toUpdate(String adminId,Model model){
		Admin adminMsg=adminService.findAdminById(adminId);
		model.addAttribute("adminMsg", adminMsg);
		return "/backend/sysadmin/admin/adminUpdate";
	}
	//管理员信息的更新
	@RequestMapping("/update")
	public String update(MultipartFile photo,HttpServletRequest request,Admin admin,HttpSession session) throws IOException{
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
			FileUtils.writeByteArrayToFile(new File(filename), photo.getBytes());
			//-------------------------------
			
		}
		
		
		//获取当前登录用户
		Admin adminUser=(Admin) session.getAttribute("sessionadmin");
		String username=adminUser.getUsername();
		admin.setUpdateBy(username);
		
		adminService.updateAdmin(admin);
		
		return "redirect:/sysadmin/admin/list";
	}
	//跳转至角色分配页面
	@RequestMapping("/toRole")
	public String toRole(String adminId,Model model) throws JsonProcessingException{
		//查询所有角色(超级管理员除外)
		List<Role> roleList=roleService.findRoles();
		List<String> roleIdList=roleService.findRoleIdsByAdminId(adminId);
		//遍历角色列表
		for(Role role:roleList){
			//如果该角色的角色id在该用户所拥有的角色id集合中,则把checked属性设置成true
			if(roleIdList.contains(role.getId())){
				role.setChecked(true);
			}
		}
		ObjectMapper mapper=new ObjectMapper();
		String zTreeJson=mapper.writeValueAsString(roleList);
		model.addAttribute("adminId", adminId);
		model.addAttribute("zTreeJson", zTreeJson);
		return "/backend/sysadmin/admin/adminRole";
	}
	//为用户分配权限
	@RequestMapping("/role")
	public String role(String[] roleIds,String adminId){

		roleService.saveAdminRole(adminId,roleIds);
		return "redirect:/sysadmin/admin/list";
	}
	@RequestMapping("/ajax")
	public void ajaxVerify(String username,HttpServletResponse response) throws IOException{

		Admin admin=adminService.findAdminByUserName(username);
		if(admin==null){
			response.getWriter().write("恭喜,该用户名可以使用");
		}else{
			response.getWriter().write("该用户名已存在");
		}
	}
	
}
