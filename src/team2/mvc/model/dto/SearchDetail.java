/**
 * @author 김찬원
 * - 상세 검색결과 관련 DTO
 */


package team2.mvc.model.dto;

import java.util.List;

public class SearchDetail extends Search  {
	
	private String content;
	private List<String> userTag;

	public SearchDetail(String movieName, String director, String actor1, String actor2, String supactor1,
			String supactor2, String supactor3, String genre, String nation, String releaseDate, int runtime,
			int rate) {
		super(movieName, director, actor1, actor2, supactor1, supactor2, supactor3, genre, nation, releaseDate, runtime, rate);
	}

	public SearchDetail(String movieName, String director, String actor1, String actor2, String supactor1,
			String supactor2, String supactor3, String genre, String nation, String releaseDate, int runtime, int rate,
			String content, List<String> userTag) {
		super(movieName, director, actor1, actor2, supactor1, supactor2, supactor3, genre, nation, releaseDate, runtime,
				rate);
		this.content = content;
		this.userTag = userTag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getUserTag() {
		return userTag;
	}

	public void setUserTag(List<String> userTag) {
		this.userTag = userTag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchDetail [content=");
		builder.append(content);
		builder.append(", userTag=");
		builder.append(userTag);
		builder.append(", getMovieName()=");
		builder.append(getMovieName());
		builder.append(", getDirector()=");
		builder.append(getDirector());
		builder.append(", getActor1()=");
		builder.append(getActor1());
		builder.append(", getActor2()=");
		builder.append(getActor2());
		builder.append(", getGenre()=");
		builder.append(getGenre());
		builder.append(", getNation()=");
		builder.append(getNation());
		builder.append(", getReleaseDate()=");
		builder.append(getReleaseDate());
		builder.append(", getRuntime()=");
		builder.append(getRuntime());
		builder.append(", getRate()=");
		builder.append(getRate());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}
	
	


	
	
}
