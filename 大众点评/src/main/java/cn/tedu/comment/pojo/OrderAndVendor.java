/**
 * 
 */
package cn.tedu.comment.pojo;

import java.util.Date;

/**
 * @author ZXL
 * @Date 2017年7月15日
 */
/*
 * 订单和商户表(两表的数据筛选)
 */
public class OrderAndVendor {
	// 订单id
	private String orderId;
	// 商户名称
	private String vendorName;
	// 交易时间
	private Date payTime;
	// 图片路径
	private String url;
	// 描述信息
	private String remark;
	// 订单金额
	private Double money;
	// 订单状态 0:未评价,1已评价
	private Integer state;

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

	
	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@Override
	public String toString() {
		return "OrderAndVendor [orderId=" + orderId + ", vendorName=" + vendorName + ", payTime=" + payTime + ", url="
				+ url + ", remark=" + remark + ", money=" + money + ", state=" + state + "]";
	}


}
