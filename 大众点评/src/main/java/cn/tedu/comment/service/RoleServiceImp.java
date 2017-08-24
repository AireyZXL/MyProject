/**
 * 
 */
package cn.tedu.comment.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.ModuleMapper;
import cn.tedu.comment.mapper.RoleMapper;
import cn.tedu.comment.pojo.Role;

/**
 * @author lDZ
 * @Date   2017年7月12日
 */
@Service
public class RoleServiceImp implements RoleService{
	
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private ModuleMapper moduleMapper;
	/* 
	 * 查询角色列表
	 */
	@Override
	public List<Role> findAllRoles() {
		
		return roleMapper.findAllRoles();
	}
	
	/* 
	 * 新增角色
	 */
	@Override
	public void insertRole(Role role) {
		role.setRoleId(UUID.randomUUID().toString());
		Date date = new Date();
		role.setCreateTime(date);
		roleMapper.insertRole(role);
		
	}

	/* 
	 * 依据Id查询角色
	 */
	@Override
	public Role findOne(String roleId) {
		return roleMapper.findOne(roleId);
	}

	/* 
	 * 保存修改的角色信息
	 */
	@Override
	public void updateRole(Role role) {
		Date date = new Date();
		role.setUpdateTime(date);
		roleMapper.updateRole(role);
	}

	/* 
	 * 依据Id删除角色
	 */
	@Override
	public void deleteRoles(String[] roleId) {
		roleMapper.deleteAdminRoleByRoleIds(roleId);
		moduleMapper.deleteRoleModuleByRoleIds(roleId);
		roleMapper.deleteRoles(roleId);
	}

	
	@Override
	public void saveAdminRole(String adminId, String[] roleIds) {
		roleMapper.deleteAdminRoleByAdminId(adminId);
		for (String roleId : roleIds) {
			roleMapper.saveAdminRole(adminId,roleId);
		}		
	}

	
	@Override
	public List<String> findRoleIdsByAdminId(String adminId) {
		
		return roleMapper.findRoleIdsByAdminId(adminId);
	}

	@Override
	public List<Role> findRoles() {
		return roleMapper.findRoles();
	}


	
}
