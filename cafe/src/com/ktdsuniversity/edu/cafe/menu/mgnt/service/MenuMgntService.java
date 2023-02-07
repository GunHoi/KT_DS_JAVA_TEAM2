package com.ktdsuniversity.edu.cafe.menu.mgnt.service;

import java.util.List;
import java.util.Map;

import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public interface MenuMgntService {

	public boolean create(String itemType,MenuMgntVO menuMgntVO);
	
	public boolean update(String itemType, int itemIdx, MenuMgntVO menuMgntVO);
	
	public boolean delete(String itemType, int itemIdx);
	
	public MenuMgntVO read(String itemType, int itemIdx);
	
	public List<MenuMgntVO> readSome(String itemType);
	
	public Map<String, List<MenuMgntVO>> readAll();
}
