package com.kubuy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kubuy.common.mapper.SysMapper;
import com.kubuy.dubbo.pojo.Role;

public interface RoleMapper extends SysMapper<Role> {
	public List<Role> findPageInfo(@Param("start") Integer start,@Param("length") Integer length);
}
