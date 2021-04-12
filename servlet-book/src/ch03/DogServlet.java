package ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DogServlet")
public class DogServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		// request.getParameterValue() 메서드를 사용
		String[] dog = request.getParameterValues("dog");
		String[] id = request.getParameterValues("id");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");

		for(String d : dog) {
			out.print("<div>"+d+"</div>");
		}
		
		for(String i : id) {
			out.print("<div>"+i+"</div>");
		}
		
		out.print("</body></html>");
	}

}
