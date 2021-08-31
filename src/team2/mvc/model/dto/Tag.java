package team2.mvc.model.dto;

public class Tag {
	/**
	 * 영화의 배우 결과 관련 클래스
	 */
	
	private int movieNo;
	private int tagNo;
	
	public Tag(){		
	}

	public Tag(int movieNo, int tagNo) {
		super();
		this.movieNo = movieNo;
		this.tagNo = tagNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public int getTagNo() {
		return tagNo;
	}

	public void setTagNo(int tagNo) {
		this.tagNo = tagNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tag [movieNo=");
		builder.append(movieNo);
		builder.append(", tagNo=");
		builder.append(tagNo);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
