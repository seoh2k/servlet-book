package ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardList") // 서버이름 안 적는다 // 서블릿이 boardList URL로 전송되어 오는 요청을 처리하도록 설정하는 부분
public class BoardListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String --형변환--> Integer --언박싱--> int
		int page = Integer.parseInt(request.getParameter("page")); // 클라이언트에서 전송된 페이지라는 이름의 파라미터 값을 받는 부분
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter(); // html 페이지
		out.print("<html><body>");
		out.print("<div>"+page+"</div>");
		out.print("</body></html>");
	}
}
