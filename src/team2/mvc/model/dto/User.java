package team2.mvc.model.dto;

public class User {

	private int userNo;
	private String id;
	private String password;
	private int age;
	private String userRegDate;
	private String[] favGenre;
	private String[] favTag;
	
	public User(String id,String password) {
		this.id = id;
		this.password = password;
		
	}

	public User(int userNo,String id,String password, int age, String userRegDate, String[] favGenre,
			String[] favTag) {
		this(id,password);
		this.userNo = userNo;
		this.age = age;
		this.userRegDate = userRegDate;
		this.favGenre = favGenre;
		this.favTag = favTag;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserRegDate() {
		return userRegDate;
	}

	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}

	public String[] getFavGenre() {
		return favGenre;
	}

	public void setFavGenre(String[] favGenre) {
		this.favGenre = favGenre;
	}

	public String[] getFavTag() {
		return favTag;
	}

	public void setFavTag(String[] favTag) {
		this.favTag = favTag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [userNo=");
		builder.append(userNo);
		builder.append(", id=");
		builder.append(id);
		builder.append(", password=");
		builder.append(password);
		builder.append(", age=");
		builder.append(age);
		builder.append(", userRegDate=");
		builder.append(userRegDate);
		builder.append(", favGenre=");
		builder.append(favGenre);
		builder.append(", favTag=");
		builder.append(favTag);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
