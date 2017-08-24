/**
 * 
 */
package cn.tedu.comment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.exception.MsgException;
import cn.tedu.comment.pojo.Advert;
import cn.tedu.comment.pojo.User;
import cn.tedu.comment.pojo.Vendor;
import cn.tedu.comment.service.AdService;
import cn.tedu.comment.service.CollectService;
import cn.tedu.comment.service.VendorService;

/**
 * @author lyh
 * @Date   2017年7月14日	
 */
@Controller
public class StageHomeController {
	@Autowired
	private AdService adService;
	@Autowired
	private VendorService vendorService;
	
	@RequestMapping("/stage/home")
	public String home(Model model){
		
		//根据权重排名查询前6条广告
		List<Advert> adList=adService.findAdvertsOrderByLevel(0,6);
		//根据评价总分排序查询种类是美食的前四名
		List<Vendor> foodList=vendorService.findBestVendorListOrderByScore("美食",0,4);
		//根据评价总分排序查询种类是电影的前四名
		List<Vendor> mList=vendorService.findBestVendorListOrderByScore("电影", 0, 4);
		//根据评价总分排序查询种类是休闲娱乐的前四名
		List<Vendor> eList=vendorService.findBestVendorListOrderByScore("休闲娱乐", 0, 4);
		//根据评价总分排序查询种类是运动健身的前四名
		List<Vendor> sList=vendorService.findBestVendorListOrderByScore("运动健身", 0, 4);
		//根据评价总分排序查询种类是景点的前四名
		List<Vendor> tList=vendorService.findBestVendorListOrderByScore("景点", 0, 4);
		//根据评价总分排序查询种类是KTV的前四名
		List<Vendor> kList=vendorService.findBestVendorListOrderByScore("KTV", 0, 4);
		model.addAttribute("adList", adList);
		model.addAttribute("foodList", foodList);
		model.addAttribute("mList", mList);
		model.addAttribute("eList", eList);
		model.addAttribute("sList", sList);
		model.addAttribute("tList", tList);
		model.addAttribute("kList", kList);
		return "/stage/index";
	}

}
