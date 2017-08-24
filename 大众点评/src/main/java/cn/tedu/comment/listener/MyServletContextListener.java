package cn.tedu.comment.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	/**
	 * 当servletContext对象初始化成功是,将该项目的虚拟路径添加到servletContext域中
	 * @author lyh
	 * @Date   2017年7月11日
	 */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		e.getServletContext().setAttribute("app", e.getServletContext().getContextPath());
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		
		
	}

}
