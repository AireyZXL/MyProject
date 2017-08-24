/**
 * 
 */
package cn.tedu.comment.service;

import java.util.List;

import cn.tedu.comment.pojo.Role;

/**
 * @author lDZ
 * @Date   2017年7月12日
 */
public interface RoleService {

	/** 
	 * 查询所有角色
	 * @return
	 */
	public List<Role> findAllRoles();

	/**
	 * 保存新增角色
	 * @param role
	 */
	public void insertRole(Role role);

	/**
	 * 依据Id查询角色
	 * @param roleId
	 * @return
	 */
	public Role findOne(String roleId);

	/**
	 * 保存修改的角色信息
	 * @param role
	 */
	public void updateRole(Role role);

	/**
	 * 依据Id删除角色
	 * @param roleId
	 */
	public void deleteRoles(String[] roleId);

	/**
	 * @param adminId	管理员id
	 * @param roleIds	权限id数组
	 */
	public void saveAdminRole(String adminId, String[] roleIds);

	/**
	 * @param adminId 管理员id
	 * @return	所有的角色id
	 */
	public List<String> findRoleIdsByAdminId(String adminId);

	/** 
	 * 查询所有角色(超级管理员除外)
	 * @return
	 */
	public List<Role> findRoles();

}
