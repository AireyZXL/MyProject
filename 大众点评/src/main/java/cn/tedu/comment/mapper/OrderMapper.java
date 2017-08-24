/**
 * 
 */
package cn.tedu.comment.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.OrderAndVendor;
import cn.tedu.comment.pojo.POI;

/**
 * @author lDZ
 * @Date   2017年7月11日
 */
public interface OrderMapper {
	
	public List<POI> findPOIByVid(@Param("vendorId")String vendorId, @Param("startdate")Date startdate, @Param("enddate")Date enddate);

	/**
	 * 依据vendorId查询订单
	 * @param vendorId
	 * @return
	 */
	public List<Order> findOrderByVid(String vendorId);

	/**
	 * 查询所有的订单
	 * @return
	 */
	public List<Order> findAll();

	/**
	 * 删除选中的订单
	 * @param orderIds
	 */
	public void deleteOrderIds(String[] orderIds);

	/**
	 * 查看选中的订单详情
	 * @param orderId
	 * @return
	 */
	@Select("select * from order_c where order_id=#{orderId}")
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


	/**
	 * @param vendorIds
	 */
	public void deleteOrdersByVendorId(String[] vendorIds);

}
