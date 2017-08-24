/**
 * 
 */
package cn.tedu.comment.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.exception.MsgException;
import cn.tedu.comment.mapper.CollectMapper;
import cn.tedu.comment.pojo.Collect;
import cn.tedu.comment.pojo.Vendor;

/**
 * @author lyh
 * @Date   2017年7月15日	
 */
@Service
public class CollectServiceImpl implements CollectService{
	@Autowired
	private CollectMapper collectMapper;

	
	@Override
	public void saveCollect(String userId, String vendorId) throws MsgException {
		
		Collect c=collectMapper.findCollectByUserIdAndVendorId(userId,vendorId);
		if(c!=null){
			throw new MsgException("该商户已收藏");
		}
		List<Collect> cList=collectMapper.findCollectsByUserId(userId);
		if(cList.size()>=10){
			throw new MsgException("您最多只能收藏10个商户");
		}
		Collect collect=new Collect();
		Vendor vendor=new Vendor();
		vendor.setVendorId(vendorId);
		collect.setCollectId(UUID.randomUUID().toString());
		collect.setCollectTime(new Date());
		collect.setUserId(userId);
		collect.setVendor(vendor);
		collectMapper.saveCollect(collect);
		
	}


	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.CollectService#findCollectsByUserId(java.lang.String)
	 */
	@Override
	public List<Collect> findCollectsByUserId(String userId) {
		
		return collectMapper.findCollectsByUserId(userId);
	}


	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.CollectService#deleteCollectByCollectId(java.lang.String)
	 */
	@Override
	public void deleteCollectByCollectId(String collectId) {
		collectMapper.deleteCollectByCollectId(collectId);
		
	}
	

}
