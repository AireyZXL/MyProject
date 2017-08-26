package com.kubuy.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kubuy.admin.mapper.ModuleMapper;
import com.kubuy.common.vo.PaginationResult;
import com.kubuy.dubbo.pojo.Module;
import com.kubuy.dubbo.service.ModuleDubboService;

public class ModuleDubboServiceImpl implements ModuleDubboService {
	@Autowired
	private ModuleMapper moduleMapper;
	@Override
	public PaginationResult findPageItems(Integer start, Integer length) {
		int count=moduleMapper.selectCount(null);
		List<Module> itList=moduleMapper.findPageInfo(start,length);	
		return new PaginationResult(count,itList);
	}

}
