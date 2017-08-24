package cn.tedu.comment.pojo;

import java.util.Date;
/**
 * 前端用户信息
 * @author Administrator
 *
 */
public class User {
	
	private String userId;
	private String password;
	private String username;
	private Integer state;
	private Date registTime;

	private UserInfo userInfo;
	
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", username=" + username + ", state=" + state
				+ ", registTime=" + registTime + ", userInfo=" + userInfo + "]";
	}
	
	
	
	
}
