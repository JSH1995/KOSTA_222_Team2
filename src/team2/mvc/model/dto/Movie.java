package team2.mvc.model.dto;

public class Movie {
	private int movieNo;
	private String movieName;
	private String director;
	private String movieRegDate;
	private int genreNo;
	
	public Movie() {}
	public Movie(int movieNo, int genreNo, String movieName, String director, String movieRegDate) {
		super();
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.director = director;
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
		return "[작품명: "+ movieName + ", " + director + "]";
	}
	
	
	
	
	
	
	
	 

}
