package cn.tedu.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.tedu.comment.pojo.User;
import cn.tedu.comment.pojo.UserInfo;

/**
 * 用户相关的业务层方法类
 * @author wsc
 *
 */

public interface UserService {
	/**
	 * 用于通过用户名获取用户对象
	 * @param username
	 * @return User
	 */
	User findUserByUserName(String username);
	List<User> findAll();
	/**
	 * 通过用户Id查询用户姓名
	 * @param userId
	 * @return
	 */
	String findUserNameByUserId(String userId);
	/**
	 * 添加一个用户
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 查看数据库是否有该用户s
	 * @param username
	 * @return 
	 */
	boolean hasUser(String username);
	
	/** 
	 * 注册用户详细信息
	 * @param userInfo
	 */
	void userinforegist(UserInfo userInfo);
	/**
	 * @param userIds	用户id
	 * @param state 对应的状态值
	 */
	void updateUserStateByUserId(String[] userIds, int state);
	
}
