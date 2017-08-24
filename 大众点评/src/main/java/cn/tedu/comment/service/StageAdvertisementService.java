/**
 * 
 */
package cn.tedu.comment.service;

import cn.tedu.comment.pojo.Advert;

/**
 * @author ych
 * @Date   2017年7月14日
 */
public interface StageAdvertisementService {

	/**
	 * @param imgurl
	 * @return
	 */
	Advert findAdvertByImgurl(String imgurl);

	/**
	 * @param advert 
	 * 
	 */
	void updateAd(Advert advert);

}
