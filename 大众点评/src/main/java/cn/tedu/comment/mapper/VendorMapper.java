/**
 * 
 */
package cn.tedu.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tedu.comment.pojo.City;
import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.Vendor;

/**
 * @author ZXL
 * @Date   2017年7月12日
 */
public interface VendorMapper {

	/**
	 * @return 返回所有的商户
	 */
	List<Vendor> findAll();

	/**
	 * 添加一个商户
	 * @param vendor
	 */
	void addVendor(Vendor vendor);

	/**
	 * 删除商户
	 * @param vendorIds
	 */
	void deleteVendors(String[] vendorIds);

	/**
	 * 查看商户详细信息
	 * @param vendorId
	 * @return 
	 */
	Vendor findOne(String vendorId);

	/**
	 * 更新商户信息
	 * @param vendor
	 */
	void updateVendor(Vendor vendor);

	/**
	 * 查询城市列表
	 * @return
	 */
	List<City> findCity();

	/**
	 * 通过商户id查询商户姓名
	 * @param vendorId
	 * @return
	 */
	@Select("select vendor_name from vendor_c where vendor_id=#{vendorId}")
	String findVendorNameByVendorId(String vendorId);



	/**
	 * @param category	商品种类
	 * @param begin	从第几条开始
	 * @param 查询多少条数据
	 * @return	商户集合
	 * 根据总分查询对应种类排名前(几)的数据
	 */
	List<Vendor> findBestVendorListOrderByScore(@Param("category")String category,@Param("begin") int begin, @Param("num")int num);


	/**
	 * @param _city	城市
	 * @param _rule	排序规则
	 * @param category	商品种类
	 * @return
	 * 根据城市,种类以及排序规则查询商户
	 */
	List<Vendor> findVendorListAfterFilter(@Param("city")String city, @Param("rule")String rule,@Param("category") String category);


	
}
