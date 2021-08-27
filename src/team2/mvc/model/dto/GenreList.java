package team2.mvc.model.dto;

public class GenreList {
	private int genreNo;
	private String genreName;

	public GenreList() {
	}

	public GenreList(int genreNo, String genreName) {
		super();
		this.genreNo = genreNo;
		this.genreName = genreName;
	}

	public int getGenreNo() {
		return genreNo;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GenreListDTO [genreNo=");
		builder.append(genreNo);
		builder.append(", genreName=");
		builder.append(genreName);
		builder.append("]");
		return builder.toString();
	}

}
