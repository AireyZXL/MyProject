/**
 * 
 */
package cn.tedu.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.OrderAndVendor;
import cn.tedu.comment.pojo.User;
import cn.tedu.comment.service.OrderService;
import cn.tedu.comment.service.VendorService;
import cn.tedu.comment.tool.WebUtils;

/**
 * @author ZXL
 * @Date 2017年7月14日
 */
@Controller
@RequestMapping("stage/order")
public class StageOrderListController {
	@Autowired
	private OrderService orderService;

	@RequestMapping("/choose")
	public String toChoose(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			return "stage/login/login";
		} else {
			List<OrderAndVendor> orderAndVendorList = orderService.findOrderAndVendorByUserId(user.getUserId());
			System.out.println("orderAndVendorList:" + orderAndVendorList);
			model.addAttribute("orderAndVendorList", orderAndVendorList);
			return "/stage/order";
		}
	}

}
