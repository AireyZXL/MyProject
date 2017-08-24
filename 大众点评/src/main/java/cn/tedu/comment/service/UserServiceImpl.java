package cn.tedu.comment.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.UserMapper;
import cn.tedu.comment.pojo.User;
import cn.tedu.comment.pojo.UserInfo;
/**
 * Usersevice实现类
 * @author wsc
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	/**
	 * 用于通过用户名获取用户对象
	 * @param username
	 * @return User
	 */
	@Override
	public User findUserByUserName(String username) {
		return userMapper.findUserByUserName(username);
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public String findUserNameByUserId(String userId) {
		return userMapper.findUserNameByUserId(userId);
	}

	@Override
	public void addUser(User user) {
		user.setRegistTime(new Date());
		user.setState(1);
		userMapper.addUser(user);
	}

	@Override
	public boolean hasUser(String username) {
		return userMapper.findUserByUserName(username)!=null;
	}

	/* 
	 * 注册用户详细信息
	 */
	@Override
	public void userinforegist(UserInfo userInfo) {
		userInfo.setUpdateTime(new Date());
		userMapper.userinforegist(userInfo);
	}

	
	@Override
	public void updateUserStateByUserId(String[] userIds, int state) {
		userMapper.updateUserStateByUserId(userIds,state);
		
	}


	

	
}
