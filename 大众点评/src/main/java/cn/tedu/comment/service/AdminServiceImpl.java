package cn.tedu.comment.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.AdminMapper;
import cn.tedu.comment.mapper.RoleMapper;
import cn.tedu.comment.pojo.Admin;
import cn.tedu.comment.pojo.AdminInfo;
import cn.tedu.comment.tool.Md5Password;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Admin> findAllAdmins() {
		
		return adminMapper.findAllAdmins();
	}
	
	@Override
	public void updateAdminStateByAdminIds(String[] adminIds, int state) {
		adminMapper.updateAdminStateByAdminIds(adminIds,state);
	}

	
	@Override
	public void saveAdmin(Admin admin) {
		admin.setAdminId(UUID.randomUUID().toString());
		admin.setCreateTime(new Date());
		admin.setUpdateTime(new Date());
		admin.setState(0);
		admin.setPassword(Md5Password.getMd5HashPassword(admin.getPassword(), admin.getUsername()));
		AdminInfo info=new AdminInfo();
		info.setCreateTime(new Date());
		info.setUpdateTime(new Date());
		info.setAdminInfoId(admin.getAdminId());
		info.setCreateBy(admin.getCreateBy());
		info.setUpdateBy(admin.getUpdateBy());
		admin.setInfo(info);
		
		
		adminMapper.saveAdmin(admin);
		adminMapper.saveAdminInfo(info);
	}

	
	@Override
	public void deleteAdminByIds(String[] adminIds) {
		adminMapper.deleteAdminInfoByIds(adminIds);
		roleMapper.deleteAdminRoleByAdminIds(adminIds);
		adminMapper.deleteAdminByIds(adminIds);
		
	}
	
	@Override
	public Admin findAdminByUserName(String username) {
		
		return adminMapper.findAdminByUserName(username);
	}

	
	@Override
	public Admin findAdminById(String adminId) {
		
		return adminMapper.findAdminById(adminId);
	}

	
	@Override
	public void updateAdmin(Admin admin) {
		admin.getInfo().setAdminInfoId(admin.getAdminId());
		admin.getInfo().setUpdateBy(admin.getUpdateBy());
		admin.setUpdateTime(new Date());
		admin.getInfo().setUpdateTime(new Date());
		adminMapper.updateAdmin(admin);
		adminMapper.updateAdminInfo(admin.getInfo());
	}


	/* (non-Javadoc)
	 * @see cn.tedu.comment.service.AdminService#actionAdmin(cn.tedu.comment.pojo.Admin)
	 */
	@Override
	public void actionAdmin(Admin admin) {
		admin.setUpdateTime(new Date());
		admin.setUpdateBy(admin.getUsername());
		admin.setPassword(Md5Password.getMd5HashPassword(admin.getPassword(), admin.getUsername()));
		AdminInfo info=admin.getInfo();
		info.setUpdateTime(new Date());
		info.setAdminInfoId(admin.getAdminId());
		info.setUpdateBy(admin.getUsername());
		adminMapper.updateAdmin(admin);
		adminMapper.updateAdminInfo(info);

	}


	
	@Override
	public List<String> findModuleNameListByAdminId(String adminId) {
		return adminMapper.findModuleNameListByAdminId(adminId);
	}

	@Override
	public String findVendorByName(String username) {
		return adminMapper.findVendorByName(username);
	}

}
