/**
 * @author 김찬원
 * - 상세 검색결과 관련 DTO
 */


package team2.mvc.model.dto;

import java.util.List;

public class SearchDetail extends Search  {
	
	private String content;
	private String userTag;
	private String comment;

	public SearchDetail(String movieName, String director, String actor1, String actor2, String supactor1,
			String supactor2, String supactor3, String genre, String nation, String releaseDate, int runtime,
			double rate) {
		super(movieName, director, actor1, actor2, supactor1, supactor2, supactor3, genre, nation, releaseDate, runtime, rate);
	}

	public SearchDetail(String movieName, String director, String actor1, String actor2, String supactor1,
			String supactor2, String supactor3, String genre, String nation, String releaseDate, int runtime, double rate,
			String content, String userTag, String comment) {
		super(movieName, director, actor1, actor2, supactor1, supactor2, supactor3, genre, nation, releaseDate, runtime,
				rate);
		this.content = content;
		this.userTag = userTag;
		this.comment = comment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserTag() {
		
		return userTag;
	}

	public void setUserTag(String userTag) {		
		this.userTag = userTag;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		
		if(userTag == null) {
			userTag = "사용자 태그가 등록되지 않은 영화 입니다. 태그 등록을 통해 태그를 등록해 보세요~!! ";
		}
			
		StringBuilder builder = new StringBuilder();
		builder.append("============================== 영화 상세 정보 ==============================" + "\n");
		builder.append("작품명 : ");
		builder.append(getMovieName());
		builder.append(" | 평점 : ");
		builder.append((Math.round(getRate() * 10)) / 10.0);
		builder.append("\n");
		builder.append("장르 : ");
		builder.append(getGenre());
		builder.append(" | 국가 : ");
		builder.append(getNation());
		builder.append(" | 개봉일자 : ");
		builder.append(getReleaseDate());
		builder.append(" | 상영시간 : ");
		builder.append(getRuntime());
		builder.append("\n");
		builder.append("감독 :");
		builder.append(getDirector());
		builder.append("\n");
		builder.append("주연 : ");
		builder.append(getActor1());
		builder.append(", ");
		builder.append(getActor2());
		builder.append("\n" + "조연 : ");
		builder.append(getSupactor1());
		builder.append(", ");
		builder.append(getSupactor2());
		builder.append(", ");
		builder.append(getSupactor3());
		builder.append("\n");
		builder.append("\n" + "==================== 줄거리 ====================" +"\n");
		builder.append(content);
		builder.append("\n" + "==================== 유저들이 입력한 관련 태그 ====================" +"\n");
		builder.append(userTag);
		builder.append("\n" + "==================== 유저 코멘트 ====================" +"\n");
		builder.append(comment);

		return builder.toString();
	}
	
}
