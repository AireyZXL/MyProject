/**
 * 
 */
package cn.tedu.comment.service;

import java.util.List;

import cn.tedu.comment.exception.MsgException;
import cn.tedu.comment.pojo.Collect;

/**
 * @author lyh
 * @Date   2017年7月15日	
 */
public interface CollectService {

	/**
	 * @param userId	用户id
	 * @param vendorId	商户id
	 */
	public abstract void saveCollect(String userId, String vendorId) throws MsgException;

	/**
	 * @param userId
	 * @return
	 * 根据用户id查询所有的收藏
	 */
	public abstract List<Collect> findCollectsByUserId(String userId);

	/**
	 * @param collectId
	 */
	public abstract void deleteCollectByCollectId(String collectId);

	

}
