package com.groupware.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.groupware.dto.EmployeeVO;

public class User implements UserDetails {

	private EmployeeVO member;
	
	
	public User() {}
	public User(EmployeeVO member) {
		super();
		this.member = member;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		return member.getPwd();
	}
	@Override
	public String getUsername() {
		return member.getId();
	}
	@Override
	public boolean isAccountNonExpired() { //기간제 계정의 경우 기간만료 여부
		return true;
	}
	@Override
	public boolean isAccountNonLocked() { //사용 제제 여부 : 휴직
		boolean result=true;
		if(member.getEnabled()>1) result=false;
		return result;
	}
	@Override
	public boolean isCredentialsNonExpired() { //인증정보 만료 여부(패스워드 만료)
		return true;
	}
	@Override
	public boolean isEnabled() {//휴면계정 여부 : 퇴사
		boolean result=true;
		if(member.getEnabled()==0) result=false;
		return result;
	}
	
	public EmployeeVO getMemberVO() {
		return this.member;
	}
	
}
