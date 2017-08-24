package cn.tedu.comment.pojo;

import java.util.Date;
/**
 * 后端用户详情信息
 * @author Administrator
 *
 */
public class AdminInfo extends BaseEntity{
	private String adminInfoId;
	private String imgurl;
	private String name;
	private String cardNo;
	private Date birthday;
	private String gender;
	private String telephone;
	private String email;
	private String remark;
	public String getAdminInfoId() {
		return adminInfoId;
	}
	public void setAdminInfoId(String adminInfoId) {
		this.adminInfoId = adminInfoId;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "AdminInfo [adminInfoId=" + adminInfoId + ", imgurl=" + imgurl + ", name=" + name + ", cardNo=" + cardNo
				+ ", birthday=" + birthday + ", gender=" + gender + ", telephone=" + telephone + ", email=" + email
				+ ", remark=" + remark + "]";
	}
	
}
