/**
 * 
 */
package cn.tedu.comment.pojo;

import java.util.Date;

/**
 * @author lyh
 * @Date   2017年7月15日	
 */
public class VComment {
	
	private String commentId;
	private String vendorId;
	private String userId;
	private String orderId;
	//商户名
	private String vendorName;
	private Integer score;
	private Integer enviromentScore;
	private Integer tasteScore;
	private Integer serviceScore;
	//消费者
	private String username;
	//评论时间
	private Date commentTime;
	//评论信息
	private String commentMessage;
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getEnviromentScore() {
		return enviromentScore;
	}
	public void setEnviromentScore(Integer enviromentScore) {
		this.enviromentScore = enviromentScore;
	}
	public Integer getTasteScore() {
		return tasteScore;
	}
	public void setTasteScore(Integer tasteScore) {
		this.tasteScore = tasteScore;
	}
	public Integer getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(Integer serviceScore) {
		this.serviceScore = serviceScore;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentMessage() {
		return commentMessage;
	}
	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}
	@Override
	public String toString() {
		return "VComment [commentId=" + commentId + ", vendorId=" + vendorId + ", userId=" + userId + ", orderId="
				+ orderId + ", vendorName=" + vendorName + ", score=" + score + ", enviromentScore=" + enviromentScore
				+ ", tasteScore=" + tasteScore + ", serviceScore=" + serviceScore + ", username=" + username
				+ ", commentTime=" + commentTime + ", commentMessage=" + commentMessage + "]";
	}
	
	

	
}
