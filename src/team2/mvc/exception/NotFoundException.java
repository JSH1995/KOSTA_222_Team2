package team2.mvc.exception;

import java.sql.SQLException;

/**
 * NotFoundException Class
 * */
public class NotFoundException extends Exception {
	
	/**
	 * 리턴값이 없는 경우 예외
	 * */
	public  NotFoundException() {
	}
	/**
	 * 리턴값이 없는 경우 예외
	 * @param message
	 * */
	public NotFoundException(String message) {
		super(message);
	}

}

