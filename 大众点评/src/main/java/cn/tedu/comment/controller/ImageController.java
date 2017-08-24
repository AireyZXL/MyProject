package cn.tedu.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lyh
 * @Date   2017年7月12日	
 * 图片请求Controller
 */
@Controller
public class ImageController {
	@RequestMapping("/sysadmin/admin")
	public void showImage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String url=request.getParameter("imgurl");
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	@RequestMapping("/backend/vendor")
	public void showImg(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String url=request.getParameter("imgurl");
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	@RequestMapping("/backend/Advertisement")
	public void showAdImage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String url=request.getParameter("url");
		request.getRequestDispatcher(url).forward(request, response);
	}

	@RequestMapping("/stage")
	public void showStageImage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String url=request.getParameter("imgurl");
		request.getRequestDispatcher(url).forward(request, response);
	}

}
