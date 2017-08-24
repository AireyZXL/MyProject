package cn.tedu.comment.pojo;

import java.util.Date;
/**
 * 广告信息advert
 * @author Administrator
 *
 */
public class Advert extends BaseEntity{
	private String adId;
	private String adName;
	private String url;
	private Integer level;
	private String remark;
	private Integer viewTimes;
	
	
	public String getAdId() {
		return adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Integer getViewTimes() {
		return viewTimes;
	}
	public void setViewTimes(Integer viewTimes) {
		this.viewTimes = viewTimes;
	}
	@Override
	public String toString() {
		return "Advert [adId=" + adId + ", adName=" + adName + ", url=" + url + ", level=" + level + ", remark="
				+ remark + ", viewTimes=" + viewTimes + "]";
	}
	
	
	
}
