package com.jsp.listener;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jsp.action.ApplicationContext;

@WebListener
public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent ctxEvent) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent ctxEvent) {

		Map<String, Object> applicationContext = ApplicationContext.getApplicationContext();

		ServletContext ctx = ctxEvent.getServletContext();
		
		//1. 인스턴스 생성 - 파라미터 이름들을 꺼내서 담음 <param-name>
		Enumeration<String> paramNames = ctx.getInitParameterNames();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String classType = ctx.getInitParameter(paramName);
			try {
				Class<?> cls = Class.forName(classType);

				Object targetObj = cls.newInstance();

				applicationContext.put(paramName, targetObj);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		//2. 인스턴스 의존성 확인 및 조립-set메서드가 있는지 확인
		paramNames = ctx.getInitParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String classType = ctx.getInitParameter(paramName);
			
			try {
				Class<?> cls = Class.forName(classType);

				Method[] methods = cls.getMethods();

				for (Method method : methods) {
					if (method.getName().contains("set")) {
						
						System.out.println(method.getName());
						
						String setInstanceName = ((method.getName().replace("set", "")).charAt(0) + "").toLowerCase()
								+ method.getName().substring(4);
						
						method.invoke(applicationContext.get(paramName), applicationContext.get(setInstanceName));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(applicationContext);
	}

}
