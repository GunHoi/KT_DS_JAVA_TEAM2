package com.ktdsuniversity.edu.cafe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//올려주신 txt 파일에서 197번째 줄 아래부터는 힌트인 줄 알고 거기까지만 보고 만들었던 파일입니다
//전체적으로 노가다로 풀었다는 느낌이 심한데... 지우기는 뭔가 아쉬워서 내버려 둡니다.







public class Cafe {

	public static void main(String[] args) {

		List<List<String>> menuList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String name;
		int menu;
		int index;

		for (int i = 0; i < 4; i += 1) {
			menuList.add(new ArrayList<>());
		}

		System.out.println("Cafe Menu Management System");

		while (true) {
			System.out.println("=================================");
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("4. 조회(1개)");
			System.out.println("5. 조회(종류별)");
			System.out.println("6. 조회(전체)");
			System.out.println("7. 종료");
			System.out.println("=================================");
			System.out.println("메뉴를 입력하세요(숫자):");
			menu = scan.nextInt();
			scan.nextLine();

			if (menu == 1) {
				System.out.println("=================================");
				System.out.println("1. 커피");
				System.out.println("2. 음료");
				System.out.println("3. 티");
				System.out.println("4. 디저트");
				System.out.println("5. 뒤로가기");
				System.out.println("=================================");
				System.out.println("등록할 메뉴 타입을 입력하세요(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();
				if (menu <= 4 && menu != 0) {
					System.out.println("등록할 아이템명을 입력하세요(문자) :");
					name = scan.nextLine();
					menuList.get(menu - 1).add(name);
					System.out.println(name + "이(가) 등록되었습니다.");
				}
			} else if (menu == 2) {
				System.out.println("=================================");
				System.out.println("1. 커피");
				System.out.println("2. 음료");
				System.out.println("3. 티");
				System.out.println("4. 디저트");
				System.out.println("5. 뒤로가기");
				System.out.println("=================================");
				System.out.println("수정할 메뉴 타입을 입력하세요(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();
				if (menu <= 4 && menu != 0) {
					System.out.println("수정할 아이템 인덱스를 입력하세요.(숫자) :");
					index = scan.nextInt();
					scan.nextLine();
					if (index <= menuList.get(menu - 1).size()) {
						System.out.println("수정할 아이템명을 입력하세요.(문자) :");
						name = scan.nextLine();
						menuList.get(menu - 1).set(index, name);
						System.out.println(name + "(으)로 수정되었습니다.");
					} else {
						System.out.println("아이템이 존재하지 않습니다.");
					}

				}
			} else if (menu == 3) {
				System.out.println("=================================");
				System.out.println("1. 커피");
				System.out.println("2. 음료");
				System.out.println("3. 티");
				System.out.println("4. 디저트");
				System.out.println("5. 뒤로가기");
				System.out.println("=================================");
				System.out.println("삭제할 메뉴 타입을 입력하세요(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();
				if (menu <= 4 && menu != 0) {
					System.out.println("삭제할 아이템 인덱스를 입력하세요(숫자) :");
					index = scan.nextInt();
					scan.nextLine();
					if (index <= menuList.get(menu - 1).size()) {
						menuList.get(menu - 1).remove(index);
						System.out.println("삭제되었습니다.");
					} else {
						System.out.println("아이템이 존재하지 않습니다.");
					}

				}

			} else if (menu == 4) {
				System.out.println("=================================");
				System.out.println("1. 커피");
				System.out.println("2. 음료");
				System.out.println("3. 티");
				System.out.println("4. 디저트");
				System.out.println("5. 뒤로가기");
				System.out.println("=================================");
				System.out.println("조회할 메뉴 타입을 입력하세요(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();
				if (menu <= 4 && menu != 0) {
					System.out.println("조회할 아이템 인덱스를 입력하세요(숫자) :");
					index = scan.nextInt();
					scan.nextLine();
					if (index <= menuList.get(menu - 1).size()) {
						System.out.println(menuList.get(menu - 1).get(index));
					} else {
						System.out.println("아이템이 존재하지 않습니다.");
					}

				}
			} else if (menu == 5) {
				System.out.println("=================================");
				System.out.println("1. 커피");
				System.out.println("2. 음료");
				System.out.println("3. 티");
				System.out.println("4. 디저트");
				System.out.println("5. 뒤로가기");
				System.out.println("=================================");
				System.out.println("조회할 메뉴 타입을 입력하세요(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();
				if (menu <= 4 && menu != 0) {
					if (menu == 1) {
						System.out.println("<커피>");
						System.out.println(menuList.get(menu - 1));
					} else if (menu == 2) {
						System.out.println("<음료>");
						System.out.println(menuList.get(menu - 1));
					} else if (menu == 3) {
						System.out.println("<차>");
						System.out.println(menuList.get(menu - 1));
					} else {
						System.out.println("<디저트>");
						System.out.println(menuList.get(menu - 1));
					}

				}

			} else if (menu == 6) {
				System.out.println("<커피>");
				System.out.println(menuList.get(0)+"\n");
				System.out.println("<음료>");
				System.out.println(menuList.get(1)+"\n");
				System.out.println("<티>");
				System.out.println(menuList.get(2)+"\n");
				System.out.println("<디저트>");
				System.out.println(menuList.get(3)+"\n");
				

			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
