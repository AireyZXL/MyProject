package cn.tedu.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.StageCityMapper;
import cn.tedu.comment.pojo.City;

/**
 * @author wsc
 * @date   2017年7月15日 
 */
@Service
public class StageCityServiceImpl implements StageCityService{
	@Autowired
	private StageCityMapper stageCityMapper;
	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.StageCityService#findCityArea()
	 */
	@Override
	public List<String> findCityArea() {
		// TODO Auto-generated method stub
		return stageCityMapper.findCityArea();
	}

	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.StageCityService#findCityByCityArea(java.lang.String)
	 */
	
	@Override
	public List<City> findCityByCityArea(String cityArea) {
		// TODO Auto-generated method stub
		return stageCityMapper.findCityByCityArea(cityArea);
	}

}
