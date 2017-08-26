package com.kubuy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kubuy.common.mapper.SysMapper;
import com.kubuy.dubbo.pojo.Admin;

public interface AdminMapper extends SysMapper<Admin> {

	public List<Admin> findPageInfo(@Param("start") Integer start,@Param("length") Integer length);

}
