/**
 * 
 */
package cn.tedu.comment.service;

import java.util.List;

import cn.tedu.comment.pojo.City;

/**
 * @author wsc
 * @date   2017年7月15日 
 */
public interface StageCityService {

	/**
	 * @return 查询所有城市所在区域的合集
	 */
	public List<String> findCityArea();

	/**
	 * @param cityArea 根据城市区域查询所在区域的城市
	 * @return
	 */
	public List<City> findCityByCityArea(String cityArea);

}
