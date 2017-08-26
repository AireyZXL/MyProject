package com.kubuy.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kubuy.common.vo.PaginationResult;
import com.kubuy.dubbo.service.ModuleDubboService;

@Controller
@RequestMapping("/adminManagement/module")
public class ModuleController {
	@Autowired
	private ModuleDubboService moduleDubboService;
	@RequestMapping("/query")
	@ResponseBody
	public PaginationResult findItems(Integer sEcho,Integer iDisplayStart,Integer iDisplayLength){
		PaginationResult result= moduleDubboService.findPageItems(iDisplayStart,iDisplayLength);
		result.setsEcho(sEcho);
		return result;
	}
}
