package team2.mvc.exception;

import java.sql.SQLException;

/**
 * DuplicateException Class
 * */
public class DuplicateException extends Exception{
	/**
	 * 중복 체크하는 예외
	 * */
	public DuplicateException() {
		
	}
	/**
	 * 중복 체크하는 예외
	 * @param message
	 * */
	public DuplicateException(String message) {
		super(message);
	}
}
