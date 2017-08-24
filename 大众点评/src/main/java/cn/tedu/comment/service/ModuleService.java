/**
 * 
 */
package cn.tedu.comment.service;

import java.util.List;

import cn.tedu.comment.pojo.Module;

/**
 * @author ych
 * @Date   2017年7月12日
 */
public interface ModuleService {

	/**
	 * @param page 
	 * @param page 
	 * @param page 
	 * @return
	 */
	List<Module> findAllPage(Integer page);

	/**
	 * @param moduleId
	 * @param state 
	 */
	void udpateState(String moduleId, int state);

	/**
	 * @param module
	 */
	void deleteModule(String[] moduleIds);

	/**
	 * @param module
	 */
	void saveModule(Module module);

	/**
	 * @param moduleId
	 * @return
	 */
	Module findOne(String moduleId);

	/**
	 * @return
	 */
	List<Module> findParent();

	/**
	 * @param module
	 */
	void updateModule(Module module);

	/**
	 * @param moduleIds
	 * @param roleId
	 */
	void saveRoleModule(String[] moduleIds, String roleId);

	/**
	 * @param roleId
	 * @return
	 */
	List<String> findModuleIdsByRoleId(String roleId);

	/**
	 * @return
	 */
	List<Module> findAll();
	
}
