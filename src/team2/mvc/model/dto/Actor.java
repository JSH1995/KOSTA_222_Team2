package team2.mvc.model.dto;

public class Actor {

	
	private int movieNo;
	private String mainActor1;
	private String mainActor2;
	private String supActor1;
	private String supActor2;
	private String supActor3;
	
	public Actor() {}

	public Actor(int movieNo, String mainActor1, String mainActor2, String supActor1, String supActor2,
			String supActor3) {
		super();
		this.movieNo = movieNo;
		this.mainActor1 = mainActor1;
		this.mainActor2 = mainActor2;
		this.supActor1 = supActor1;
		this.supActor2 = supActor2;
		this.supActor3 = supActor3;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getMainActor1() {
		return mainActor1;
	}

	public void setMainActor1(String mainActor1) {
		this.mainActor1 = mainActor1;
	}

	public String getMainActor2() {
		return mainActor2;
	}

	public void setMainActor2(String mainActor2) {
		this.mainActor2 = mainActor2;
	}

	public String getSupActor1() {
		return supActor1;
	}

	public void setSupActor1(String supActor1) {
		this.supActor1 = supActor1;
	}

	public String getSupActor2() {
		return supActor2;
	}

	public void setSupActor2(String supActor2) {
		this.supActor2 = supActor2;
	} 

	public String getSupActor3() {
		return supActor3;
	}

	public void setSupActor3(String supActor3) {
		this.supActor3 = supActor3;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActorDTO [movieNo=");
		builder.append(movieNo);
		builder.append(", mainActor1=");
		builder.append(mainActor1);
		builder.append(", mainActor2=");
		builder.append(mainActor2);
		builder.append(", supActor1=");
		builder.append(supActor1);
		builder.append(", supActor2=");
		builder.append(supActor2);
		builder.append(", supActor3=");
		builder.append(supActor3);
		builder.append("]");
		return builder.toString();
	}
	
	
}
