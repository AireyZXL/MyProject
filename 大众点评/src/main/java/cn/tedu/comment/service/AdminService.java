package cn.tedu.comment.service;

import java.util.List;

import cn.tedu.comment.pojo.Admin;

public interface AdminService {

	public abstract List<Admin> findAllAdmins();

	/**根据用户id修改用户的状态
	 * @param adminIds	用户id数组
	 * @param i	需要改成的状态
	 */
	public abstract void updateAdminStateByAdminIds(String[] adminIds, int state);

	/**
	 * @param admin 将用户保存进数据库
	 */
	public abstract void saveAdmin(Admin admin);

	/**
	 * @param adminIds 根据id删除管理员
	 */
	public abstract void deleteAdminByIds(String[] adminIds);
	
	/**
	 * @param username 根据username查询管理员
	 */
	public Admin findAdminByUserName(String username);

	/**
	 * @param adminId 根据用户id查询管理员
	 * @return 管理员对象
	 */
	public abstract Admin findAdminById(String adminId);

	/**
	 * @param admin 更新用户
	 */
	public abstract void updateAdmin(Admin admin);


	/**
	 * @param admin 激活用户
	 */
	public abstract void actionAdmin(Admin admin);



	/**根据管理员的id返回该管理员拥有的模块的名称
	 * @param adminId	用户id
	 * @return	模块名称的集合
	 */
	public abstract List<String> findModuleNameListByAdminId(String adminId);

	/**
	 * 根据username查询管理员
	 * @param username
	 * @return
	 */
	public abstract String findVendorByName(String username);
	

}
