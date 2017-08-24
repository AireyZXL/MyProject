/**
 * 
 */
package cn.tedu.comment.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.ModuleMapper;
import cn.tedu.comment.pojo.Module;

/**
 * @author ych
 * @Date   2017年7月12日
 */
@Service
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	public List<Module> findAllPage(Integer page) {
		Integer pageno=3;
		System.out.println(page);
		page=(page-1)*pageno;
		Map map = new HashMap();
		map.put("page", page);
		map.put("pageno", pageno);
		return moduleMapper.findAllPage(map);
	}
	
	@Override
	public void udpateState(String moduleId,int state) {
		moduleMapper.updateState(moduleId,state);
	}
	
	@Override
	public void deleteModule(String[] moduleIds) {
		moduleMapper.deleteRoleModuleByModuleIds(moduleIds);
		moduleMapper.deleteModule(moduleIds);
	}
	
	@Override
	public void saveModule(Module module) {
		String id = UUID.randomUUID().toString();
		Date date = new Date();
		module.setModuleId(id);
		module.setCreateTime(date);
		moduleMapper.saveModule(module);
	}
	
	@Override
	public Module findOne(String moduleId) {
		return moduleMapper.findOne(moduleId);
	}
	
	@Override
	public List<Module> findParent() {
		return moduleMapper.findParent();
	}
	
	@Override
	public void updateModule(Module module) {
		moduleMapper.updateModule(module);
	}

	
	@Override
	public void saveRoleModule(String[] moduleIds, String roleId) {
		moduleMapper.deleteRoleModuleByRoleId(roleId);
		for (String moduleId : moduleIds) {
			moduleMapper.saveRoleModule(moduleId,roleId);
		}
	}

	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.ModuleService#findModuleIdsByRoleId(java.lang.String)
	 */
	@Override
	public List<String> findModuleIdsByRoleId(String roleId) {
		
		return moduleMapper.findModuleIdByRoleId(roleId);
	}

	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.ModuleService#findAll()
	 */
	@Override
	public List<Module> findAll() {
		return moduleMapper.findAll();
	}
	
}
