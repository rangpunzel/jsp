package com.groupware.dao.menu;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.MenuVO;

public interface MenuDAO {
	
	List<MenuVO> selectMenuList()throws SQLException;
	
	List<MenuVO> selectSubMenuListByMcode(String mCode)throws SQLException;
}
