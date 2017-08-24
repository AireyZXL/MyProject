package cn.tedu.comment.service;

import java.util.Date;
import java.util.List;

import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.OrderAndVendor;
import cn.tedu.comment.pojo.POI;

public interface OrderService {

	//查询订单报表
	public List<Order> findOrderByVid(String vendorId);

	// 查询订单报表
	public List<POI> findPOIByVid(String vendorId, Date startdate, Date enddate);

	/**
	 * 查询所有的订单
	 * 
	 * @return
	 */
	public List<Order> findAll();

	/**
	 * 删除选中的订单
	 * 
	 * @param orderIds
	 */
	public void deleteOrderIds(String[] orderIds);

	/**
	 * 查看选中的订单详情
	 * @param orderId
	 * @return
	 */
	public Order findOne(String orderId);

	/**
	 * 查询平台当日销售订单，以销售额排序
	 * @return
	 */
	public List<POI> findPois();

	/**
	 * 通过用户id查询订单表并关联商户表封装成OrderAndVendor
	 * @param userId
	 * @return
	 */
	public List<OrderAndVendor> findOrderAndVendorByUserId(String userId);


}
