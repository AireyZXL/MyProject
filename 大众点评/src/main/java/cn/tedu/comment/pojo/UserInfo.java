package cn.tedu.comment.pojo;

import java.util.Date;
/**
 * 前端用户详情信息
 * @author Administrator
 *
 */
public class UserInfo{
	 
	 private String userInfoId;
	 private String name;
	 private String cardNo;
	 private Date birthday;
	 private String gender;
	 private String telephone;
	 private String email;
	 private String remark;
	 private Date updateTime;

	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
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
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "UserInfo [userInfoId=" + userInfoId + ", name=" + name + ", cardNo=" + cardNo + ", birthday=" + birthday
				+ ", gender=" + gender + ", telephone=" + telephone + ", email=" + email + ", remark=" + remark
				+ ", updateTime=" + updateTime + "]";
	}
	
	
	
}
