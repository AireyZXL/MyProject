package cn.tedu.comment.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import cn.tedu.comment.pojo.Admin;
import cn.tedu.comment.pojo.User;
import cn.tedu.comment.service.AdminService;


public class AuthRealm extends AuthorizingRealm{
	@Resource
	private AdminService adminService;
	
	
	//权限控制
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		//展现用户的真实的模块信息

		Subject subject = SecurityUtils.getSubject();
		Admin admin=(Admin) subject.getPrincipal();
		String adminId= admin.getAdminId();		
		//通过信息查询模块信息

		List<String> moduleList = adminService.findModuleNameListByAdminId(adminId);

		//创建权限认证的对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				
		info.addStringPermissions(moduleList);
				
		return info;
		
	}
	
	
	
	
	
	/**
	 * 登陆认证  wsc
	 */ 
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//通过realm 返回给安全中心 真实的用户信息
		
		//获取用户名
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		
		String username = loginToken.getUsername();
		
		//表示真实的信息
		Admin admin = adminService.findAdminByUserName(username);
		
		
		
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
