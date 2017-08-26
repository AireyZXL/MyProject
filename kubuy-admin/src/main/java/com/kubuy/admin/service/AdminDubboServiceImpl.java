package com.kubuy.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kubuy.admin.mapper.AdminMapper;
import com.kubuy.common.service.BaseService;
import com.kubuy.common.vo.PaginationResult;
import com.kubuy.dubbo.pojo.Admin;
import com.kubuy.dubbo.service.AdminDubboService;

public class AdminDubboServiceImpl extends BaseService<Admin> implements AdminDubboService {
	@Autowired
	private AdminMapper adminMapper;
	@Override
	public PaginationResult findPageItems(Integer start, Integer length) {
		int count=adminMapper.selectCount(null);
		List<Admin> itList=adminMapper.findPageInfo(start,length);	
		return new PaginationResult(count,itList);
	}
	@Override
	public Admin findUserByUserName(String username) {
		Admin admin=new Admin();
		admin.setUsername(username);
		return super.queryByWhere(admin);
	}

}
