package team2.mvc.model.dto;

import java.util.List;
/**
 * 위시리스트 결과 관련 클래스
 */

public class WishList {
	
	private int userNo;
	private int movieNo;
	
	public WishList() {}

	public WishList(int userNo, int movieNo) {
		super();
		this.userNo = userNo;
		this.movieNo = movieNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WishList [userNo=");
		builder.append(userNo);
		builder.append(", movieNo=");
		builder.append(movieNo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
