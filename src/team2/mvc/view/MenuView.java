package team2.mvc.view;

import java.util.Scanner;
import team2.mvc.controller.CustomerController;
import team2.mvc.controller.MovieController;
import team2.mvc.controller.RecommendController;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.User;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			System.out.println("============= Moviement =============");
			System.out.println("1. 회원가입   |   2. 로그인   |  0. 종료");
			System.out.println("=====================================");

			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				// 회원가입 메서드
				break;
			case 2:
				login();
				// CustomerController.login("admin", "admin");// 로그인
				break;

			case 0:
				System.exit(0);
			}
		}
	}

	public static void login() {
		System.out.print("아이디 : ");
		String userId = sc.nextLine();

		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();

		CustomerController.login(userId, userPwd);
	}

	public static void printUserMenu(User user) {
		System.out.println("--------------------------------------- MAIN MENU ---------------------------------------");
		System.out.println(" 1. 개인정보 수정 |  2. 위시리스트 보기  |  3. 추천 영화 보기  | 4. 검색하기  |  5. 로그아웃  |  0. 종료");
		System.out.println("-----------------------------------------------------------------------------------------");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			printPersonalDetailMenu();
			break;
		case 2:
			printWishListMenu();
			break;
		case 3:
			printRecommendMenu(user);
			break;
		case 4:

			break;
		case 5:

			break;

		case 0:

			break;
		}
	}

	private static void printRecommendMenu(User user) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------- 영화 추천 페이지 ----------------------------");
		System.out.println(" 1. 인기순 추천 |  2. 나이별 추천  |  3. 태그 추천  | 4. 장르 추천  |  0. 메인으로");
		System.out.println("----------------------------------------------------------------------");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			RecommendController.recByRank();
			break;
		case 2:
			RecommendController.recByAge(user.getAge());
			break;
		case 3:
			RecommendController.recByTag(choice, choice);
			break;
		case 4:
			RecommendController.recByGenre(choice, choice);
			break;
		case 0:

			break;
		}


	}

	private static void printWishListMenu(???) {
		System.out.println("------------------- 위시리스트 -------------------");
		
	}

	private static void printPersonalDetailMenu(???) {
		System.out.println("------------------- 개인정보 수정 페이지 -------------------");
		System.out.print("새로운 비밀번호 : ");
		String userId = sc.nextLine();

		System.out.print("새로운 좋아하는 장르 : ");
		String userPwd = sc.nextLine();
		//이런식으로 작성
	}


	public static void printAdminMenu(String userNo) {

	}

	/**
	 * 영화 등록, 수정, 삭제 되는지 확인용입니닷 영화_고유번호, 장르번호, 작품명, 감독, 심의등급, 영화등록일자
	 */

	// 등록
	public static void registerMovie() {

		System.out.print("등록할 작품명 : ");
		String movieName = sc.nextLine();

		System.out.print("감독 :");
		String director = sc.nextLine();

		System.out.print("작품 장르 번호 : ");
		int genreNo = Integer.parseInt(sc.nextLine());

		System.out.print("심의등급 :");
		int rating = Integer.parseInt(sc.nextLine());

		// int movieNo, String movieName, String director, int rating, String
		// movieRegDate, int genreNo
		Movie movie = new Movie(0, movieName, director, rating, null, genreNo);
		MovieController.registerMovie(movie);
	}

	// 수정
	public static void updateMovie() {

		System.out.print("수정할 영화고유번호 입력 : ");
		int movieNo = sc.nextInt();

		System.out.print("작품명 : ");
		String movieName = sc.next();

		System.out.print("작품감독 : ");
		String director = sc.next();

		System.out.print("심의등급 : ");
		int rating = sc.nextInt();

		System.out.print("장르번호 : ");
		int genreNo = sc.nextInt();

		// movie 생성자 인수 : int movieNo, String movieName, String director, int rating,
		// String movieRegDate, int genreNo
		Movie movie = new Movie(movieNo, movieName, director, rating, null, genreNo);
		MovieController.registerMovie(movie);
	}

	// 삭제
	public static void deleteMovie() {
		System.out.println("삭제할 영화의 고유번호 입력 : ");
		int movieNo = Integer.parseInt(sc.nextLine());
		MovieController.deleteMovie(movieNo);
	}

}
