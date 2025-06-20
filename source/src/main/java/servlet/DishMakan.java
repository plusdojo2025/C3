package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishInfDao;
import dto.DishInf;

/**
 * Servlet implementation class DishMakan
 */
@WebServlet("/DishMakan")
public class DishMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (checkNoneLogin(request, response)) {
//			return;
//		}
//			
//			// リクエストパラメータを取得する
//			request.setCharacterEncoding("UTF-8");

			// データベースを検索して結果をリクエストスコープに格納する
			DishInfDao dao = new DishInfDao();
			List<DishInf> dish = dao.select();
			//HttpSession session = request.getSession();
			request.setAttribute("dish",dish);
			//session.setAttribute("dish",dish);
		
		// 食事表示画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dish.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
