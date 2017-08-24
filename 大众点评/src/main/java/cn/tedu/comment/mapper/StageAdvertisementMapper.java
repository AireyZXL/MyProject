/**
 * 
 */
package cn.tedu.comment.mapper;

import cn.tedu.comment.pojo.Advert;

/**
 * @author ych
 * @Date   2017年7月14日
 */
public interface StageAdvertisementMapper {

	/**
	 * @param imgurl
	 * @return
	 */
	Advert findAdvertByImgurl(String imgurl);

	/**
	 * @param advert
	 */
	void updateAd(Advert advert);

}
