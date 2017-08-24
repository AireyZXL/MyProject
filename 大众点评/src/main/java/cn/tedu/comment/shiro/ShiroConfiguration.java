/**
 * 
 */
package cn.tedu.comment.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh
 * @Date   2017年7月16日	
 */
@Configuration
public class ShiroConfiguration {
	
	/**
	 * 将Shiro的组件以bean的形式交给Spring管理
	 * @return
	 */
	 @Bean(name = "lifecycleBeanPostProcessor")  
	    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {  
	        return new LifecycleBeanPostProcessor();  
	    }  
	 /**
	  * Spring为shiro的bean创建代理对
	  * @return
	  */
	 @Bean  
	    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {  
	        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();  
	        //表示强制使用cglib为其创建代理对象
	        daap.setProxyTargetClass(true);  
	        return daap;  
	    }  
	 /**
	  * Shiro的安全中心  其中需要提供真实的用户信息. 需要加载realm
	  * @return
	  */
	 @Bean(name = "securityManager")  
	    public DefaultWebSecurityManager getDefaultWebSecurityManager() {  
	        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();  
	        dwsm.setRealm(getAuthRealm());  
	        return dwsm;  
	    }  
	 /**
	  * 自己编辑Realm 为安全中心提供信息
	  * @return
	  */
	 @Bean(name ="myRealm")  
	    public AuthRealm getAuthRealm() {  
		 AuthRealm arl=new AuthRealm();
		 arl.setCredentialsMatcher(getAuthCredential());
	       return arl; 
	    }  
	 /**
	  * 自定义加密算法
	  * @return
	  */
	 public AuthCredential getAuthCredential(){
		return new AuthCredential();
		 	 
	 }
	 
	 /**
	  * 权限认证的适配器
	  */
	 @Bean  
	    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {  
	        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();  
	        aasa.setSecurityManager(getDefaultWebSecurityManager());  
	        return new AuthorizationAttributeSourceAdvisor();  
	    } 
	 /**
	  * shiro的过滤器
	  * @return
	  */
	 @Bean(name ="shiroFilter")  
	    public ShiroFilterFactoryBean getShiroFilterFactoryBean( ) {  
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();  
	        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();  
	        //配置安全中心
	        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());  
	       //指定登陆的地址  当用户没有登陆时.默认跳转该页面
	        shiroFilterFactoryBean.setLoginUrl("index.jsp");  
	        /**
	         * 添加过滤信息
		 	*	1.anon  表示放行
		 	*		2.authc 表示拦截
	         */
	         //放行的资源
	        filterChainDefinitionMap.put("/index.jsp", "anon"); 
	        filterChainDefinitionMap.put("/stage/**", "anon"); 
	        filterChainDefinitionMap.put("/tologin.action", "anon"); 
	        filterChainDefinitionMap.put("/login.action", "anon"); 
	        filterChainDefinitionMap.put("/backstaticfile/**", "anon"); 
	        filterChainDefinitionMap.put("/stagestaticfile/**", "anon"); 
	        filterChainDefinitionMap.put("/WEB-INF/upload/**", "anon"); 
	        //拦截的资源
	        
	        filterChainDefinitionMap.put("/**", "authc");
	       //设置拦截链   
	        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);  
	        return shiroFilterFactoryBean;  
	    }  
}
