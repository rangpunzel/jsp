package com.groupware.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.dto.MenuVO;
import com.groupware.service.menu.MenuService;

@Controller
public class CommonController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/index.htm",method=RequestMethod.GET)
	public String mainGET(Model model,String mCode)throws Exception{
		model.addAttribute("mCode",mCode);
		return "main";
	}

	@RequestMapping("/commons/topMenuHql")
	@ResponseBody
	public ResponseEntity<Map<String, List<MenuVO>>> getMenu(HttpSession session)throws Exception{
		ResponseEntity<Map<String, List<MenuVO>>> result = null;
		
		Map<String, List<MenuVO>> menuMap = new HashMap<String, List<MenuVO>>();
		List<MenuVO> menuList = menuService.getTopMenuList();
		
		menuMap.put("subMenuCode", menuList);
		result = new ResponseEntity<Map<String, List<MenuVO>>>(menuMap, HttpStatus.OK);
		
		return result;
	}
	
	@RequestMapping("/commons/subMenuHql")
	public String getSubMenu(@RequestParam(defaultValue="MENU00") String mCode, Model model)throws Exception{
		String url="commons/subMenu";
		List<MenuVO> menuList = menuService.getSubMenuList(mCode);
		model.addAttribute("subMenuList",menuList);
		
		return url;
	}
}
