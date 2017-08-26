package com.kubuy.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kubuy.common.vo.PaginationResult;
import com.kubuy.dubbo.service.RoleDubboService;

@Controller
@RequestMapping("/adminManagement/role")
public class RoleController {
	@Autowired
	private RoleDubboService roleDubboService;
	@RequestMapping("/query")
	@ResponseBody
	public PaginationResult findItems(Integer sEcho,Integer iDisplayStart,Integer iDisplayLength){
		PaginationResult result= roleDubboService.findPageItems(iDisplayStart,iDisplayLength);
		result.setsEcho(sEcho);
		return result;
	}
}
