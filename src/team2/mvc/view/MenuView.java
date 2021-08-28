package team2.mvc.view;

import java.util.Scanner;

import team2.mvc.controller.CustomerController;

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
				// MenuView.register(); // 가입
				break;
			case 2:
				CustomerController.login("admin", "admin");// 로그인
				break;

			case 0:
				System.exit(0);
			}
		}
	}
	
}
