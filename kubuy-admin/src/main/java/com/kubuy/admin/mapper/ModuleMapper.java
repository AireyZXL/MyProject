package com.kubuy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kubuy.common.mapper.SysMapper;
import com.kubuy.dubbo.pojo.Module;

public interface ModuleMapper extends SysMapper<Module> {
	public List<Module> findPageInfo(@Param("start") Integer start,@Param("length") Integer length);
}
