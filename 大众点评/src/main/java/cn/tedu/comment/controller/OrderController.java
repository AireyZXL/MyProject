/**
 * 
 */
package cn.tedu.comment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.service.OrderService;
import cn.tedu.comment.service.UserService;
import cn.tedu.comment.service.VendorService;

/**
 * @author ZXL
 * @Date 2017年7月13日
 */
@Controller
@RequestMapping("/backend/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private UserService userService;

	@RequestMapping("list")
	public String toList(Model model) {
		List<Order> orderList = orderService.findAll();
		for (Order order : orderList) {
			String userId = order.getUserId();
			String vendorId = order.getVendorId();
			order.setUserName(userService.findUserNameByUserId(userId));
			order.setVendorName(vendorService.findVendorNameByVendorId(vendorId));
		}
	    // System.out.println(orderList);
		model.addAttribute("orderList", orderList);
		return "/backend/order/JOrderList";
	}
    //删除选中的订单
	@RequestMapping("delete")
	public String toDelete(@RequestParam(value = "orderId", required = true) String[] orderIds) {
		orderService.deleteOrderIds(orderIds);
		return "redirect:/backend/order/list";
	}
 /*  //查看选中的订单
	@RequestMapping("toview")
	public String toView(Model model) {
		List<Order> orderList=orderService.findAll();
		for (Order order : orderList) {
			String userId = order.getUserId();
			String vendorId = order.getVendorId();
			order.setUserName(userService.findUserNameByUserId(userId));
			order.setVendorName(vendorService.findVendorNameByVendorId(vendorId));
		}
		model.addAttribute("orderList", orderList);
		return "/backend/order/JOrderView";
	}*/
}
