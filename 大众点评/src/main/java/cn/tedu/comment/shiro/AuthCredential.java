package cn.tedu.comment.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tedu.comment.tool.Md5Password;

/**
 * 
 * @author wsc
 * Shiro内部加密算法
 * @date   2017年7月12日
 */
public class AuthCredential extends  SimpleCredentialsMatcher{
	
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		
		//将密码进行加密
		String username = loginToken.getUsername();
		String password = String.valueOf(loginToken.getPassword());
		
		//经过加密的密文
		String md5Password = Md5Password.getMd5HashPassword(password, username);
		System.out.println(md5Password);
		loginToken.setPassword(md5Password.toCharArray());
		
		return super.doCredentialsMatch(loginToken, info);
	}
}
