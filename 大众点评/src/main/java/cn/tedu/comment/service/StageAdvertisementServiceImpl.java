/**
 * 
 */
package cn.tedu.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.StageAdvertisementMapper;
import cn.tedu.comment.pojo.Advert;

/**
 * @author ych
 * @Date   2017年7月14日
 */
@Service
public class StageAdvertisementServiceImpl implements StageAdvertisementService{
	@Autowired
	private StageAdvertisementMapper stageAdvertisementMapper;
	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.StageAdvertisementService#findAdvertByImgurl(java.lang.String)
	 */
	@Override
	public Advert findAdvertByImgurl(String imgurl) {
		return stageAdvertisementMapper.findAdvertByImgurl(imgurl);
	}
	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.StageAdvertisementService#updateAd()
	 */
	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.StageAdvertisementService#updateAd(cn.tedu.comment.pojo.Advert)
	 */
	@Override
	public void updateAd(Advert advert) {
		stageAdvertisementMapper.updateAd(advert);
	}
	

}
