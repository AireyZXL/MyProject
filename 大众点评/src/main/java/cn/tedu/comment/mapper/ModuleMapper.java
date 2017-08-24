/**
 * 
 */
package cn.tedu.comment.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.comment.pojo.Module;

/**
 * @author ych
 * @Date   2017年7月12日
 */
public interface ModuleMapper {

	/**
	 * @param map 
	 * @param page 
	 * @param page 
	 * @return
	 */
	public List<Module> findAllPage(Map map);

	/**
	 * @param moduleId
	 * @param state 
	 */
	public void updateState(@Param("moduleId")String moduleId, @Param("state")int state);

	/**
	 * @param module
	 */
	public void deleteModule(String[] moduleIds);

	/**
	 * @param module
	 */
	public void saveModule(Module module);

	/**
	 * @param moduleId
	 * @return
	 */
	public Module findOne(String moduleId);

	/**
	 * @return
	 */
	public List<Module> findParent();

	/**
	 * @param module
	 */
	public void updateModule(Module module);

	/**
	 * @param roleId
	 */
	public void deleteRoleModuleByRoleId(String roleId);

	/**
	 * @param moduleId
	 * @param roleId
	 */
	public void saveRoleModule(@Param("moduleId")String moduleId, @Param("roleId")String roleId);

	/**
	 * @param roleId
	 * @return
	 */
	public List<String> findModuleIdByRoleId(String roleId);

	/**
	 * @return
	 */
	public List<Module> findAll();

	public void deleteRoleModuleByRoleIds(String[] roleId);

	public void deleteRoleModuleByModuleIds(String[] moduleIds);

}
