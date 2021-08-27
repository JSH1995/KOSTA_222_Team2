package team2.mvc.model.dto;

import java.util.List;

public class WishList {
	
	private int userNo;
	private List<Integer> movieNo;
	
	public WishList() {}

	public WishList(int userNo, List<Integer> movieNo) {
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

	public List<Integer> getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(List<Integer> movieNo) {
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
