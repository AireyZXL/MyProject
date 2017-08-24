package cn.tedu.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tedu.comment.pojo.User;
import cn.tedu.comment.pojo.UserInfo;

public interface UserMapper {

	

	List<User> findAll();

	/**
	 * 通过用户Id查询用户姓名
	 * 
	 * @param userId
	 * @return
	 */
	@Select("select username from user_c where user_id=#{userId}")
	String findUserNameByUserId(String userId);

	/**
	 * 添加一个用户
	 * 
	 * @param user
	 */
	void addUser(User user);

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	User findUserByUserName(String username);

	/**
	 * 注册用户详细信息
	 * @param userInfo
	 */
	void userinforegist(UserInfo userInfo);

	/**
	 * @param userIds	用户id
	 * @param state 对应的状态值
	 */
	void updateUserStateByUserId(@Param("userIds")String[] userIds,@Param("state") int state);
}
