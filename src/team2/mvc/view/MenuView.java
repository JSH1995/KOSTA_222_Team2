package team2.mvc.view;

import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import team2.mvc.controller.CustomerController;
import team2.mvc.controller.MovieController;
import team2.mvc.controller.RecommendController;
import team2.mvc.model.dto.Movie;
import team2.mvc.model.dto.User;

import team2.mvc.controller.CustomerController;

public class MenuView {
	private static final Array Array = null;
	private static Scanner sc = new Scanner(System.in);
	
	

	public static void menu() {
		while (true) {
			
		
			
			System.out.println("============= Moviement =============");
			System.out.println("1. 회원가입   |   2. 로그인   |  0. 종료");
			System.out.println("=====================================");

			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				
			//입력한 숫자들을 하나씩 가져옴 12345를 1 2 3 4 5 이런식으로
			/*	while(num > 0) {

					sum += num%10;

					num /= 10;


				}*/ 			
				Calendar cal =Calendar.getInstance();
				
			 	String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
				String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
				String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
				String min = Integer.toString(cal.get(Calendar.MINUTE));
				String sec = Integer.toString(cal.get(Calendar.SECOND));
				String num = month+day+hour+min+sec;
				int usernumber = Integer.parseInt(num) ;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
				String datestr = sdf.format(cal.getTime());
				
				System.out.println("사용하실 아이디를 입력해주세요");
				String id = sc.nextLine();
				
				System.out.println("사용하실 비밀번호를 입력해주세요");
				String pw = sc.nextLine();
				
				System.out.println("나이를 입력해주세요");
				int age = Integer.parseInt(sc.nextLine());
				
				List<String> testList = new ArrayList<String>();
				
				System.out.println("좋아하는 태그를 몇개 입력하시겠습니까?");
			    int teg2 = Integer.parseInt(sc.nextLine());
			    int i=0;
			   
				while(i<teg2){
					System.out.println("좋아하는 태그를 입력해주세요");
					String teg = sc.nextLine();
					testList.add(teg);
					i++;
				}
				int arrListSize = testList.size();
				String arr[] = testList.toArray(new String[arrListSize]);

				int tt=0;
				String tegnum1="";
				while(tt<teg2) {
					tegnum1 = tegnum1+testList.get(tt);
				tt++;
				}
				int tegnum = Integer.parseInt(tegnum1);
				//////
				List<String> testList2 = new ArrayList<String>();
				
				System.out.println("좋아하는 장르를 몇개 입력하시겠습니까?");
			    int jnum2 = Integer.parseInt(sc.nextLine());
			    int j=0;
			   
				while(j<jnum2){
					System.out.println("좋아하는 장르를 입력해주세요");
					String teg = sc.nextLine();
					testList2.add(teg);
					j++;
				}
				int arrListSize2 = testList.size();
				String arr2[] = testList.toArray(new String[arrListSize]);

				int jj=0;
				String jnum1="";
				while(jj<jnum2) {
					jnum1 = jnum1+testList2.get(jj);
				jj++;
				}
				int jnum = Integer.parseInt(jnum1);
				
		
			
				CustomerController.registerUser(usernumber, id, pw, age,datestr,tegnum,jnum); // 가입
				break;
			case 2:
				String login_id= sc.nextLine();
				String login_pw =sc.nextLine();
				CustomerController.login(login_id,login_pw);// 로그인

				break;

			case 0:
				System.exit(0);
			}
		}
	}
	/**
	 * 영화 등록, 수정, 삭제 되는지 확인용입니닷 영화_고유번호, 장르번호, 작품명, 감독, 심의등급, 영화등록일자
	 */

	// 등록
	public static void registerMovie() {

		System.out.print("등록할 작품번호 : ");
		int movieNo = sc.nextInt();

		System.out.print("등록할 작품명 : ");
		String movieName = sc.nextLine();

		System.out.print("감독 :");
		String director = sc.nextLine();

		System.out.print("작품 장르 번호 : ");
		int genreNo = sc.nextInt();

		// int movieNo, String movieName, String director, String movieRegDate, int
		// genreNo
		Movie movie = new Movie(movieNo, movieName, director, null, genreNo);
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
	   	 
	   	 System.out.print("장르번호 : ");
	   	 int genreNo = sc.nextInt();
	   	 
	   	 //movie 생성자 인수 : int movieNo, String movieName, String director, String movieRegDate, int genreNo
	   	 Movie movie =  new Movie(movieNo, movieName, director, null, genreNo);
	   	 MovieController.updateMovie(movie);

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
			printSearchMenu();
			break;
		case 5:

			break;

		case 0:
			System.exit(0);
		}
	}

	public static void printAdminMenu(String userNo) {
		System.out.println("------------------ MAIN MENU -----------------");
		System.out.println(" 1. 개인정보 수정  |  2. 영화 DB 관리하기  |  0. 종료");
		System.out.println("----------------------------------------------");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			printPersonalDetailMenu();
			break;
		case 2:
			printWishListMenu();
			break;
		case 0:
			System.exit(0);
		}
	}

	// 삭제
	public static void deleteMovie() {
		System.out.println("삭제할 영화의 고유번호 입력 : ");
		int movieNo = Integer.parseInt(sc.nextLine());
		MovieController.deleteMovie(movieNo);
	}
	
	//로그인
	public static void login() {
		System.out.print("아이디 : ");
		String userId = sc.nextLine();

		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();

		CustomerController.login(userId, userPwd);
	}
	
	/*
	 * 메뉴 - 1. 개인정보 수정
	 */
	private static void printPersonalDetailMenu(???) {
		System.out.println("------------------- 개인정보 수정 페이지 -------------------");
		System.out.print("새로운 비밀번호 : ");
		String userId = sc.nextLine();

		System.out.print("새로운 좋아하는 장르 : ");
		String userPwd = sc.nextLine();
		//이런식으로 작성
	}
	
	/*
	 * 메뉴 - 2. 위시리스트 보기
	 */
	private static void printWishListMenu(???) {
		System.out.println("------------------- 위시리스트 -------------------");
		
	}
	
	/*
	 * 메뉴 - 3. 추천 영화 보기
	 */
	private static void printRecommendMenu(User user) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------- 영화 추천 페이지 ----------------------------");
		System.out.println(" 1. 인기순 추천 |  2. 나이별 추천  |  3. 태그 추천  | 4. 장르 추천  |  0. 메인으로");
		System.out.println("----------------------------------------------------------------------");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			System.out.println("----- 인기순추천 -----");
			RecommendController.recByRank();
			break;
		case 2:
			System.out.println("----- 나이별 추천 -----");
			RecommendController.recByAge(user.getAge());
			break;
		case 3:
			System.out.println("----- 태그 추천 -----");
			RecommendController.recByTag(choice, choice);
			break;
		case 4:
			System.out.println("----- 장르 추천 -----");
			RecommendController.recByGenre(choice, choice);
			break;
		case 0:

			break;
		}
	}
	/*
	 * 메뉴 - 4. 검색하기
	 */
	private static void printSearchMenu() {
		// TODO Auto-generated method stub
		System.out.println("---------------------------- 영화 추천 페이지 ----------------------------");
		System.out.println(" 1. 전체검색 |  2. 작품명 검색  |...");
		System.out.println("----------------------------------------------------------------------");
	}
}
