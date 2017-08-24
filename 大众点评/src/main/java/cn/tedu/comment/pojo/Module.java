package cn.tedu.comment.pojo;
/**
 * 后端模块信息
 * @author Administrator
 *
 */
public class Module extends BaseEntity {
	private String moduleId;
	private Module parentModule;
	private String name;
	private int type;	//0:一级菜单,1:二级菜单,2:我的按钮
	private Integer state;
	private Integer orderNo;
	private String remark;
	private Boolean checked;
	/**
	 * 为ztree数提供get方法
	 * @return
	 */
	
	public String getId(){
		return moduleId;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public String getpId(){
		return parentModule==null?null:parentModule.getId();
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", parentModule=" + parentModule + ", name=" + name + ", type=" + type
				+ ", state=" + state + ", orderNo=" + orderNo + ", remark=" + remark + "]";
	}
	
}
