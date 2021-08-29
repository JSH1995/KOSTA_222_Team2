package team2.mvc.exception;

public class DuplicateException extends Exception{
	public DuplicateException() {
		
	}
	
	public DuplicateException(String message) {
		super(message);
	}
}
