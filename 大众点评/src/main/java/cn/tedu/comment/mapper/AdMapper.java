/**
 * 
 */
package cn.tedu.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.comment.pojo.Advert;

/**
 * @author wzw
 * @Date   2017年7月12日
 */
public interface AdMapper {

	/**查询广告列表
	 * @return 广告list
	 */
	public List<Advert> findAll();

	/**新增广告
	 * @param advert
	 */
	public void saveAd(Advert advert);


	/**根据Id查找广告
	 * @param adId
	 * @return
	 */
	public Advert findAdById(String adId);

	/**
	 * @param adId
	 */
	public void deleteById(String[] adId);


	/**更新广告
	 * @param advert
	 */
	public void updateAd(Advert advert);

	/**
	 * @param begin	从第几条开始
	 * @param num	返回多少条
	 * @return	广告集合
	 * 根据权重级别筛选广告
	 */
	public List<Advert> findAdvertsOrderByLevel(@Param("begin")int begin, @Param("num")int num);
	
}
