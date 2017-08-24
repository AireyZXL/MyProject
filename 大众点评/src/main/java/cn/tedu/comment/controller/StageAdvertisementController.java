/**
 * 
 */
package cn.tedu.comment.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.pojo.Advert;
import cn.tedu.comment.service.StageAdvertisementService;

/**
 * @author ych
 * @Date   2017年7月14日
 */
@Controller
public class StageAdvertisementController {
	@Autowired
	private StageAdvertisementService stageAdvertisementService;
	@RequestMapping("/stage/adIntroduce")
	public String toStateAdvert(Model model,String imgurl){
		Advert advert = stageAdvertisementService.findAdvertByImgurl(imgurl);
		model.addAttribute("advert",advert);
		stageAdvertisementService.updateAd(advert);
		return "/stage/Advertisement/adIntroduce";
	}
	@RequestMapping("/stage/save")
	public String tosave(Model model,String url,String adName,String viewTimes,String remark){
		
		Advert advert = new Advert();
		advert.setAdName(adName);
		advert.setRemark(remark);
		advert.setUrl(url);
		advert.setRemark(viewTimes);
		model.addAttribute("advert",advert);
		return "/stage/Advertisement/adSave";
	}
}
