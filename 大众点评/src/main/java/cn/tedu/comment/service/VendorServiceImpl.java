/**
 * 
 */
package cn.tedu.comment.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.CollectMapper;
import cn.tedu.comment.mapper.CommentMapper;
import cn.tedu.comment.mapper.OrderMapper;
import cn.tedu.comment.mapper.VendorMapper;
import cn.tedu.comment.pojo.City;
import cn.tedu.comment.pojo.Vendor;

/**
 * @author ZXL
 * @Date 2017年7月12日
 */
@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorMapper vendorMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private CollectMapper collectMapper;
	@Override
	public List<Vendor> findAll() {
		return vendorMapper.findAll();
	}

	@Override
	public void addVendor(Vendor vendor) {
		vendor.setUpdateTime(new Date());
		vendor.setCreateTime(new Date());
		vendor.setViewTime(0);
		vendorMapper.addVendor(vendor);
	}

	@Override
	public void deleteVendors(String[] vendorIds) {
		orderMapper.deleteOrdersByVendorId(vendorIds);
		commentMapper.deleteCommentByVendorId(vendorIds);
		collectMapper.deleteCollectByVendorId(vendorIds);
		vendorMapper.deleteVendors(vendorIds);
	}

	@Override
	public Vendor findOne(String vendorId) {

		return vendorMapper.findOne(vendorId);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		vendor.setUpdateTime(new Date());
		vendorMapper.updateVendor(vendor);
	}

	
	@Override
	public List<City> findCity() {
		return vendorMapper.findCity();
	}

	@Override
	public String findVendorNameByVendorId(String vendorId) {
		return vendorMapper.findVendorNameByVendorId(vendorId);
	}
	
	
	@Override
	public List<Vendor> findBestVendorListOrderByScore(String category, int begin, int num) {
		
		return vendorMapper.findBestVendorListOrderByScore(category,begin,num);
	}

	
	@Override
	public List<Vendor> findVendorListAfterFilter(String city, String rule, String category) {
		
		return vendorMapper.findVendorListAfterFilter(city,rule,category);
	}

	
	

}
