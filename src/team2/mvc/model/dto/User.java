package team2.mvc.model.dto;

import java.sql.Array;

public class User {
	/**
	 * 사용자 관련 클래스
	 */

	private int userNo;
	private String id;
	private String password;
	private int age;
	private String userRegDate;
	private int favTag;
	private int favGenre;
	
	
	public User(String id,String password) {
		this.id = id;
		this.password = password;
		
	}

	public User(int userNo,String id,String password, int age, String userRegDate,int favTag, int favGenre
			) {
		this(id,password);
		this.userNo = userNo;
		this.age = age;
		this.userRegDate = userRegDate;
		this.favTag = favTag;
		this.favGenre = favGenre;
		
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
	public int getFavTag() {
		return favTag;
	}

	public void setFavTag(int favTag) {
		this.favTag = favTag;
	}
	public int getFavGenre() {
		return favGenre;
	}

	public void setFavGenre(int favGenre) {
		this.favGenre = favGenre;
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
		builder.append(", favTag=");
		builder.append(favTag);
		builder.append(", favGenre=");
		builder.append(favGenre);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
