package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DishInf
 */
@WebServlet("/DishInfMakan")
public class DishInfMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (checkNoneLogin(request, response)) {
//			return;
//		}
		
		// 食事選択画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dishInf.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
