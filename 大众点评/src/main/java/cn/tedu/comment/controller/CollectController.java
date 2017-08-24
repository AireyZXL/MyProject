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
import cn.tedu.comment.pojo.Collect;
import cn.tedu.comment.pojo.User;
import cn.tedu.comment.service.CollectService;

/**
 * @author lyh
 * @Date   2017年7月16日	
 */
@Controller
public class CollectController {
	@Autowired
	private CollectService collectService;
	@RequestMapping("/stage/collect")
	public String collect(HttpSession session,Model model){
		User user=(User) session.getAttribute("user");
		if(user==null){
			return "redirect:/stage/toLogin";
		}
		List<Collect> cList=collectService.findCollectsByUserId(user.getUserId());
		model.addAttribute("cList", cList);
		return "/stage/collect/collect";
	}
	//将商户添加到收藏夹
	@RequestMapping("/stage/addCollect")
	public String addCollect(HttpSession session,String vendorId,Model model){
		User user=(User) session.getAttribute("user");
		if(user==null){
			return "redirect:/stage/toLogin";
		}
		String userId=user.getUserId();
		try {
			collectService.saveCollect(userId,vendorId);
			model.addAttribute("msg", "已成功添加到收藏夹");
		} catch (MsgException e) {
			model.addAttribute("msg", e.getMessage());
		}
		return "forward:/stage/collect";
	}
	@RequestMapping("/stage/delete")
	public String deleteCollect(HttpSession session,String collectId){
		User user=(User) session.getAttribute("user");
		if(user==null){
			return "redirect:/stage/toLogin";
		}
		collectService.deleteCollectByCollectId(collectId);
		return "forward:/stage/collect";
	}
}
