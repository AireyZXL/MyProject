package cn.tedu.comment.pojo;

/**
 * 商户信息
 * 
 * @author ZXL
 * @Date 2017年7月12日
 */
public class Vendor extends BaseEntity {
	// 商户ID
	private String vendorId;
	// 商户名称
	private String vendorName;
	// 所在城市
	private String city;
	// 详细地址
	private String address;
	// 电话号码
	private String telephone;
	// 类别
	private String category;
	// 人均价格
	private double price;
	// 图片路径
	private String url;
	// 描述信息
	private String remark;
	// 访问次数
	private Integer viewTime;
	//订单数(销售数量)
	private Integer saleNum;
	

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public Integer getViewTime() {
		return viewTime;
	}

	public void setViewTime(Integer viewTime) {
		this.viewTime = viewTime;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", city=" + city + ", address=" + address
				+ ", telephone=" + telephone + ", category=" + category + ", price=" + price + ", url=" + url
				+ ", remark=" + remark + ", viewTime=" + viewTime + ", saleNum=" + saleNum + "]";
	}

	
	

	

}
