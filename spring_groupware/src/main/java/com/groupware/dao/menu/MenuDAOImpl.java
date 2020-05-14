package com.groupware.dao.menu;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.groupware.dto.MenuVO;

public class MenuDAOImpl implements MenuDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	@Override
	public List<MenuVO> selectMenuList() throws SQLException {
		List<MenuVO> menuList = sqlSession.selectList("Menu-Mapper.selectMenuList"); 
		return menuList;
	}

	@Override
	public List<MenuVO> selectSubMenuListByMcode(String mCode) throws SQLException {
		List<MenuVO> subMenuList = sqlSession.selectList("Menu-Mapper.selectSubMenuListByMcode",mCode);
		return subMenuList;
	}

}
