package team.mvc.model.dto;

import java.util.List;

public class MovidDetailDTO {

	private int movieNo;
	private String content;
	private int runtime;
	private String releaseDate;
	private String nation;
	private List<String> userTag;
	
	public MovidDetailDTO() {}

	public MovidDetailDTO(int movieNo, String content, int runtime, String releaseDate, String nation,
			List<String> userTag) {
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

	public List<String> getUserTag() {
		return userTag;
	}

	public void setUserTag(List<String> userTag) {
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
