package cn.tedu.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.tedu.comment.pojo.City;

/**
 * @author wsc
 * @date   2017年7月15日 
 */
public interface StageCityMapper {

	/**
	 * @return
	 */
	public List<String> findCityArea();

	/**
	 * @param cityArea
	 * @return
	 */
	@Select("select * from city where city_area = #{cityArea}")
	public List<City> findCityByCityArea(String cityArea);

}
