/**
 * 
 */
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.comment.pojo.Admin;
import cn.tedu.comment.pojo.City;
import cn.tedu.comment.pojo.Vendor;
import cn.tedu.comment.service.VendorService;
import cn.tedu.comment.tool.WebUtils;

/**
 * @author ZXL
 * @Date 2017年7月12日
 */
@Controller
@RequestMapping("/backend/vendor")
public class VendorController {
	@Autowired
	private VendorService vendorService;

	// 跳转至商户管理主页
	@RequestMapping("/list")
	public String toList(Model model) {

		List<Vendor> vendorList = vendorService.findAll();
		// System.out.println("vendorList:" + vendorList);
		model.addAttribute("vendorList", vendorList);
		return "/backend/vendor/JVendorList";
	}

	// 调整至新增商户页面
	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		List<City> cityList = vendorService.findCity();
		model.addAttribute("cityList", cityList);
		return "/backend/vendor/JVendorCreate";
	}

	// 保存数据
	@RequestMapping("/save")
	public String toSave(MultipartFile photo, HttpServletRequest request, Vendor vendor,HttpSession session) throws IOException {
		
		vendor.setVendorId(UUID.randomUUID().toString());
		/**
		 * 图片上传代码
		 */
		//-----------------------------------------
		ServletContext context=request.getSession().getServletContext();
		String url=context.getRealPath("/WEB-INF/upload/advertisement");
		String photoName=photo.getOriginalFilename();
		//文件后缀
		String suffix=photoName.substring(photoName.lastIndexOf("."));	
		String filename=url+"/"+vendor.getVendorId()+suffix;	
		vendor.setUrl("/WEB-INF/upload/advertisement"+"/"+vendor.getVendorId()+suffix);
		FileUtils.writeByteArrayToFile(new File(filename), photo.getBytes());
		//-------------------------------
		
		//获取当前登录用户
		Admin admin=(Admin) session.getAttribute("sessionadmin");
		String username=admin.getUsername();
		//将创建人设置为当前登录的用户
		vendor.setCreateBy(username);
		vendor.setUpdateBy(username);

		
		vendorService.addVendor(vendor);
		return "redirect:/backend/vendor/list";
	}

	// 删除商户数据
	@RequestMapping("/delete")
	public String toDelete(@RequestParam(value = "vendorId", required = true) String[] vendorIds) {
		vendorService.deleteVendors(vendorIds);
		return "redirect:/backend/vendor/list";
	}

	// 查看商户详细信息
	@RequestMapping("/toview")
	public String toView(String vendorId, Model model) {
		Vendor vendor = vendorService.findOne(vendorId);
		model.addAttribute("vendor", vendor);
		return "/backend/vendor/JVendorView";
	}

	// 修改商户信息
	@RequestMapping("/update")
	public String toUpdate(String vendorId, Model model) {
		Vendor vendor = vendorService.findOne(vendorId);
		List<City> cityList = vendorService.findCity();
		model.addAttribute("vendor", vendor);
		model.addAttribute("cityList", cityList);
		// System.out.println(vendor);
		return "/backend/vendor/JVendorUpdate";
	}
//    更新信息(更新数据库)
	@RequestMapping("/toupdate")
	public String toUpdate(MultipartFile photo, HttpServletRequest request,Vendor vendor,HttpSession session) throws IOException {
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
			
			String filename=url+"/"+vendor.getVendorId()+suffix;
			
			vendor.setUrl("/WEB-INF/upload/advertisement"+"/"+vendor.getVendorId()+suffix);
			FileUtils.writeByteArrayToFile(new File(filename), photo.getBytes());
			//-------------------------------
		}
				
		//获取当前登录用户
		Admin admin=(Admin) session.getAttribute("sessionadmin");
		String username=admin.getUsername();
		//将创建人设置为当前登录的用户
		vendor.setUpdateBy(username);
		vendorService.addVendor(vendor);
		
		
		
		
		vendorService.updateVendor(vendor);
		return "redirect:/backend/vendor/list";
	}
}
