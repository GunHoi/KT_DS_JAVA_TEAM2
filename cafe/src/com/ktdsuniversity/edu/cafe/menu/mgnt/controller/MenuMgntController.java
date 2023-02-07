package com.ktdsuniversity.edu.cafe.menu.mgnt.controller;

import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntService;
import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntServiceImpl;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class MenuMgntController {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		MenuMgntController controller = new MenuMgntController();
		MenuMgntService service = new MenuMgntServiceImpl();
		MenuMgntVO mgnt;
		
		System.out.println("Cafe Menu Management System");
		
		while(true) {
			controller.printMenu();
			System.out.print("메뉴를 입력하세요(숫자): ");
			int menu = scan.nextInt();		
			scan.nextLine();
			
			if(menu == 1) {
				mgnt = new MenuMgntVO();
				controller.printItemTypeMenu();
				System.out.print("등록할 메뉴 타입을 입력하세요(숫자): ");
				int itemType = scan.nextInt();
				scan.nextLine();
				
				if(controller.checkItemType(itemType)) {
					System.out.print("등록할 아이템명을 입력하세요(문자): ");
					String itemName = scan.nextLine();
					
					mgnt.setItemName(itemName);
					service.create(controller.changeItemType(itemType), mgnt);
					
					System.out.println(itemName+"이(가) 등록되었습니다.");
				}
			}else if(menu == 2) {
				mgnt = new MenuMgntVO();
				controller.printItemTypeMenu();
				System.out.print("수정할 메뉴 타입을 입력하세요(숫자): ");
				int itemType = scan.nextInt();
				scan.nextLine();
				
				if(controller.checkItemType(itemType)) {
					System.out.print("수정할 아이템 인덱스를 입력하세요(숫자): ");
					int itemIdx = scan.nextInt();
					scan.nextLine();
					if(itemIdx >= service.readSome(controller.changeItemType(itemType)).size()) {
						System.out.println("아이템이 존재하지 않습니다.");
					}else {
						System.out.print("수정할 아이템명을 입력하세요(문자): ");
						String itemName = scan.nextLine();
						
						mgnt.setItemName(itemName);
						service.update(controller.changeItemType(itemType), itemIdx, mgnt);
						
						System.out.println(itemName+"로 수정되었습니다.");
					}
				}
			}else if(menu == 3) {
				controller.printItemTypeMenu();
				System.out.print("삭제할 메뉴 타입을 입력하세요(숫자): ");
				int itemType = scan.nextInt();
				scan.nextLine();
				
				if(controller.checkItemType(itemType)) {
					System.out.print("삭제할 아이템 인덱스를 입력하세요(숫자): ");
					int itemIdx = scan.nextInt();
					scan.nextLine();
					
					if(itemIdx >= service.readSome(controller.changeItemType(itemType)).size()) {
						System.out.println("아이템이 존재하지 않습니다.");
					}else {
						service.delete(controller.changeItemType(itemType), itemIdx);
						System.out.println("삭제되었습니다.");
					}
				}
			}else if(menu == 4) {
				controller.printItemTypeMenu();
				System.out.print("조회할 메뉴 타입을 입력하세요(숫자): ");
				int itemType = scan.nextInt();
				scan.nextLine();
				
				if(controller.checkItemType(itemType)) {
					System.out.print("조회할 아이템 인덱스 입력하세요(숫자): ");
					int itemIdx = scan.nextInt();
					scan.nextLine();
					if(itemIdx >= service.readSome(controller.changeItemType(itemType)).size()) {
						System.out.println("아이템이 존재하지 않습니다.");
					}else {
						System.out.println(service.read(controller.changeItemType(itemType),itemIdx).getItemName());
					}
					
				}
			}else if(menu == 5){
				controller.printItemTypeMenu();
				System.out.print("조회할 메뉴 타입을 입력하세요(숫자): ");
				int itemType = scan.nextInt();
				scan.nextLine();
				if(controller.checkItemType(itemType)) {
					System.out.println("<"+controller.changeItemType(itemType)+">");
					for(MenuMgntVO item : service.readSome(controller.changeItemType(itemType))) {
						System.out.println(item.getItemName());
					}
				}	
			}else if(menu == 6){
				for(String key : service.readAll().keySet()) {
					List<MenuMgntVO> value = service.readAll().get(key);
					if(value.size()!=0) {
						System.out.println("<"+key+">");
					}
					for(MenuMgntVO item : value) {
						System.out.println(item.getItemName());
					}
					System.out.println();
				}
			}else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}		
	}

	public void printMenu() {
		System.out.println("\n============================\r\n"
				+ "1. 등록\r\n"
				+ "2. 수정\r\n"
				+ "3. 삭제\r\n"
				+ "4. 조회(1개)\r\n"
				+ "5. 조회(종목별로)\r\n"
				+ "6. 조회(전체)\r\n"
				+ "7. 종료\r\n"
				+ "============================\n");
	}
	
	public void printItemTypeMenu() {
		System.out.println("\n============================\r\n"
				+ "1. 커피\r\n"
				+ "2. 음료\r\n"
				+ "3. 티\r\n"
				+ "4. 디저트\r\n"
				+ "5. 뒤로가기\r\n"
				+ "============================\n");
	}
	
	public boolean checkItemType(int itemType) {
		if(itemType == 1 || itemType == 2 || itemType == 3 || itemType == 4) {
			return true;
		}
		return false;
	}
	
	public String changeItemType(int itemType) {
		if(itemType == 1) {
			return "커피";
		}else if(itemType == 2) {
			return "음료";
		}else if(itemType == 3) {
			return "티";
		}else if(itemType == 4) {
			return "디저트";
		}else {
			return "없음";
		}
	}
}
