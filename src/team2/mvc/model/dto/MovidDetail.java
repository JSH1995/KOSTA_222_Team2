package team2.mvc.model.dto;
/**
 * 영화의 상세 정보 결과 관련 클래스
 */

import java.util.List;

public class MovidDetail {

	private int movieNo;
	private String content;
	private int runtime;
	private String releaseDate;
	private String nation;
	private String userTag;
	
	public MovidDetail() {}

	public MovidDetail(int movieNo, String content, int runtime, String releaseDate, String nation,
			String userTag) {
		super();
		this.movieNo = movieNo;
		this.content = content;
		this.runtime = runtime;
		this.releaseDate = releaseDate;
		this.nation = nation;
		this.userTag = userTag;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getReleaseDate() {
		return releaseDate;
	} 

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getUserTag() {
		return userTag;
	}

	public void setUserTag(String userTag) {
		this.userTag = userTag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MovidDetailDTO [movieNo=");
		builder.append(movieNo);
		builder.append(", content=");
		builder.append(content);
		builder.append(", runtime=");
		builder.append(runtime);
		builder.append(", releaseDate=");
		builder.append(releaseDate);
		builder.append(", nation=");
		builder.append(nation);
		builder.append(", userTag=");
		builder.append(userTag);
		builder.append("]");
		return builder.toString();
	}
	
	
}
