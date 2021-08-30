package team2.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import team2.mvc.model.dto.Movie;
import team2.mvc.model.service.RecommendService;

public class RecommendController {
	static RecommendService recommendService = new RecommendService();

	/**
	 * 해당 나이대에 가장 많이 위시리스트에 담긴 영화를 추천 
	 * @param age
	 */
	public static void recByAge(int age) {
		try {
			List<Movie> list = recommendService.recByAge(age);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void recByRank() {
		try {
			List<Movie> list = recommendService.recByRank();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void recByGenre(int userNo) {
		try {
			List<Movie> list = recommendService.recByGenre(userNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void recByTag(int userNo, int tagNo) {
		try {
			List<Movie> list = recommendService.recByTag(userNo, tagNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		recByAge(10);
	}
}
