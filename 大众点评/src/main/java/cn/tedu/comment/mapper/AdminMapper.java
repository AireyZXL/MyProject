package cn.tedu.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.pojo.Admin;
import cn.tedu.comment.pojo.AdminInfo;

public interface AdminMapper {

	public abstract List<Admin> findAllAdmins();

	/**根据用户id修改用户的状态
	 * @param adminIds	用户id数组
	 * @param i	需要改成的状态
	 */
	public abstract void updateAdminStateByAdminIds(@Param("adminIds")String[] adminIds, @Param("state")int state);

	/**
	 * @param admin 将用户保存进数据库
	 */
	public abstract void saveAdmin(Admin admin);

	/**
	 * @param info 将用户信息加到数据库
	 */
	public abstract void saveAdminInfo(AdminInfo info);

	/**
	 * @param adminIds 根据id删除管理员
	 */
	public abstract void deleteAdminByIds(String[] adminIds);

	/**
	 * @param adminIds 根据id删除管理员信息
	 */
	public abstract void deleteAdminInfoByIds(String[] adminIds);
	
	/**
	 * @param username 根据username查询admin对象
	 */
	@RequestMapping
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
	 * @param info 更新用户信息
	 */
	public abstract void updateAdminInfo(AdminInfo info);

	/**根据管理员的id返回该管理员拥有的模块的名称
	 * @param adminId	用户id
	 * @return	模块名称的集合
	 */
	public abstract List<String> findModuleNameListByAdminId(String adminId);

	/**
	 * 根据管理者名查商铺
	 * @param username
	 * @return
	 */
	@Select("select vendor_id from vendor_c where create_by=#{username}")
	public abstract String findVendorByName(String username);
	
}
