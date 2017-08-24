package cn.tedu.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tedu.comment.pojo.Module;
import cn.tedu.comment.pojo.Role;
import cn.tedu.comment.service.ModuleService;
import cn.tedu.comment.service.RoleService;
/**
 * 
 * @author lyh
 * @Date   2017年7月12日
 * 角色管理的controller
 */
@Controller
@RequestMapping("/sysadmin/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;
	//角色列表的查询
	@RequestMapping("/list")
	public String findAllAdmins(Model model){
		List<Role> roleList=roleService.findAllRoles();
		
		model.addAttribute("roleList", roleList);
		
		return "/backend/sysadmin/role/roleList";
	}
	
	//新增角色
	@RequestMapping("/toAdd")
	public String toCreate(){
		
		return "/backend/sysadmin/role/roleCreate";
	}
	
	//保存新增角色
	@RequestMapping("/add")
	public String toSave(Role role){
		
		roleService.insertRole(role);
		
		return "redirect:/sysadmin/role/list";
	}
	
	//修改角色
	@RequestMapping("/toupdate")
	public String toUpdate(String roleId,Model model){
		Role role = roleService.findOne(roleId);
		model.addAttribute("role", role);
		return "/backend/sysadmin/role/roleUpdate";
	}
	
	//保存修改信息
	@RequestMapping("/update")
	public String toUpdate(Role role){
		roleService.updateRole(role);
		return "redirect:/sysadmin/role/list";
	}
	
	//查看角色
	@RequestMapping("/view")
	public String toView(String roleId,Model model){
		Role role = roleService.findOne(roleId);
		model.addAttribute("role", role);
		return "/backend/sysadmin/role/roleView";
	}
	
	//删除角色
	@RequestMapping("/delete")
	public String toDelete(String[] roleId){
		roleService.deleteRoles(roleId);
		return "redirect:/sysadmin/role/list";
	}
	//跳转至模块分配页面
	@RequestMapping("/toModule")
	public String toModule(String roleId,Model model) throws JsonProcessingException{
		List<Module> moduleList=moduleService.findAll();
		List<String> moduleIdList=moduleService.findModuleIdsByRoleId(roleId);
		for(Module module:moduleList){
			if(moduleIdList.contains(module.getModuleId())){
				module.setChecked(true);
			}
		}
		ObjectMapper mapper=new ObjectMapper();
		String zTreeJson=mapper.writeValueAsString(moduleList);
		model.addAttribute("zTreeJson", zTreeJson);
		model.addAttribute("roleId", roleId);
		return "/backend/sysadmin/role/roleModule";
	}
	//为角色分配模块
	@RequestMapping("/module")
	public String module(String[] moduleIds,String roleId){
		moduleService.saveRoleModule(moduleIds,roleId);
		return "redirect:/sysadmin/role/list";
	}
}
