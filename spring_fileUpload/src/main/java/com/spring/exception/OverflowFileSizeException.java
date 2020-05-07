package com.spring.exception;

public class OverflowFileSizeException extends Exception {

	public OverflowFileSizeException() {
		super("파일 용량이 초과되었습니다.");
	}
}
