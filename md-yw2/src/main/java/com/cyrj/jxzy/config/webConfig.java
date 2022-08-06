package com.cyrj.jxzy.config;

import com.cyrj.jxzy.util.ConfigureFileUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {


    
	  // 这个方法是用来配置静态资源的，比如html，js，css，等等
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		  registry.addResourceHandler("/aqscImage/**").addResourceLocations("file:"+ ConfigureFileUtil.AQSC_FILE_SAVE_PATH);//安全生产图片拦截
//		  registry.addResourceHandler("/dqjxzyImage/**").addResourceLocations("file:"+ ConfigureFileUtil.FILE_SAVE_PATH);//承包商图片拦截


	  }
	 
	  // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
		  
//		  registry
//		  .addInterceptor(loginInterceptor)
//		  .addPathPatterns("/**")  //拦截所有请求
//		  .excludePathPatterns("/","/admin/login","/postData/design")//放开登陆
//		  .excludePathPatterns(Arrays.asList("/js/**", "/css/**","/icons/**","/images/**","/login/**","/skin/**","/skins/**","/system/**"));
//
//
	        
	  }

 
}