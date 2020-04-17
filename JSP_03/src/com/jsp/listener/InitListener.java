package com.jsp.listener;

import java.lang.reflect.Method;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.MemberDAO;
import com.jsp.service.MemberServiceImpl;

@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	String sqlSessionFactoryType = sce.getServletContext().getInitParameter("sqlSessionFactory");
    	String memberDAOType = sce.getServletContext().getInitParameter("memberDAO");
    	
    	try {
			SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)Class.forName(sqlSessionFactoryType).newInstance();
			
			Class<?> cls = Class.forName(memberDAOType);
			
			Method setSqlSessionFactory = cls.getMethod("setSessionFactory", SqlSessionFactory.class);
			
			Object obj = cls.newInstance();
			setSqlSessionFactory.invoke(obj, sqlSessionFactory);
			
			MemberDAO memberDAO = (MemberDAO)obj;
			
			MemberServiceImpl.getInstance().setMemberDAO(memberDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
