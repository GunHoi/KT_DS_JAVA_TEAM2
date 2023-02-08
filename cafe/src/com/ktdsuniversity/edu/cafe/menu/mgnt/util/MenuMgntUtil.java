package com.ktdsuniversity.edu.cafe.menu.mgnt.util;

public abstract class MenuMgntUtil {
	
	public static void printMenu() {
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
	
	public static void printItemTypeMenu() {
		System.out.println("\n============================\r\n"
				+ "1. 커피\r\n"
				+ "2. 음료\r\n"
				+ "3. 티\r\n"
				+ "4. 디저트\r\n"
				+ "5. 뒤로가기\r\n"
				+ "============================\n");
	}
	
	
	public static String changeItemType(int itemType) {
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
