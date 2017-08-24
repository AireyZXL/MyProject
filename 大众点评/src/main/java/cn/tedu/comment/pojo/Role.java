package cn.tedu.comment.pojo;
/**
 * 后端 用户的角色管理
 * @author Administrator
 *
 */
public class Role extends BaseEntity{
	private String roleId;
	private String roleName;
	private String remark;
	private Integer orderNo;
	private Boolean checked;
	/**
	 * 为ztree 提供get方法
	 * @return
	 */
	public String getName(){
		return roleName;
	}
	public String getId(){
		return roleId;
	}
	
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", remark=" + remark + ", orderNo=" + orderNo
				+ "]";
	}
	
}
