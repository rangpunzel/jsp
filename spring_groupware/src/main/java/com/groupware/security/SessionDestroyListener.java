package com.groupware.security;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;

import com.groupware.dto.EmployeeVO;
import com.groupware.service.employee.EmployeeService;

public class SessionDestroyListener implements ApplicationListener<SessionDestroyedEvent> {

	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		List<SecurityContext> contexts = event.getSecurityContexts();
		if(!contexts.isEmpty()) {
			for(SecurityContext ctx : contexts) {
				Authentication auth = ctx.getAuthentication();
				
				if(auth != null && auth.getDetails() != null) {
					try {
						User user = (User)auth.getDetails();
						EmployeeVO loginUser = user.getMemberVO();
						
						employeeService.recentLoginTime(loginUser.getId());
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
	}

}
