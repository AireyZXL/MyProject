package cn.tedu.comment.pojo;

import java.util.Date;

/**
 * @author ZXL
 * @Date 2017年7月13日
 */
/*
 * 订单表
 */
public class Order extends BaseEntity {
	// 订单id
	private String orderId;
	// 用户id
	private String userId;
	// 商户id
	private String vendorId;
	// 商户名称
	private String vendorName;
	// 用户名称
	private String userName;
	// 订单金额
	private Double money;
	// 订单状态  0:未评价,1已评价
	private Integer state;
	// 支付时间
	private Date payTime;
	//总分
	private Integer Score;
	// 环境分
	private Integer enviromentScore;
	// 口味分
	private Integer tasteScore;
	// 服务分
	private Integer serviceScore;
	// 评价信息
	private String commentMessage;
	// 评价时间
	private Date commentTime;

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
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

	public String getCommentMessage() {
		return commentMessage;
	}

	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public Integer getScore() {
		return Score;
	}

	public void setScore(Integer score) {
		Score = score;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", vendorId=" + vendorId + ", vendorName="
				+ vendorName + ", userName=" + userName + ", money=" + money + ", state=" + state + ", payTime="
				+ payTime + ", Score=" + Score + ", enviromentScore=" + enviromentScore + ", tasteScore=" + tasteScore
				+ ", serviceScore=" + serviceScore + ", commentMessage=" + commentMessage + ", commentTime="
				+ commentTime + "]";
	}

	
}
