package cn.tedu.comment.pojo;

import java.util.Date;

//生成报表的类,POI以天为单位生成报表
public class POI extends BaseEntity{
	private String vendorName;//商家名称
	private Integer ordernum;//日订单数
	private Double orderMoney;//日成交总额
	private Double avgprice;//订单平均金额
	private Double environment;//环境评分
	private Double taste;//口味评分
	private Double service;//服务评分
	private Date date;//查询日期跨度
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Integer getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	public Double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public Double getAvgprice() {
		return avgprice;
	}
	public void setAvgprice(Double avgprice) {
		this.avgprice = avgprice;
	}
	public Double getEnvironment() {
		return environment;
	}
	public void setEnvironment(Double environment) {
		this.environment = environment;
	}
	public Double getTaste() {
		return taste;
	}
	public void setTaste(Double taste) {
		this.taste = taste;
	}
	public Double getService() {
		return service;
	}
	public void setService(Double service) {
		this.service = service;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "POI [vendorName=" + vendorName + ", ordernum=" + ordernum + ", orderMoney=" + orderMoney + ", avgprice="
				+ avgprice + ", environment=" + environment + ", taste=" + taste + ", service=" + service + ", date="
				+ date + "]";
	}
	
}
