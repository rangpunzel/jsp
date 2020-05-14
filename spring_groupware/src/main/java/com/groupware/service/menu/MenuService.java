package com.groupware.service.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.MenuVO;

public interface MenuService {
	
	
	List<MenuVO> getTopMenuList()throws SQLException;
	
	List<MenuVO> getSubMenuList(String mCode)throws SQLException;
	
}
