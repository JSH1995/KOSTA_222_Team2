package dto;

public class EvaluationDTO {
	private int userNo;
	private int movieNo;
	private int rate;
	private String comment;
	private String rateDate;

	public EvaluationDTO() {
	}

	public EvaluationDTO(int userNo, int movieNo, int rate, String comment, String rateDate) {
		super();
		this.userNo = userNo;
		this.movieNo = movieNo;
		this.rate = rate;
		this.comment = comment;
		this.rateDate = rateDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public int getRate() {
		return rate;
	}

	public String getComment() {
		return comment;
	}

	public String getRateDate() {
		return rateDate;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setRateDate(String rateDate) {
		this.rateDate = rateDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EvaluationDTO [userNo=");
		builder.append(userNo);
		builder.append(", movieNo=");
		builder.append(movieNo);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", rateDate=");
		builder.append(rateDate);
		builder.append("]");
		return builder.toString();
	}

}
