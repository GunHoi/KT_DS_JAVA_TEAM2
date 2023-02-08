package com.ktdsuniversity.edu.cafe.menu.mgnt.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntService;
import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntServiceImpl;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class MenuMgntController {

	/**
	 * 기본화면 - Mgnt 전체 메뉴 출력
	 */
	private static void MenuPrint() {
		System.out.println("====메뉴를 선택하세요====");
		System.out.println("1. 등록");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 조회...단일");
		System.out.println("5. 조회...카테고리 선택");
		System.out.println("6. 조회...전체");
		System.out.println("7. 종료");
		System.out.println("====================");
	}
	private static void TypePrint() {
		System.out.println("===등록 메뉴 타입 선택===");
		System.out.println("1. 커피");
		System.out.println("2. 음료");
		System.out.println("3. 티");
		System.out.println("4. 디저트");
		System.out.println("====뒤로가기 아무버튼====");
		
	}
	private static String menuSelect(int num) {
		if (num==1) {
			return "커피";
		} else if(num==2) {
			return "음료";
		} else if(num==3) {
			return "티";
		} else if(num==4) {
			return "디저트";
		} else {
			return "없음";
		}
	}
	
	

	public static void main(String[] args) {

//		Map<String, String> map = new HashMap<>();
//		map.put("a", "b");
//		map.put("b", "b");
//		map.put("b", "c");
//		map.put("c", "1");
//		
//		System.out.println(map);
//		
//		Map<String, List<String>> mapList = new HashMap<>();
//		List<String> list = new ArrayList<>();
//		list.add("ab");
//		list.add("ab");
//		list.add("ab");
//		mapList.put("a", list);
//		
//		System.out.println(mapList);

		MenuMgntService service = new MenuMgntServiceImpl();

		Scanner scan = new Scanner(System.in);

		System.out.println("**Cafe Menu Management System**");

		while (true) {
			MenuPrint();

			// 숫자가 아닌 값 입력 시 에러나는거 처리하고싶다
			int menu = scan.nextInt();
			scan.nextLine();
			
			if (menu == 7) {
				System.out.println("ㄹㅇ 종료? Y/N");
				String ans = scan.nextLine();
				if (ans.equalsIgnoreCase("Y")) {
					System.out.println("Y를 눌렀음. 종료됨");
					break;
				} else {
					System.out.println("취소임 처음으로 돌아감, 아무키나 누르셈");
					scan.nextLine();
				}
			}
			// 등록	.create(itemType1, name)
			else if (menu==1) {
				TypePrint();
				System.out.print("등록할 메뉴 타입 선택(숫자) : ");
				int itemType = scan.nextInt();
				scan.nextLine();
				
				String itemType1 = menuSelect(itemType);
				if (itemType1.equals("없음")){
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}
				
				System.out.print("등록할 메뉴 이름 작성(문자) : ");
				String itemName = scan.nextLine();
				
				MenuMgntVO name = new MenuMgntVO();
				name.setItemName(itemName);
				service.create(itemType1, name);
				System.out.println("!!등록 완료!!");

			}
			
			// 수정	.update(itemType1, itemIdx, name)
			else if (menu==2) {
				TypePrint();
				System.out.print("수정할 메뉴 타입 선택(숫자) : ");
				
				int itemType = scan.nextInt();
				scan.nextLine();
				
				String itemType1 = menuSelect(itemType);
				if (itemType1.equals("없음")){
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}
				
				int cnt = 0;
				for (MenuMgntVO itemList : service.readSome(itemType1)) {
					System.out.printf("[%d] %s\n",cnt++, itemList.getItemName());
				};
				
				// 목록 없을 때 탈출
				if (cnt == 0) {
					System.out.println("아이템 목록이 존재하지 않음 ㅂ");
					continue;
				}
				
				System.out.print("수정할 아이템 인덱스 입력(숫자) : ");
				int itemIdx = scan.nextInt();
				scan.nextLine();
				
				if (itemIdx >= cnt) {
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}
				
				
				System.out.print("수정할 메뉴 이름 작성(문자) : ");
				String itemName = scan.nextLine();
				
				MenuMgntVO name = new MenuMgntVO();
				name.setItemName(itemName);
				
				service.update(itemType1, itemIdx, name);
				System.out.println("!!수정 완료!!");
			}
			
			// 삭제	.delete(itemType1, itemIdx)
			else if (menu==3) {
				TypePrint();
				System.out.print("삭제할 메뉴 타입 선택(숫자) : ");
				int itemType = scan.nextInt();
				scan.nextLine();
				
				String itemType1 = menuSelect(itemType);
				if (itemType1.equals("없음")){
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}
				
				int cnt = 0;
				for (MenuMgntVO itemList : service.readSome(itemType1)) {
					System.out.printf("[%d] %s\n",cnt++, itemList.getItemName());
				};
				
				// 목록 없을 때 탈출
				if (cnt == 0) {
					System.out.println("아이템 목록이 존재하지 않음 ㅂ");
					continue;
				}
				
				System.out.print("삭제할 아이템 인덱스 입력(숫자) : ");
				int itemIdx = scan.nextInt();
				scan.nextLine();
				
				service.delete(itemType1, itemIdx);
				System.out.println("!!삭제 완료!!");
				
				
			}
			
			// 조회...단일	.readSome(itemType)
			else if (menu==4) {
				TypePrint();
				System.out.print("조회할 메뉴 타입 선택(숫자) : ");
				int itemType = scan.nextInt();
				scan.nextLine();
				
				String itemType1 = menuSelect(itemType);
				if (itemType1.equals("없음")){
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}
				
				int cnt = 0;
				for (MenuMgntVO itemList : service.readSome(itemType1)) {
					System.out.printf("[%d] %s\n",cnt++, itemList.getItemName());
				};
				
				// 목록 없을 때 탈출
				if (cnt == 0) {
					System.out.println("아이템 목록이 존재하지 않음 ㅂ");
					continue;
				}
				
				System.out.print("조회할 아이템 인덱스 입력(숫자) : ");
				int itemIdx = scan.nextInt();
				scan.nextLine();
				
				if (itemIdx > cnt) {
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}
				
				System.out.println(service.read(itemType1, itemIdx).getItemName());
				
			}
			
			// 조회...종류별
			else if (menu==5) {
				TypePrint();
				System.out.print("조회할 메뉴 타입 선택(숫자) : ");
				int itemType = scan.nextInt();
				scan.nextLine();
				
				String itemType1 = menuSelect(itemType);
				if (itemType1.equals("없음")){
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}
				
				int cnt = 0;
				for (MenuMgntVO itemList : service.readSome(itemType1)) {
					System.out.printf("[%d] %s\n",cnt++, itemList.getItemName());
				};
				
				// 목록 없을 때 탈출
				if (cnt == 0) {
					System.out.println("아이템 목록이 존재하지 않음 ㅂ");
					continue;
				}
				
				if (itemType > cnt) {
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}
				
				
				
			}
			
			// 조회...전체
			else if (menu==6) {
				Map<String, List<MenuMgntVO>> mapList = new HashMap<>(service.readAll());
				for (String type : mapList.keySet()) {
					System.out.println("====	"+type+"	====");
					for(MenuMgntVO item : mapList.get(type)) {
						System.out.println(item.getItemName());
					}
				}
								
				
			}
			
			else {
				System.out.println("번호 잘눌러줭");
			}
		}

	}

}
