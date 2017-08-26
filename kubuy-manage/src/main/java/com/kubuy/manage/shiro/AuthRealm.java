package com.kubuy.manage.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.kubuy.dubbo.pojo.Admin;
import com.kubuy.dubbo.service.AdminDubboService;



public class AuthRealm extends AuthorizingRealm{
	@Autowired
	private AdminDubboService adminDubboService;	
	//权限控制
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
		return null;
	}
	
	
	
	
	
	//登陆认证   
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//通过realm 返回给安全中心 真实的用户信息
		
				//获取用户名
				UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
				
				String username = loginToken.getUsername();
				
				//表示真实的信息
				Admin admin = adminDubboService.findUserByUserName(username);
				
				/*
				 * principal: 真实的对象
				 * credentials: 表示真实的密码 
				 * realmName:  当前的realm
				 */
				
				AuthenticationInfo info = 
						new SimpleAuthenticationInfo(admin, admin.getPassword(), this.getName());
				
				
				return info;
	}
	
	




	
	
	
}
