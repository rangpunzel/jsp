package com.groupware.security;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.groupware.dao.employee.EmployeeDAO;
import com.groupware.dto.EmployeeVO;

public class CustomAuthentication implements AuthenticationProvider {

	private EmployeeDAO employeeDAO;
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO=employeeDAO;
	}
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		String login_id = (String) auth.getPrincipal(); //로그인 시도한 ID를 가져온다
		String login_pwd = (String) auth.getCredentials(); //로그인 시도한 Password를 가져온다.
		
		EmployeeVO employee=null;
		try {
			employee=employeeDAO.selectEmployeeById(login_id);
		}catch(SQLException e) {
			//로그인 실패시 LoginFailureHandler로 던짐
			throw new BadCredentialsException("Internal server error!");
		}
		
		if(employee != null && login_pwd.equals(employee.getPwd())) {
			User loginUser = new User(employee);
			
			if(!loginUser.isEnabled()) { //사용 제제(퇴사자)
				throw new DisabledException("퇴사한 상태입니다. 관리자에게 문의바랍니다.");
			}else {
				List<GrantedAuthority> roles=new ArrayList<GrantedAuthority>();
				//사용자에게 권한 부여
				if(loginUser.isAccountNonLocked()) {
					roles.add(new SimpleGrantedAuthority(employee.getAuthority()));
				}else {
					roles.add(new SimpleGrantedAuthority("ROLE_USER"));
				}
				
				//스프링 시큐리티 내부 클래스로 인증 토큰 생성한다.
				UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(employee.getId(),employee.getPwd(),roles);
				//전달할 내용을 설정한 후
				result.setDetails(loginUser);
				
				return result;
			}
		}else {
			//실패시 예외처리
			throw new BadCredentialsException("아이디 혹은 패스워드가 일치하지 않습니다.");
		}
		
	}

	@Override
	public boolean supports(Class<?> arg) {
		/* UsernamePasswordAuthenticationToken 리턴할때
		       파라미터와 같은 레퍼런스인지 비교를 하고 리턴을 한다.
		   default-rarget-url로 전송된다. */
		return arg.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
