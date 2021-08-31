package team2.mvc.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import team2.mvc.controller.CustomerController;
import team2.mvc.controller.MovieController;
import team2.mvc.controller.RecommendController;
import team2.mvc.controller.SearchController;
import team2.mvc.controller.WishController;
import team2.mvc.model.dto.Actor;
import team2.mvc.model.dto.MovidDetail;
import team2.mvc.model.dto.Search;
import team2.mvc.model.dto.Tag;
import team2.mvc.model.dto.User;
import team2.mvc.util.DbUtil;

public class MenuView {
	static User user;
	static String user_id;
	static String user_pw;
	static boolean logincheck;
	private static Scanner sc = new Scanner(System.in);
	private static Set<String> keywordList = new HashSet<String>();

	public static void menu() {

		while (true) {

			System.out.println("============= Moviement =============");
			System.out.println("1. 회원가입   |   2. 로그인   |  0. 종료");
			System.out.println("=====================================");

			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:

				Calendar cal = Calendar.getInstance();

				String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
				String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
				String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
				String min = Integer.toString(cal.get(Calendar.MINUTE));
				String sec = Integer.toString(cal.get(Calendar.SECOND));
				String num = month + day + hour + min + sec;
				int usernumber = Integer.parseInt(num);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
				String datestr = sdf.format(cal.getTime());

				System.out.print("사용하실 아이디를 입력해주세요: ");
				String id = sc.nextLine();

				System.out.print("사용하실 비밀번호를 입력해주세요: ");
				String pw = sc.nextLine();

				System.out.print("나이를 입력해주세요: ");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println(" 1.  시간 |  2.  외계인  |  3.  우주  | 4.  고전  | 5.  복수 | 6.  패션  | 7.  미래적인  | 8.  편견을 깨는 | 9.  독립 ");
				System.out.println(" 10. 시간 |  11. 외계인  |  13. 우주  | 14. 고전  | 15. 복수 | 16. 패션  | 17. 미래적인  | 18. 편견을 깨는 | 19. 독립 ");
				System.out.println(" 20. 시간 |  21. 외계인  |  22. 우주  | 23. 고전  | 24. 복수 | 25. 패션  | 26. 미래적인  | 27. 편견을 깨는 | 28. 독립 ");
				System.out.println(" 1. 시간 |  2. 외계인  |  3. 우주  | 4. 고전  | 5. 복수 | 6. 패션  | 7. 미래적인  | 8. 편견을 깨는 | 9. 독립 ");
				System.out.println(" 1. 시간 |  2. 외계인  |  3. 우주  | 4. 고전  | 5. 복수 | 6. 패션  | 7. 미래적인  | 8. 편견을 깨는 | 9. 독립 ");

				System.out.print("좋아하는 태그를 입력해주세요: ");

				int tegnum = Integer.parseInt(sc.nextLine());
				System.out.println(
						"  1. 드라마 |  2. 스릴러  |  3. 범죄  | 4. 로맨스  | 5. 액션 | 6. 다큐멘터리  | 7. 애니메이션  | 8. 코미디 | 9. 공포  | 10. SF ");
				System.out.print("좋아하는 장르를 입력해주세요: ");
				int jnum = Integer.parseInt(sc.nextLine());

				CustomerController.registerUser(usernumber, id, pw, age, datestr, tegnum, jnum); // 가입
				break;
			case 2:
				System.out.print("아이디를 입력해주세요: ");
				String login_id = sc.nextLine();
				user_id = login_id;
				System.out.print("비밀번호를 입력해주세요: ");
				String login_pw = sc.nextLine();
				user_pw = login_pw;

				Connection con = null;
				Statement st = null;
				ResultSet rs = null;

				try {
					con = DbUtil.getConnection();
					st = con.createStatement();
					rs = st.executeQuery("select * from 사용자 where 아이디 ='" + user_id + "' and 비밀번호 = '" + user_pw + "'");
					while (rs.next()) {
						int user_num = rs.getInt(1);
						String u_id = rs.getString(2);
						String u_pw = rs.getString(3);
						int u_age = rs.getInt(4);
						String u_regdate = rs.getString(5);
						int u_favgenre = rs.getInt(6);
						int u_favtag = rs.getInt(7);

						user = new User(user_num, u_id, u_pw, u_age, u_regdate, u_favgenre, u_favtag);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DbUtil.dbClose(con, st, rs);
				}

				logincheck = CustomerController.login(login_id, login_pw);// 로그인
				if (login_id.equals("admin")) {
					System.out.println("1. 메인 메뉴  |  2. 관리자 메뉴");
					int choice2 = Integer.parseInt(sc.nextLine());
					switch (choice2) {
					case 1:
						printUserMenu();
						break;
					case 2:
						adminMenu();
						break;
					case 0:
						System.exit(0);
					}
				} else
					printUserMenu();
				break;

			case 0:
				System.exit(0);
			}
		}
	}

	public static void printUserMenu() {
		while (logincheck) {
			System.out.println(
					"========================================= MAIN MENU =========================================");
			System.out.println(" 1. 개인정보 수정 |  2. 위시리스트 보기  |  3. 추천 영화 보기  | 4. 검색하기  | 5. 최근 검색 리스트 | 0. 종료");
			System.out.println(
					"=============================================================================================");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				printPersonalDetailMenu();
				break;
			case 2:
				printWishListMenu(user.getUserNo());
				break;
			case 3:
				printRecommendMenu(user);
				break;
			case 4:
				printSearchMenu();
				break;
			case 5:
				showRecentSearchList();
				break;
			case 0:
				System.exit(0);

			}
		}

	}

	// 로그인
	public static void login() {
		System.out.print("아이디: ");
		String userId = sc.nextLine();

		System.out.print("비밀번호: ");
		String userPwd = sc.nextLine();

		CustomerController.login(userId, userPwd);
	}

	/**
	 * @author 조성휘
	 * 사용자메뉴 - 1. 개인정보 수정
	 */
	private static void printPersonalDetailMenu() {
		System.out.println("========= 개인정보 수정 페이지 =========");
		System.out.print("새로운 비밀번호를 입력해주세요: ");
		String pw1 = sc.nextLine();
		CustomerController.update_pw(user.getUserNo(), pw1);
	}

	/**
	 * @author 홍전형
	 * 사용자메뉴 - 2. 위시리스트 보기
	 */
	private static void printWishListMenu(int userNo) {
		System.out.println(user.getId() + "님의 위시리스트입니다");
		WishController.viewWishList(user.getUserNo());

	}

	/**
	 * @author 홍전형 
	 * 사용자메뉴 - 3. 추천 영화 보기
	 */
	private static void printRecommendMenu(User user) {
		// TODO Auto-generated method stub
		System.out.println("============================ 영화 추천 페이지 ============================");
		System.out.println(" 1. 인기순 추천 |  2. 나이별 추천  |  3. 태그 추천  | 4. 장르 추천  |  0. 메인메뉴");
		System.out.println("======================================================================");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			System.out.println("- 인기순 추천 -");
			System.out.println("현재 위시리스트에 가장 많이 담긴 영화들이에요!\n");
			RecommendController.recByRank();
			break;
		case 2:
			System.out.println("- 나이별 추천 -");
			System.out.println((int) user.getAge() / 10 * 10 + "대의 위시리스트에 가장 많이 담긴 영화들이에요!\n");
			RecommendController.recByAge(user.getAge());
			break;
		case 3:
			System.out.println("- 태그 추천 -");
			System.out.println(user.getId() + "님이 좋아하는 영화의 태그를 기반으로 영화를 추천해드릴게요!\n");

			RecommendController.recByTag(user.getUserNo());
			break;
		case 4:
			System.out.println("- 장르 추천 -");
			System.out.println(user.getId() + "님이 좋아하는 영화의 장르를 기반으로 영화를 추천해드릴게요!\n");
			RecommendController.recByGenre(user.getUserNo());
			break;
		case 0:
			return;
		}
	}

	/**
	 * @author 김찬원 
	 * -- 사용자메뉴 - 4. 검색하기
	 */
	private static void printSearchMenu() {

		while (true) {

			System.out.println(
					"======================================= 검색 메뉴 =======================================================================");
			System.out.println(
					"1. 전체 검색 | 2. 작품명 검색 | 3. 감독별 검색 | 4. 배우별 검색 | 5. 장르별 검색 | 6. 국가별 검색 | 7. 상세 정보 확인 | 8. 뒤로가기 | 9. 메인 메뉴 |");
			System.out.println(
					"======================================================================================================================");

			int choice = Integer.parseInt(sc.nextLine());
			String sortType = "작품명";
			String movieName;
			String director;
			String actor;
			String genre;
			String nation;

			switch (choice) {
			case 1:
				if (SearchController.searchAll(sortType)) {
					sortType = sort();
					SearchController.searchAll(sortType);
				}
				break;
			case 2:
				movieName = insertKeyword();
				if (SearchController.searchByName(movieName, sortType)) {
					sortType = sort();
					SearchController.searchByName(movieName, sortType);
				}
				break;
			case 3:
				director = insertKeyword();
				if (SearchController.searchByDirector(director, sortType)) {
					sortType = sort();
					SearchController.searchByDirector(director, sortType);
				}
				break;
			case 4:
				actor = insertKeyword();
				if (SearchController.searchByActor(actor, sortType)) {
					sortType = sort();
					SearchController.searchByActor(actor, sortType);
				}
				break;
			case 5:
				genre = insertKeyword();
				if (SearchController.searchByGenre(genre, sortType)) {
					sortType = sort();
					SearchController.searchByGenre(genre, sortType);
				}
				break;
			case 6:
				nation = insertKeyword();
				if (SearchController.searchByNation(nation, sortType)) {
					sortType = sort();
					SearchController.searchByNation(nation, sortType);
				}
				break;
			case 7:
				movieDetail();
				break;
			case 8:
				return;
			case 9:
				login();
			default:
				System.out.println("숫자를 누르거라.");
				break; // 문자나 다른거 입력 시 Exception 처리 필요

			}
		}

	}

	/**
	 * @author 김찬원 - 검색한 결과를 정렬 시켜주는 메소드
	 */

	private static String sort() {

		String sortType = null;

		System.out.println("================== 검색하신 결과에 대해 정렬을 할 수 있습니다. ====================");
		System.out.println("=============================== 정렬 메뉴 ================================");
		System.out.println("1. 작품명 | 2. 상영시간 | 3. 개봉일자 | 4. 평점 |");
		System.out.println("=======================================================================");

		int choice = Integer.parseInt(sc.nextLine());

		switch (choice) {
		case 1:
			sortType = "작품명";
			break;
		case 2:
			sortType = "상영시간";
			break;
		case 3:
			sortType = "개봉일자";
			break;
		case 4:
			sortType = "AVG(평점) DESC";
			break;
		default:
			System.out.println("숫자를 누르거라.");
			break;// 문자나 다른거 입력 시 Exception 처리 필요

		}

		return sortType;

	}

	/**
	 * @author 김찬원 - 검색 키워드 입력하는 메소드
	 */

	private static String insertKeyword() {

		System.out.println("==========검색하실 키워드를 입력해 주세요.==========");
		System.out.print("키워드 : ");
		String keyword = sc.nextLine();
		keywordList.add(keyword);

		return keyword;
	}

	/**
	 * @author 김찬원 최근 검색 키워드를 보여주는 리스트
	 */

	private static void showRecentSearchList() {

		System.out.println("========================= 최근 검색 키워드 리스트 ========================");
		System.out.println(
				"=======================최근 검색 한 키워드 수 : " + keywordList.size() + "개 ======================" + "\n");

		Iterator<String> it = keywordList.iterator();

		while (it.hasNext()) {

			String keyword = it.next();
			System.out.println(keyword);
		}

	}

	/**
	 * 영화, 영화상세정보, 태그, 배우 등록 수정 삭제
	 */

	static String date1 = "";

	/**
	 * @author 이치인 영화 등록 수정 삭제
	 */
	// 영화 등록
	public static void adminMenu() {

		System.out.println("========================== 관리자 메뉴 입니다. ===========================");
		System.out.println("=============================== 정렬 메뉴 ================================");
		System.out.println("1. 영화등록 | 2. 영화수정 | 3. 영화삭제 | 4. 배우등록 | 5. 배우수정 | 6. 배우삭제 |");
		System.out.println(
				"================================================================================================");
		System.out.println("7. 태그등록 | 8. 태그수정 | 9. 태그삭제 | 10. 영화상세등록 | 11. 영화상세수정 | 12. 영화상세삭제 |");
		System.out.println(
				"===================================================================================================");

		int choice = Integer.parseInt(sc.nextLine());

		switch (choice) {
		case 1:
			registerMovie();
			break;
		case 2:
			updateMovie();
			break;
		case 3:
			deleteMovie();
			break;
		case 4:
			registerActor();
			break;
		case 5:
			updateActor();
			break;
		case 6:
			deleteActor();
			break;
		case 7:
			registerTag();
			break;
		case 8:
			updateTag();
			break;
		case 9:
			deleteTag();
			break;
		case 10:
			registerMovieDetail();
			break;
		case 11:
			updateMovieDetail();
			break;
		case 12:
			deleteMovieDetail();
			break;

		default:

			break;// 문자나 다른거 입력 시 Exception 처리 필요

		}

	}

	public static void registerMovie() {

		System.out.print("등록할 영화고유번호 입력 : ");
		int movieNo = Integer.parseInt(sc.nextLine());

		System.out.print("장르번호 등록 : ");
		int genreNo = Integer.parseInt(sc.nextLine());

		System.out.print("작품명 등록 : ");
		String movieName = sc.nextLine();

		System.out.print("작품감독 등록 : ");
		String director = sc.nextLine();

		MovieController.registerMovie(movieNo, genreNo, movieName, director, date1);
	}

	// 영화 수정
	public static void updateMovie() {

		System.out.print("수정할 영화고유번호 입력 : ");
		int movieNo = Integer.parseInt(sc.nextLine());

		System.out.print("장르번호 수정 : ");
		int genreNo = Integer.parseInt(sc.nextLine());

		System.out.print("작품명 수정 : ");
		String movieName = sc.nextLine();

		System.out.print("작품감독 수정 : ");
		String director = sc.nextLine();

		MovieController.updateMovie(movieNo, genreNo, movieName, director, date1);
	}

	// 영화 삭제
	public static void deleteMovie() {
		System.out.print("삭제할 영화의 고유번호 입력 : ");
		int movieNo = Integer.parseInt(sc.nextLine());
		MovieController.deleteMovie(movieNo);
	}

	/**
	 * 배우 등록 수정 삭제
	 */
	// 배우 등록
	public static void registerActor() {

		System.out.print("해당 작품번호 : ");
		int movieNo = Integer.parseInt(sc.nextLine());

		System.out.print("주연1 : ");
		String mainActor1 = sc.nextLine();

		System.out.print("주연2 : ");
		String mainActor2 = sc.nextLine();

		System.out.print("조연1 : ");
		String supActor1 = sc.nextLine();

		System.out.print("조연2 : ");
		String supActor2 = sc.nextLine();

		System.out.print("조연3 : ");
		String supActor3 = sc.nextLine();

		Actor actor = new Actor(movieNo, mainActor1, mainActor2, supActor1, supActor2, supActor3);
		MovieController.registerActor(actor);
	}

	// 배우 수정
	public static void updateActor() {

		System.out.print("수정할 해당 작품번호 : ");
		int movieNo = Integer.parseInt(sc.nextLine());

		System.out.print("주연1 : ");
		String mainActor1 = sc.nextLine();

		System.out.print("주연2 : ");
		String mainActor2 = sc.nextLine();

		System.out.print("조연1 : ");
		String supActor1 = sc.nextLine();

		System.out.print("조연2 : ");
		String supActor2 = sc.nextLine();

		System.out.print("조연3 : ");
		String supActor3 = sc.nextLine();

		Actor actor = new Actor(movieNo, mainActor1, mainActor2, supActor1, supActor2, supActor3);
		MovieController.updateActor(actor);
	}

	// 배우 삭제
	public static void deleteActor() {
		System.out.print("삭제할 영화의 고유번호 입력 : ");
		int movieNo = Integer.parseInt(sc.nextLine());
		MovieController.deleteActor(movieNo);
	}

	/**
	 * 태그 등록 수정 삭제
	 */
	// 태그 등록
	public static void registerTag() {

		System.out.print("등록할 작품번호 : ");
		int movieNo = Integer.parseInt(sc.nextLine());

		System.out.print("등록할 태그 : ");
		int tagNo = Integer.parseInt(sc.nextLine());

		Tag tag = new Tag(movieNo, tagNo);
		MovieController.registerTag(tag);
	}

	// 태그 수정
	public static void updateTag() {

		System.out.print("태그 변경할 작품번호 : ");
		int movieNo = Integer.parseInt(sc.nextLine());

		System.out.print("수정할 태그 : ");
		int tagNo = Integer.parseInt(sc.nextLine());

		Tag tag = new Tag(movieNo, tagNo);
		MovieController.updateTag(tag);
	}

	// 태그 삭제
	public static void deleteTag() {
		System.out.print("삭제할 영화의 고유번호 입력 : ");
		int movieNo = Integer.parseInt(sc.nextLine());
		MovieController.deleteTag(movieNo);
	}

	/**
	 * 영화_상세 등록 수정 삭제
	 */
	// 영화_상세 등록
	public static void registerMovieDetail() {

		System.out.print("새롭게 등록할 작품번호 : ");
		int movieNo = Integer.parseInt(sc.nextLine());

		System.out.print("줄거리 : ");
		String content = sc.nextLine();

		System.out.print("런타임 : ");
		int runtime = Integer.parseInt(sc.nextLine());

		System.out.print("개봉일자 : ");
		String releaseDate = sc.nextLine();

		System.out.print("국가 : ");
		String nation = sc.nextLine();

		System.out.print("사용자 지정 태그 : ");
		String userTag = sc.nextLine();

		// int movieNo, String content, int runtime, String releaseDate, String nation,
		// List<String> userTag
		MovidDetail movieDetail = new MovidDetail(movieNo, content, runtime, releaseDate, nation, userTag);
		MovieController.registerMovieDetail(movieDetail);
	}

	// 영화_상세 내용 수정
	public static void updateMovieDetail() {

		System.out.print("수정할 작품번호 : ");
		int movieNo = Integer.parseInt(sc.nextLine());

		System.out.print("줄거리 수정 : ");
		String content = sc.nextLine();

		System.out.print("런타임 수정 : ");
		int runtime = Integer.parseInt(sc.nextLine());

		System.out.print("개봉일자 수정 : ");
		String releaseDate = sc.nextLine();

		System.out.print("국가 수정 : ");
		String nation = sc.nextLine();

		System.out.print("사용자 지정 태그 수정 : ");
		String userTag = sc.nextLine();

		MovidDetail movieDetail = new MovidDetail(movieNo, content, runtime, releaseDate, nation, userTag);
		MovieController.updateMovieDetail(movieDetail);
	}

	// 영화_상세 정보 삭제
	public static void deleteMovieDetail() {
		System.out.print("삭제를 원하는 영화상세정보에 해당하는 영화고유번호 입력 : ");
		int movieNo = Integer.parseInt(sc.nextLine());
		MovieController.deleteMovieDetail(movieNo);
	}

	public static void userComment(int movienum) {
		Calendar cal2 = Calendar.getInstance();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		String datestr2 = sdf2.format(cal2.getTime());

		int userNo = user.getUserNo();
		// System.out.println("영화 고유번호를 적어주세요 --추후에 이건 필요없음");
		int movieNo = movienum;
		System.out.println("평점을 적어주세요 (1~5)");
		int rate = Integer.parseInt(sc.nextLine());
		System.out.println("남기실 코멘트를 입력해주세요");
		String comment = sc.nextLine();
		String rateDate = datestr2;
		CustomerController.Evaluation(userNo, movieNo, rate, comment, rateDate);

	}

	public static void movieDetail() {
		System.out.print("========영화 상세 정보 확인========");
		String keyword = insertKeyword();
		Search sd = SearchController.showMovieDetail(keyword);
		String mn = sd.getMovieName();

		int movienum = 0;
		
		//System.out.println("=======================================================================");

		String di = sd.getDirector();


		System.out.println("=====================================================================================");

		System.out.println("1. 현재 영화의 평점 및 코멘트를 작성하시겠습니까? | 2. 위시리스트에 추가 | 0. 종료 |");
		System.out.println("=====================================================================================");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT 영화_고유번호 FROM 영화 WHERE 작품명 = " + "'"+ mn +"'";

			try {
				con = DbUtil.getConnection();

				ps = con.prepareStatement(sql);
				rs = ps.executeQuery("select 영화_고유번호 from 영화 where 작품명  ='" + mn + "' and 감독 = '" + di + "'");
				if (rs.next()) {

					movienum = rs.getInt(1);
				}
				;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbUtil.dbClose(con, ps, rs);
			}

			userComment(movienum);
			break;
		case 2:
			WishController.putWishList(user.getUserNo(), movienum);
			break;
		case 0:
			return;

		}
	}
}
