/**
 * 
 */
package cn.tedu.comment.pojo;

/**
 * @author ZXL
 * @Date 2017年7月12日
 */
public class City extends BaseEntity{
	private String cityId;
	private String cityName;
	private String cityArea;
	
	public String getCityArea() {
		return cityArea;
	}

	public void setCityArea(String cityArea) {
		this.cityArea = cityArea;
	}

	

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", cityArea=" + cityArea + "]";
	}

	
}
