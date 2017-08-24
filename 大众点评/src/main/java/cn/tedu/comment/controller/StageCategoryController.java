/**
 * 
 */
package cn.tedu.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.pojo.Vendor;
import cn.tedu.comment.service.VendorService;
import cn.tedu.comment.tool.WebUtils;

/**
 * @author lyh
 * @Date   2017年7月14日	
 */
@Controller
@RequestMapping("/stage")
public class StageCategoryController {
	@Autowired
	private VendorService vendorService;
	//进行分类选择
	@RequestMapping("/category")
	public String categroy(String category,String city,String rule,Model model){
		
		//给城市设置默认值
		String _city="北京";
		//设置默认排序规则
		String _rule="avg_score";
		
		if(!WebUtils.isNull(rule)){
			_rule=rule;
		}
		if(!WebUtils.isNull(city)){
			_city=city;
		}
		//根据城市,种类以及排序规则查询商户
		List<Vendor> vList=vendorService.findVendorListAfterFilter(_city,_rule,category);
		
		model.addAttribute("category", category);
		model.addAttribute("vList", vList);
		model.addAttribute("city", city);
		return "/stage/category";
	}
}
