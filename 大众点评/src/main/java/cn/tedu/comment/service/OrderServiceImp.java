/**
 * 
 */
package cn.tedu.comment.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.OrderMapper;
import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.OrderAndVendor;
import cn.tedu.comment.pojo.POI;

/**
 * @author lDZ
 * @Date   2017年7月11日
 */
@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	/* 依据时间查询订单报表
	 * @see 
	 */
	@Override
	public List<POI> findPOIByVid(String vendorId, Date startdate, Date enddate) {
		return orderMapper.findPOIByVid(vendorId,startdate,enddate);
	}
	
	/* 依据vendorId查询订单
	 */
	@Override
	public List<Order> findOrderByVid(String vendorId) {
		return orderMapper.findOrderByVid(vendorId);
	}
	
	@Override
	public List<Order> findAll() {
		return orderMapper.findAll();
	}
	@Override
	public void deleteOrderIds(String[] orderIds) {
		 orderMapper.deleteOrderIds(orderIds);
	}

	@Override
	public Order findOne(String orderId) {
		return orderMapper.findOne(orderId);
	}

	@Override
	public List<POI> findPois() {
		
		return orderMapper.findPois();
	}


	@Override
	public List<OrderAndVendor> findOrderAndVendorByUserId(String userId) {
		
		return orderMapper.findOrderAndVendorByUserId(userId);
	}


}
