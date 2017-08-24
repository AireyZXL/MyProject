/**
 * 
 */
package cn.tedu.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.Vendor;
import cn.tedu.comment.pojo.Comment;
import cn.tedu.comment.pojo.VendorInfo;

/**
 * @author wzw
 * @Date   2017年7月14日
 */

public interface StageVendorService {

	/**根据商户Id查询商户
	 * @param vendorId
	 * @return
	 */
	VendorInfo findOne(String vendorId);

	
	/**根据Id查收订单
	 * @param vendorId
	 * @return
	 */
	Order findOrderByVendorId(String vendorId);


	/**更新访问量
	 * @param vendorId
	 */
	void updateViewTimes(String vendorId);


}
