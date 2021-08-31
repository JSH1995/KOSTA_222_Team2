
/**
 * @author 김찬원
 * - 검색 결과 관련 DTO
 */

package team2.mvc.model.dto;

public class Search {

	
	private String movieName;
	private String director;
	private String actor1;
	private String actor2;
	private String supactor1;
	private String supactor2;
	private String supactor3;
	private String genre;
	private String nation;
	private String releaseDate;
	private int runtime;
	private double rate;
	
	
	public Search(String movieName, String director, String actor1, String actor2, String supactor1, String supactor2,
			String supactor3, String genre, String nation, String releaseDate, int runtime, double rate) {
		
		this(movieName, director, actor1, actor2, genre, nation, releaseDate, runtime, rate);
		this.supactor1 = supactor1;
		this.supactor2 = supactor2;
		this.supactor3 = supactor3;

	}

	public Search(String movieName, String director, String actor1, String actor2, String genre, String nation, String releaseDate, int runtime, double rate) {
		super();
		this.movieName = movieName;
		this.director = director;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.genre = genre;
		this.nation = nation;
		this.releaseDate = releaseDate;
		this.runtime = runtime;
		this.rate = rate;
	}
		
	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getActor1() {
		return actor1;
	}


	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}


	public String getActor2() {
		return actor2;
	}


	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}
	
	public String getSupactor1() {
		return supactor1;
	}

	public void setSupactor1(String supactor1) {
		this.supactor1 = supactor1;
	}

	public String getSupactor2() {
		return supactor2;
	}

	public void setSupactor2(String supactor2) {
		this.supactor2 = supactor2;
	}

	public String getSupactor3() {
		return supactor3;
	}

	public void setSupactor3(String supactor3) {
		this.supactor3 = supactor3;
	}

	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public int getRuntime() {
		return runtime;
	}


	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| 작품명 : ");
		builder.append(movieName);
		builder.append(" | 감독 : ");
		builder.append(director);
		builder.append(" | 주연 : ");
		builder.append(actor1);
		builder.append(", ");
		builder.append(actor2);
		builder.append(" | 장르 : ");
		builder.append(genre);
		builder.append(" | 국가 : ");
		builder.append(nation);
		builder.append(" | 개봉일자 : ");
		builder.append(releaseDate);
		builder.append(" | 상영시간 : ");
		builder.append(runtime);
		builder.append(" | 평점 : ");
		builder.append((Math.round(rate * 10)) / 10.0);
		builder.append(" |");
		return builder.toString();
	}
	
	
	
	
	
}
