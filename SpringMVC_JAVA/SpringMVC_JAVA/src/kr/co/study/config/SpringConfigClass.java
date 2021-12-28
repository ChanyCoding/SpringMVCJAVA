package kr.co.study.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class SpringConfigClass implements WebApplicationInitializer{
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO Auto-generated method stub
//		
//		//Spring MVC 에서 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다
//		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
//		servletAppContext.register(ServletAppContext.class);
//		
//		//요청발생시 요청을 처리하는 서블릿을 DispatcherServlet으로 설정해준다
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
//		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
//		
//		//부가설정
//		servlet.setLoadOnStartup(1); //우선순위1
//		servlet.addMapping("/");     //url 맵핑방식
//		
//		//bean을 정의하는 클래스를 지정한다
//		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//		rootAppContext.register(RootAppContext.class);
//		
//		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
//		servletContext.addListener(listener);
//		
//		//파라미터 인코딩 설정
//		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//		filter.setInitParameter("encoding", "UTF-8");
//		filter.addMappingForServletNames(null, false, "dispatcher");
//		
//	}
//
//}

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	//DispatcherServlet에 매핑할 요청 주소를 세팅한다(밑에 얘랑 같음)
	//	servlet.setLoadOnStartup(1);
	//	servlet.addMapping("/");
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	//	Spring MVC 에서 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다(밑에 얘랑 같음)
	//	AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
	//	servletAppContext.register(ServletAppContext.class);
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}
	
	//	bean을 정의하는 클래스를 지정한다(밑에 얘랑 같음)
	//	AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
	//	rootAppContext.register(RootAppContext.class);
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}
	
	//	파라미터 인코딩 설정(밑에 얘랑 같음)
	//	FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
	//	filter.setInitParameter("encoding", "UTF-8");
	//	filter.addMappingForServletNames(null, false, "dispatcher");
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
}
