/**
 * 
 */
package cn.tedu.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.Vendor;
import cn.tedu.comment.pojo.Comment;
import cn.tedu.comment.pojo.VendorInfo;
import cn.tedu.comment.service.StageVendorService;
import cn.tedu.comment.service.VendorService;

/**
 * @author wzw
 * @Date   2017年7月14日
 */
@Controller

public class StageVenderController {
	@Autowired
	private StageVendorService stagevendorService;
	@RequestMapping("/stage/toVonder")
	public String toVender(String vendorId,Model model){
		stagevendorService.updateViewTimes(vendorId);
		//根据商户ID查询商户数据
		VendorInfo vendorInfo=stagevendorService.findOne(vendorId);	
		//根据商户ID查询订单信息									
		model.addAttribute("vendorInfo", vendorInfo);
		return "/stage/vendor/vendorinfo";
	}
}
