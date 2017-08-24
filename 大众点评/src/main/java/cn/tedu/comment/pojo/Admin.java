package cn.tedu.comment.pojo;
/**
 * 后端用户admin
 * @author Administrator
 *
 */
public class Admin extends BaseEntity {
	private String adminId;
	private String password;
	private String username;
	private Integer state;	//0:未激活,1:启用,2:停用
	private AdminInfo info;
	
	public AdminInfo getInfo() {
		return info;
	}
	public void setInfo(AdminInfo info) {
		this.info = info;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", password=" + password + ", username=" + username + ", state=" + state
				+ ", info=" + info + "]";
	}
	
}
