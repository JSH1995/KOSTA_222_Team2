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
	
}
