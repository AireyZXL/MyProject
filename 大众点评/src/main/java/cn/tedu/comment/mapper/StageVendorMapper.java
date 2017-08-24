/**
 * 
 */
package cn.tedu.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.User;
import cn.tedu.comment.pojo.Vendor;
import cn.tedu.comment.pojo.Comment;
import cn.tedu.comment.pojo.VendorInfo;

/**
 * @author wzw
 * @Date   2017年7月14日
 */
public interface StageVendorMapper {

	/**根据商户Id查询商户
	 * @param vendorId
	 * @return
	 */
	
	VendorInfo findVendor(String vendorId);
	
	/**根据商户Id查询订单
	 * @param vendorId
	 * @return
	 */
	Order findOrderByVendorId(String vendorId);

	/**查询所有订单
	 * @param vendorId
	 * @return
	 */
	List<VendorInfo> findAll(String vendorId);

	/**根据Id查询评论list
	 * @param vendorId
	 * @return
	 */
	List<Comment> findComment(String vendorId);

	/**根据id查询商户
	 * @param vendorId
	 * @return 
	 */
	Vendor findOne(String vendorId);

	/**根据商户ID查询对应评论的用户
	 * @param vendorId
	 * @return
	 */
	List findUser(String vendorId);

	/**更新访问量
	 * @param vendorId
	 */
		
	void updateViewTimes(String vendorId);

}
