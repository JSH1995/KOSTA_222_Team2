package team.mvc.model.dto;

import java.util.Set;

public class User {

	private int userNo;
	private String id;
	private String password;
	private int age;
	private String userRegDate;
	private Set<String> favGenre;
	private Set<String> favTag;
	
	public User() {}

	public User(int userNo, String id, String password, int age, String userRegDate, Set<String> favGenre,
			Set<String> favTag) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.password = password;
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

	public Set<String> getFavGenre() {
		return favGenre;
	}

	public void setFavGenre(Set<String> favGenre) {
		this.favGenre = favGenre;
	}

	public Set<String> getFavTag() {
		return favTag;
	}

	public void setFavTag(Set<String> favTag) {
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
