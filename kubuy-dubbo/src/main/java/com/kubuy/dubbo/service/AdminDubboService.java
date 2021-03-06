package com.kubuy.dubbo.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.kubuy.common.vo.PaginationResult;
import com.kubuy.dubbo.pojo.Admin;

@Path("admin")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public interface AdminDubboService {
	@GET
	@Path("list")
	public PaginationResult findPageItems(
			@QueryParam(value="iDisplayStart") Integer iDisplayStart,
			@QueryParam(value="iDisplayLength") Integer iDisplayLength
			);

	@GET
	@Path("search")
	public Admin findUserByUserName(
			@QueryParam(value="username") String username
			);
	
}
