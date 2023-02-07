package com.ktdsuniversity.edu.cafe.menu.mgnt.service;

import java.util.List;
import java.util.Map;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuMgntDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuMgntDAOImpl;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class MenuMgntServiceImpl implements MenuMgntService{

	private MenuMgntDAO menuMgntDAO;
	
	public MenuMgntServiceImpl() {
		menuMgntDAO = new MenuMgntDAOImpl();
	}

	@Override
	public boolean create(String itemType, MenuMgntVO menuMgntVO) {
		return menuMgntDAO.create(itemType, menuMgntVO) > 0;
	}

	@Override
	public boolean update(String itemType, int itemIdx, MenuMgntVO menuMgntVO) {
		return menuMgntDAO.update(itemType, itemIdx, menuMgntVO) > 0;
	}
	
	@Override
	public boolean delete(String itemType, int itemIdx) {
		return menuMgntDAO.delete(itemType, itemIdx) > 0;
	}
	
	@Override
	public MenuMgntVO read(String itemType, int itemIdx) {
		return menuMgntDAO.read(itemType, itemIdx);
	}

	@Override
	public List<MenuMgntVO> readSome(String itemType) {
		return menuMgntDAO.readSome(itemType);
	}

	@Override
	public Map<String, List<MenuMgntVO>> readAll() {
		return menuMgntDAO.readAll();
	}

}
