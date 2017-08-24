
package cn.tedu.comment.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.comment.pojo.Admin;
import cn.tedu.comment.pojo.Advert;
import cn.tedu.comment.service.AdService;
import cn.tedu.comment.tool.WebUtils;

/**
 * @author wzw
 * @Date   2017年7月12日
 * 广告管理
 */
@Controller
@RequestMapping("/backend/Advertisment")
public class AdvertisementController {
	@Autowired
	private AdService adService;
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Advert> adList =adService.findAll();
		model.addAttribute("adList",adList);		
		return "/backend/Advertisement/adList";
	}
	@RequestMapping("toAdd")
	public String toSave(){		
	return "/backend/Advertisement/adCreat";
	}
	@RequestMapping("save")
	public String save(MultipartFile photo,HttpServletRequest request,Advert advert,HttpSession session) throws IOException{
		
		advert.setAdId(UUID.randomUUID().toString());
		/**
		 * 图片上传代码
		 */
		//-----------------------------------------
		ServletContext context=request.getSession().getServletContext();
		String url=context.getRealPath("/WEB-INF/upload/advertisement");
		String photoName=photo.getOriginalFilename();
		//文件后缀
		String suffix=photoName.substring(photoName.lastIndexOf("."));		
		String filename=url+"/"+advert.getAdId()+suffix;		
		advert.setUrl("/WEB-INF/upload/advertisement"+"/"+advert.getAdId()+suffix);
		FileUtils.writeByteArrayToFile(new File(filename), photo.getBytes());
		//-----------------------------------------
		
		
		
		//获取当前登录用户
		Admin admin=(Admin) session.getAttribute("sessionadmin");
		String username=admin.getUsername();
		//将创建人设置为当前登录的用户
		advert.setCreateBy(username);
		advert.setUpdateBy(username);
		adService.saveAd(advert);
		
		
		
		return "redirect:/backend/Advertisment/list";
	}
	@RequestMapping("toupdate")
	public String toUpdate(String adId,Model model){
		Advert advert=adService.findAdById(adId);
		//System.out.println(advert);
		model.addAttribute("advert", advert);
		return "/backend/Advertisement/adUpdate";
	}
	@RequestMapping("update")
	public String update(MultipartFile photo,HttpServletRequest request,Advert advert,HttpSession session) throws IOException{
		
		/**
		 * 图片上传代码
		 */
		//-----------------------------------------
		if(!WebUtils.isNull(photo.getOriginalFilename())){
			ServletContext context=request.getSession().getServletContext();
			String url=context.getRealPath("/WEB-INF/upload/advertisement");
			String photoName=photo.getOriginalFilename();
			//文件后缀
			String suffix=photoName.substring(photoName.lastIndexOf("."));			
			String filename=url+"/"+advert.getAdId()+suffix;		
			advert.setUrl("/WEB-INF/upload/advertisement"+"/"+advert.getAdId()+suffix);
			FileUtils.writeByteArrayToFile(new File(filename), photo.getBytes());
			//-----------------------------------------
			
		}
		
		
		
		
		//获取当前登录用户
		Admin admin=(Admin) session.getAttribute("sessionadmin");
		String username=admin.getUsername();
		
		//将更新人设置为当前登录的用户
		advert.setUpdateBy(username);
		adService.updateAd(advert);
		
		
		return "redirect:/backend/Advertisment/list";
	}
	@RequestMapping("delete")
	public String deleteAd(String [] adId){
		adService.deleteById(adId);		
		return "redirect:/backend/Advertisment/list";
	}
	@RequestMapping("toview")
	public String toView(String adId,Model model){
		//System.out.println(adId);
		Advert advert=adService.findAdById(adId);
		//System.out.println(advert);
		model.addAttribute("advert", advert);
		return "/backend/Advertisement/adView";
	}
}
