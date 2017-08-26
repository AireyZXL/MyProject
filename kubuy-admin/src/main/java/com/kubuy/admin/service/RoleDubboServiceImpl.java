package com.kubuy.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kubuy.admin.mapper.RoleMapper;
import com.kubuy.common.vo.PaginationResult;
import com.kubuy.dubbo.pojo.Role;
import com.kubuy.dubbo.service.RoleDubboService;

public class RoleDubboServiceImpl implements RoleDubboService {
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public PaginationResult findPageItems(Integer start, Integer length) {
		int count=roleMapper.selectCount(null);
		List<Role> itList=roleMapper.findPageInfo(start,length);	
		return new PaginationResult(count,itList);
	}

}
