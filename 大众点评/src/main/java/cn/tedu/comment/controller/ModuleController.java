/**
 * 
 */
package cn.tedu.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.comment.pojo.Module;
import cn.tedu.comment.service.ModuleService;

/**
 * @author ych
 * @Date   2017年7月12日
 */
@Controller
public class ModuleController extends BaseController{
	@Autowired
	private ModuleService moduleService;
	@RequestMapping("/moduleMain")
	public String toModule(Model model,HttpServletRequest request){
		String parameter = request.getParameter("page");
		String del = request.getParameter("del");
		String plus = request.getParameter("plus");
		List<Module> moduleList;
		Integer page;
		if(parameter==null){
			page=1;
			moduleList = moduleService.findAllPage(page);
		}else{
			
			page = Integer.parseInt(parameter);
			if(del!=null&&page>1){
				
				page=page-1;
			}
			if(plus!=null){
				page=page+1;
			}
			moduleList = moduleService.findAllPage(page);
		}
		model.addAttribute("page",page);
		model.addAttribute("moduleList",moduleList);
		return "/backend/sysadmin/module/jModuleList";
	}
	@RequestMapping("/stop")
	public String tostop(String moduleId){
		int state = 0;
		moduleService.udpateState(moduleId,state);
		return "redirect:/moduleMain";
	}
	@RequestMapping("/start")
	public String tostart(String moduleId){
		int state = 1;
		moduleService.udpateState(moduleId,state);
		return "redirect:/moduleMain";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("moduleId")String[] moduleIds){
		moduleService.deleteModule(moduleIds);
		return "redirect:/moduleMain";
	}
	@RequestMapping("/tocreate")
	public String tocreate(Model model){
		List<Module> parentList = moduleService.findAll();
		model.addAttribute("parentList",parentList);
		return "/backend/sysadmin/module/jModuleCreate";
	}
	@RequestMapping("/save")
	public String saveModule(Module module){
		moduleService.saveModule(module);
		return "redirect:/moduleMain";
	}
	@RequestMapping("/toview")
	public String toview(Model model,String moduleId){
		Module module = moduleService.findOne(moduleId);
		model.addAttribute("module",module);
		return "/backend/sysadmin/module/jModuleView";
	}
	@RequestMapping("/toupdate")
	public String toupdate(Model model,String moduleId){
		Module module = moduleService.findOne(moduleId);
		List<Module> parentList = moduleService.findParent();
		model.addAttribute("module",module);
		model.addAttribute("parentList",parentList);
		return "/backend/sysadmin/module/jModuleUpdate";
	}
	@RequestMapping("/update")
	public String update(Module module){
		moduleService.updateModule(module);
		return "redirect:/moduleMain";
	}
	
}
