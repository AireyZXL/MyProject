package cn.tedu.comment.pojo;

import java.util.Date;
/**
 * 前端用户收藏collect
 * @author Administrator
 *
 */
public class Collect {
	
	private String collectId;
	private String userId;
	private Vendor vendor;
	private Date collectTime;
	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Date getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}
	@Override
	public String toString() {
		return "Collect [collectId=" + collectId + ", userId=" + userId + ", vendor=" + vendor + ", collectTime="
				+ collectTime + "]";
	}
	

	
	   
}
