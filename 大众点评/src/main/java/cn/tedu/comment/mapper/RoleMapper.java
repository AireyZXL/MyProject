/**
 * 
 */
package cn.tedu.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tedu.comment.pojo.Role;

/**
 * @author lDZ
 * @Date   2017年7月12日
 */
public interface RoleMapper {

	/**
	 * 查询角色列表
	 * @return
	 */
	public List<Role> findAllRoles();

	/**
	 * 保存新角色
	 * @param role
	 */
	public void insertRole(Role role);

	/**
	 * 依据Id查询角色
	 * @param roleId
	 * @return
	 */
	@Select("select * from role_c where role_id=#{roleId}")
	public Role findOne(String roleId);

	/**
	 * 保存修改的角色信息
	 * @param role
	 */
	public void updateRole(Role role);

	/**
	 *  依据Id删除角色
	 * @param roleId
	 */
	public void deleteRoles(String[] roleId);

	/**
	 * @param adminId	管理员id
	 * @param roleIds	权限id数组
	 */
	public void saveAdminRole(@Param("adminId")String adminId, @Param("roleId")String roleId);

	/**
	 * @param adminId 管理员id
	 */
	public void deleteAdminRoleByAdminId(String adminId);

	/**
	 * @param adminId 管理员id
	 * @return	所有的角色id
	 */
	public List<String> findRoleIdsByAdminId(String adminId);
	/**
	 * 根据管理员id删除对应的用户角色表记录
	 * @param adminIds
	 */
	public void deleteAdminRoleByAdminIds(String[] adminIds);
	/** 
	 * 查询所有角色(超级管理员除外)
	 * @return
	 */
	public List<Role> findRoles();
	/**
	 * 根据角色id删除用户角色表数据
	 * @param roleId
	 */
	public void deleteAdminRoleByRoleIds(String[] roleId);

}
