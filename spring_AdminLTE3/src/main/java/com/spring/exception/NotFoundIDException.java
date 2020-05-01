package com.spring.exception;

public class NotFoundIDException extends Exception {
	
	public NotFoundIDException() {
		super("존재하지 않는 아이디 입니다.");
	}
}
