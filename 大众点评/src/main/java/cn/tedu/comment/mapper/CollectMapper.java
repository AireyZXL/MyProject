/**
 * 
 */
package cn.tedu.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.comment.pojo.Collect;

/**
 * @author lyh
 * @Date   2017年7月15日	
 */
public interface CollectMapper {

	/**
	 * @param vendorIds
	 */
	public abstract void deleteCollectByVendorId(String[] vendorIds);

	/**
	 * @param userId	用户id
	 * @return
	 * 根据用户id查询该用户所有的查询
	 */
	public abstract List<Collect> findCollectsByUserId(String userId);

	/**
	 * @param collect
	 */
	public abstract void saveCollect(Collect collect);

	/**
	 * @param userId	用户id	
	 * @param vendorId	商户id
	 * @return
	 * 根据用户id和商户id查询收藏记录
	 */
	public abstract Collect findCollectByUserIdAndVendorId(@Param("userId")String userId, @Param("vendorId")String vendorId);

	/**
	 * @param collectId
	 */
	public abstract void deleteCollectByCollectId(String collectId);

	

}
