/**
 * 
 */
package cn.tedu.comment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.pojo.City;
import cn.tedu.comment.service.StageCityService;

/**
 * @author wsc
 * @date   2017年7月15日 
 */
@Controller
@RequestMapping("/stage")
public class StageCityController extends BaseController{
	@Autowired
	private StageCityService stageCityService;
	@RequestMapping("/toFindCity")
	public String findCity (Model model){
		
		Map<String,List<City>> cityMap = new HashMap<String,List<City>>();
		
		List<String> cityAreaList= stageCityService.findCityArea();
		
		for(String cityArea:cityAreaList){
			List<City> cityList = stageCityService.findCityByCityArea(cityArea);
			cityMap.put(cityArea, cityList);
		}
		
		model.addAttribute("cityMap",cityMap);
		System.out.println(cityMap);
		return "/stage/City";
	}
	
	
}
