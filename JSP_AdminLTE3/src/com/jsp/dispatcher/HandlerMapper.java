package com.jsp.dispatcher;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.jsp.action.Action;
import com.jsp.action.ApplicationContext;

public class HandlerMapper {

	private HandlerMapper() {}
	
	private static Map<String,Action> commandMap = new HashMap<String,Action>();
	
	static {
		String path="com/jsp/properties/url";
		
		ResourceBundle rbHome=ResourceBundle.getBundle(path);
		
		Set<String> actionSetHome=rbHome.keySet();
		
		Iterator<String> it=actionSetHome.iterator();
		
		while(it.hasNext()) {
			String command = it.next();
			
			String actionClassName = rbHome.getString(command);
			
			System.out.println(actionClassName);
			
			try {
				Class<?> actionClass = Class.forName(actionClassName); //클래스 로딩을 해야 요청한 이름을 알수있다.
				Action commandAction = (Action)actionClass.newInstance();
				
				//의존성 확인 및 조립
				Method[] methods = actionClass.getMethods();
				
				for(Method method : methods) {
					if(method.getName().contains("set")) {
						String paramType=method.getParameterTypes()[0].getName();
						paramType=paramType.substring(paramType.lastIndexOf(".")+1);
						
						paramType=(paramType.charAt(0)+"").toLowerCase()+paramType.substring(1);
						try {
							method.invoke(commandAction, ApplicationContext.getApplicationContext().get(paramType));
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				
				commandMap.put(command, commandAction);
			}catch(ClassNotFoundException e) {
				System.out.println(actionClassName+"이 존재하지 않습니다.");
			}catch(InstantiationException e) {
				System.out.println(actionClassName+"인스턴스를 생성할 수 없습니다.");
			}catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Action getAction(String command) {
		Action action = commandMap.get(command);
		return action;
	}

}
