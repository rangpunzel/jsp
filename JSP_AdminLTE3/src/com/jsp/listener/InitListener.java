package com.jsp.listener;

import java.lang.reflect.Method;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.BoardDAO;
import com.jsp.dao.MemberDAO;
import com.jsp.service.BoardServiceImpl;
import com.jsp.service.MemberServiceImpl;


@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	String sqlSessionFactoryType = sce.getServletContext().getInitParameter("sqlSessionFactory");
    	String memberDAOType = sce.getServletContext().getInitParameter("memberDAO");
    	String boardDAOType = sce.getServletContext().getInitParameter("boardDAO");
    	
    	
    	try {
			SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)Class.forName(sqlSessionFactoryType).newInstance();
			
			Class<?> cls = Class.forName(memberDAOType);
			
			Method setSqlSessionFactory = cls.getMethod("setSessionFactory", SqlSessionFactory.class);
			
			Object obj = cls.newInstance();
			setSqlSessionFactory.invoke(obj, sqlSessionFactory);
			
			MemberDAO memberDAO = (MemberDAO)obj;
			
			MemberServiceImpl.getInstance().setMemberDAO(memberDAO);
			
			
			
			Class<?> cls2 = Class.forName(boardDAOType);
			
			Method setSqlSessionFactory2 = cls2.getMethod("setSessionFactory", SqlSessionFactory.class);
			
			Object obj2 = cls2.newInstance();
			setSqlSessionFactory2.invoke(obj2, sqlSessionFactory);
			
			BoardDAO boardDAO = (BoardDAO)obj2;
			
			BoardServiceImpl.getInstance().setBoardDAO(boardDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	

    	
    	
    }
	
}
