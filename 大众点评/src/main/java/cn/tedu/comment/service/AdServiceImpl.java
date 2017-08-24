/**
 * 
 */
package cn.tedu.comment.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.AdMapper;
import cn.tedu.comment.pojo.Advert;

/**
 * @author wzw
 * @Date   2017年7月12日
 */
@Service
public class AdServiceImpl implements AdService{
	@Autowired
	private AdMapper adMapper;
	//查询广告列表
	@Override
	public List<Advert> findAll() {
		return adMapper.findAll();
	}
	@Override
	public void saveAd(Advert advert) {
		
		//刚添加的访问次数是0
		advert.setViewTimes(0);
		advert.setCreateTime(new Date());
		advert.setUpdateTime(new Date());
		 adMapper.saveAd(advert);
	}
	@Override
	public Advert findAdById(String adId) {
		return adMapper.findAdById(adId);
	}

	@Override
	public void deleteById(String[] adId) {
		adMapper.deleteById(adId);
	}

	@Override
	public void updateAd(Advert advert) {
		advert.setUpdateTime(new Date());
		adMapper.updateAd(advert);
		
	}

	@Override
	public List<Advert> findAdvertsOrderByLevel(int begin, int num) {

		return adMapper.findAdvertsOrderByLevel(begin,num);
	}
	
}
