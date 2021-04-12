package ch03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에서 받아온 ID와 PW
		final String MEMBER_ID = "admin"; // 동일하면 로그인 시켜주고 아니면 시켜주지 않음
		final String MEMBER_PW = "1234";
		
		// post 요청 인코딩
		request.setCharacterEncoding("utf-8"); // 가져온 파일을 utf-8
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// if(!id.equals(MEMBER_ID) && !pw.equals(MEMBER_PW)) {
		if(id.equals(MEMBER_ID)==false || pw.equals(MEMBER_PW)==false) { // 로그인 실패하면
			response.sendRedirect(request.getContextPath()+"/ch03/login.html"); // 재요청
			return; // 끝낸다
		}
		// else문에 있는거랑 같다
		HttpSession session = request.getSession(); // request한테 세션을 달라한다
		session.setAttribute("loginId", id);
		// 응답
		response.setContentType("text/html;charset=utf-8"); // 만드는 파일을 utf-8로 만다는다는 의미
		response.getWriter().print("<html><body>");
		response.getWriter().print("<div>"+(String)(session.getAttribute("loginId"))+"</div>");
		response.getWriter().print("<div><a href='/servlet-book/logout'>로그아웃</a></div>");
		response.getWriter().print("</body></html>");
	}

}
