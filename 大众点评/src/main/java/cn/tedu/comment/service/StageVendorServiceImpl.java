/**
 * 
 */
package cn.tedu.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.StageVendorMapper;
import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.User;
import cn.tedu.comment.pojo.Vendor;
import cn.tedu.comment.pojo.VendorInfo;
import cn.tedu.comment.pojo.Comment;


@Service
public class StageVendorServiceImpl implements StageVendorService {
	@Autowired
	private StageVendorMapper stageVendorMapper;
	@Override
	public VendorInfo findOne(String vendorId) {
		Vendor vendor=stageVendorMapper.findOne(vendorId);		
		System.out.println(vendor);
		VendorInfo vendorInfo= stageVendorMapper.findVendor(vendorId);
		System.out.println(vendorInfo);
		vendorInfo.setVendor(vendor);
		List<Comment> commentList=stageVendorMapper.findComment(vendorId);									
		System.out.println(commentList);
		vendorInfo.setCommentList(commentList);
		return vendorInfo;
	}	
	

	@Override
	public Order findOrderByVendorId(String vendorId) {
		return stageVendorMapper.findOrderByVendorId(vendorId);
	}

	@Override
	public void updateViewTimes(String vendorId) {
			stageVendorMapper.updateViewTimes(vendorId);
		
	}


	
}
