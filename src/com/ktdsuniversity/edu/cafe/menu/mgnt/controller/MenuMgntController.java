package com.ktdsuniversity.edu.cafe.menu.mgnt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntService;
import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntServiceImpl;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class MenuMgntController {
	
	public void printMenu() {
		System.out.println(
				"\n=====================\r\n"
				+"1. 등록\r\n"
				+"2. 수정\r\n"
				+"3. 삭제\r\n"
				+"4. 조회(1개)\r\n"
				+"5. 조회(종목별로)\r\n"
				+"6. 조회(전체)\r\n"
				+"7. 종료\r\n"
				+"\n=====================\r\n"
				);
	}
	
	public void printItemTypeMenu() {
		System.out.println(
				"\n=====================\r\n"
				+"1. 커피\r\n"
				+"2. 음료\r\n"
				+"3. 티\r\n"
				+"4. 디저트\r\n"
				+"5. 뒤로가기\r\n"
				+"\n=====================\r\n"
				);
	}
	
	public static void main(String[] args) {
	
		MenuMgntService service = new MenuMgntServiceImpl();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Cafe Menu Management System");
		
		while(true) {
			MenuMgntController menuMgntController = new MenuMgntController();
			menuMgntController.printMenu();
			MenuMgntVO menuMgntVO = new MenuMgntVO();
			System.out.println("메뉴를 입력하세요(숫자):");
			int menu = scan.nextInt();
			scan.nextLine();
			
			if(menu==1) {
				menuMgntController.printItemTypeMenu();
				System.out.println("등록할 메뉴의 타입을 입력하세요(숫자):");
				menu = scan.nextInt();
				scan.nextLine();
				if(menu==1) {
					System.out.println("등록할 아이템명을 입력하세요(문자)");
					String itemName = scan.nextLine();
					menuMgntVO.setItemName(itemName);
					String itemType = "커피";
					service.create(itemType, menuMgntVO);
					System.out.println(itemName + "가(이) 등록되었습니다.");
				}
				else if(menu==2) {
					System.out.println("등록할 아이템명을 입력하세요(문자)");
					String itemName = scan.nextLine();
					menuMgntVO.setItemName(itemName);
					String itemType = "음료";
					service.create(itemType, menuMgntVO);
					System.out.println(itemName + "가(이) 등록되었습니다.");
				}
				else if(menu==3) {
					System.out.println("등록할 아이템명을 입력하세요(문자)");
					String itemName = scan.nextLine();
					menuMgntVO.setItemName(itemName);
					String itemType = "티";
					service.create(itemType, menuMgntVO);
					System.out.println(itemName + "가(이) 등록되었습니다.");
				}
				else if(menu==4) {
					System.out.println("등록할 아이템명을 입력하세요(문자)");
					String itemName = scan.nextLine();
					menuMgntVO.setItemName(itemName);
					String itemType = "디저트";
					service.create(itemType, menuMgntVO);
					System.out.println(itemName + "가(이) 등록되었습니다.");
				}
				else {
					break;
				}
			}
			//수정
			else if(menu==2) {
				menuMgntController.printItemTypeMenu();
				System.out.println("수정할 메뉴의 타입을 입력하세요(숫자):");
				menu = scan.nextInt();
				scan.nextLine();
				if(menu==1) {
					String itemType = "커피";
					service.readSome(itemType);
					System.out.println("수정할 아이템 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt();
					scan.nextLine();
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						System.out.println("수정할 아이템명을 입력하세요(문자)");
						String itemName = scan.nextLine();
						menuMgntVO.setItemName(itemName);
						service.update(itemType, itemIdx, menuMgntVO);	
						System.out.println(itemName +"로 수정되었습니다.");
					}
				}
				else if(menu==2) {
					String itemType = "음료";
					service.readSome(itemType);
					System.out.println("수정할 아이템 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt();
					scan.nextLine();
					
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						System.out.println("수정할 아이템명을 입력하세요(문자)");
						String itemName = scan.nextLine();
						menuMgntVO.setItemName(itemName);
						service.update(itemType, itemIdx, menuMgntVO);						
						System.out.println(itemName +"로 수정되었습니다.");
					}
				
				}
				else if(menu==3) {
					String itemType = "티";
					service.readSome(itemType);
					System.out.println("수정할 아이템 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt();
					scan.nextLine();
					
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						System.out.println("수정할 아이템명을 입력하세요(문자)");
						String itemName = scan.nextLine();
						menuMgntVO.setItemName(itemName);
						service.update(itemType, itemIdx, menuMgntVO);						
						System.out.println(itemName +"로 수정되었습니다.");
					}
				}
				else if(menu==4) {
					String itemType = "디저트";
					service.readSome(itemType);
					System.out.println("수정할 아이템 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt();
					scan.nextLine();
					
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						System.out.println("수정할 아이템명을 입력하세요(문자)");
						String itemName = scan.nextLine();
						menuMgntVO.setItemName(itemName);
						service.update(itemType, itemIdx, menuMgntVO);						
						System.out.println(itemName +"로 수정되었습니다.");
					}
				}
				else {					
					break;
				}
				
			}
			//삭제
			else if(menu==3) {
				menuMgntController.printItemTypeMenu();
				System.out.println("삭제할 메뉴의 타입을 입력하세요(숫자):");
				menu = scan.nextInt();
				scan.nextLine();
				if(menu==1) {
					String itemType = "커피";
					service.readSome(itemType);
					System.out.println("삭제할 아이템의 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt(); 
					scan.nextLine();
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						service.delete(itemType, itemIdx);
					}
				}
				else if(menu==2) {
					String itemType = "음료";
					service.readSome(itemType);
					System.out.println("삭제할 아이템의 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt(); 
					scan.nextLine();
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						service.delete(itemType, itemIdx);
					}
				}
				else if(menu==3) {
					String itemType = "티";
					service.readSome(itemType);
					System.out.println("삭제할 아이템의 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt(); 
					scan.nextLine();
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						service.delete(itemType, itemIdx);
					}
				}
				else if(menu==4) {
					String itemType = "디저트";
					service.readSome(itemType);
					System.out.println("삭제할 아이템의 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt(); 
					scan.nextLine();
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						service.delete(itemType, itemIdx);
					}
				}
				else {
					break;
				}
	
			}
			//조회1
			else if(menu==4) {
				menuMgntController.printItemTypeMenu();
				System.out.println("조회할 메뉴의 타입을 입력하세요(숫자):");
				menu = scan.nextInt();
				scan.nextLine();
				if(menu==1) {
					String itemType = "커피";
					System.out.println("조회할 아이템의 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt(); 
					scan.nextLine();
					menuMgntVO = service.read(itemType, itemIdx);
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
//						service.read(itemType, itemIdx);
						System.out.println(menuMgntVO.getItemName());
					}
				}
				else if(menu==2) {
					String itemType = "음료";
					System.out.println("조회할 아이템의 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt(); 
					scan.nextLine();
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						System.out.println(menuMgntVO.getItemName());
					}
				}
				else if(menu==3) {
					String itemType = "티";
					System.out.println("조회할 아이템의 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt(); 
					scan.nextLine();
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						System.out.println(menuMgntVO.getItemName());
					}
				}
				else if(menu==4) {
					String itemType = "디저트";
					System.out.println("조회할 아이템의 인덱스를 입력하세요(숫자)");
					int itemIdx = scan.nextInt(); 
					scan.nextLine();
					if(service.read(itemType, itemIdx)==null) {
						System.out.println("아이템이 존재하지 않습니다.");
					}
					else {
						System.out.println(menuMgntVO.getItemName());
					}
				}
				else {					
					break;
				}
				
			}
			//조회그룹1
			else if(menu==5) {
				menuMgntController.printItemTypeMenu();
				System.out.println("등록할 메뉴의 타입을 입력하세요(숫자):");
				menu = scan.nextInt();
				scan.nextLine();
				if(menu==1) {
					String itemType = "커피";
					List<MenuMgntVO> menuMgntVO1 = service.readSome(itemType);
					if(service.readSome(itemType)==null) {
						System.out.println(itemType);
					}
					else {
						System.out.println(itemType);
						for(int i = 0;  i < menuMgntVO1.size() ;i++) {
							System.out.println(menuMgntVO1.get(i).getItemName());
						}
					}
				}
				else if(menu==2) {
					String itemType = "음료";
					List<MenuMgntVO> menuMgntVO1 = service.readSome(itemType);
					if(service.readSome(itemType)==null) {
						System.out.println(itemType);
					}
					else {
						System.out.println(itemType);
						for(int i = 0;  i < menuMgntVO1.size() ;i++) {
							System.out.println(menuMgntVO1.get(i).getItemName());
						}
					}
				}
				else if(menu==3) {
					String itemType = "티";
					List<MenuMgntVO> menuMgntVO1 = service.readSome(itemType);
					if(service.readSome(itemType)==null) {
						System.out.println(itemType);
					}
					else {
						System.out.println(itemType);
						for(int i = 0;  i < menuMgntVO1.size() ;i++) {
							System.out.println(menuMgntVO1.get(i).getItemName());
						}
					}
				}
				else if(menu==4) {
					String itemType = "디저트";
					List<MenuMgntVO> menuMgntVO1 = service.readSome(itemType);
					if(service.readSome(itemType)==null) {
						System.out.println(itemType);
					}
					else {
						System.out.println(itemType);
						for(int i = 0;  i < menuMgntVO1.size() ;i++) {
							System.out.println(menuMgntVO1.get(i).getItemName());
						}
					}
				}
				else {
					break;
				}
			}
			//조회 모든 그룹
			else if(menu==6) {
				menuMgntController.printItemTypeMenu();
					Map<String, List<MenuMgntVO>> menuMgntVO2 = service.readAll();
					List<String> itemTypeList = new ArrayList<>();
					itemTypeList.add("커피");
					itemTypeList.add("음료");
					itemTypeList.add("티");
					itemTypeList.add("디저트");
					for(int i=0 ; i < menuMgntVO2.size() ; i++) {
						System.out.println(itemTypeList.get(i));
							for(int j = 0 ; j < menuMgntVO2.get(itemTypeList.get(i)).size(); j++) {
								System.out.println(menuMgntVO2.get(itemTypeList.get(i)).get(j).getItemName()); 
							}
					}			
			}
			else {
				System.out.println("종료되었습니다.");
				break;
			}
		}
	}
}
