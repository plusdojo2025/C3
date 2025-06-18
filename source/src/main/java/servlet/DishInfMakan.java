package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishDao;
import dto.Dish;


/**
 * Servlet implementation class DishInf
 */
@WebServlet("/DishInfMakan")
public class DishInfMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//ログイン画面にリダイレクト
//		if (checkNoneLogin(request, response)) {
//			return;
//		}
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		// データベースを検索して結果をリクエストスコープに格納する
		DishDao dao = new DishDao();
		List<Dish> emp = dao.select1();
		//HttpSession session = request.getSession();
		request.setAttribute("emp",emp);
		//session.setAttribute("emp",emp);
	    
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/dishInf.jsp");
		dispatcher.forward(request, response);
	}
	
//		// 食事選択画面にフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dishInf.jsp");
//		dispatcher.forward(request, response);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}

