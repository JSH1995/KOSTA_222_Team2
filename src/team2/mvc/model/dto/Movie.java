package team2.mvc.model.dto;

public class Movie {
	private int movieNo;
	private String movieName;
	private String director;
	private int rating;
	private String movieRegDate;
	private int genreNo;
	
	public Movie() {}
	public Movie(int movieNo, String movieName, String director, int rating, String movieRegDate, int genreNo) {
		super();
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.director = director;
		this.rating = rating;
		this.movieRegDate = movieRegDate;
		this.genreNo = genreNo;
	}
	
	
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMovieRegDate() {
		return movieRegDate;
	}
	public void setMovieRegDate(String movieRegDate) {
		this.movieRegDate = movieRegDate;
	}
	public int getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MovieDTO [movieNo=");
		builder.append(movieNo);
		builder.append(", movieName=");
		builder.append(movieName);
		builder.append(", director=");
		builder.append(director);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", movieRegDate=");
		builder.append(movieRegDate);
		builder.append(", genreNo=");
		builder.append(genreNo);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	 

}
