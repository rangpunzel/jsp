package com.jsp.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	String childType = sce.getServletContext().getInitParameter("child");
    	
    	Child child = null;
    	
    	try {
			child=(Child) Class.forName(childType).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	Parent.getInstance().setChild(child);
    }
	
}
