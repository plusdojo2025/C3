package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeightGraphMakan
 */
@WebServlet("/WeightGraphMakan")
public class WeightGraphMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (checkNoneLogin(request, response)) {
//			return;
//		}
		
		// 体重グラフにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/weightGraph.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/weightGraph.jsp");
//		dispatcher.forward(request, response);
	
}

}
