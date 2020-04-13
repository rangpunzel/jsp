package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

@WebServlet("/commons/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/*	//톰켓이 실행되서 서블릿을 실행할때 딱 한번 실행(로그기록 남기기용) 필터를 사용해서 잘안씀 ㅋㅋ
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() execute!");
	}
	
	//톰켓이 배포를 멈추기 전 한번 실행(종료되는 로그 기록) 필터를 사용해서 잘안씀 ㅋㅋ
	public void destroy() {
		System.out.println("destroy() execute!");
		
	}*/
	
	//do가 붙은 메소드는 리퀘스트요청이 와야 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/commons/loginForm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="redirect:/member/list";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		try {
			MemberServiceImpl.getInstance().login(id, pwd);
			
			MemberVO loginUser=MemberServiceImpl.getInstance().getMember(id);
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(5);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url="error/500_error";
			request.setAttribute("exception", e);
		} catch (NotFoundIDException | InvalidPasswordException e) {
			//e.printStackTrace();
			url="commons/loginForm";
			request.setAttribute("msg", e.getMessage());
		}
		ViewResolver.view(request, response, url);
		
	}

}
