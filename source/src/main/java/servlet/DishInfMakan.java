package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishDao;
import dao.DishInfDao;
import dto.Dish;
import dto.DishInf;



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
	    
		// データベースを検索して結果をリクエストスコープに格納する
		List<Dish> emp2 = dao.select2();
		//HttpSession session = request.getSession();
		request.setAttribute("emp2",emp2);
		//session.setAttribute("emp",emp);
		
		// データベースを検索して結果をリクエストスコープに格納する
		List<Dish> emp3 = dao.select3();
		//HttpSession session = request.getSession();
		request.setAttribute("emp3",emp3);
		//session.setAttribute("emp",emp);
		
		// データベースを検索して結果をリクエストスコープに格納する
		List<Dish> emp4 = dao.select4();
		//HttpSession session = request.getSession();
		request.setAttribute("emp4",emp4);
		//session.setAttribute("emp",emp);
				
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/dishInf.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO 自動生成されたメソッド・スタブ
	
		// リクエストパラメータを取得する		
		int mStaple = 0;
		mStaple = Integer.parseInt(request.getParameter("mStaple"));
		int mMain = 0;
		mMain = Integer.parseInt(request.getParameter("mMain"));
		int mSide = 0;
		mSide = Integer.parseInt(request.getParameter("mSide"));
		int mOther = 0;
		mOther = Integer.parseInt(request.getParameter("mOther"));

		//HTMLフォームから受け取った日付の文字列をjava.util.Date型に変換し、「変数date」へ格納
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String parameterDate = request.getParameter("date");
		Date date = null;
		try {
			LocalDate localDate = LocalDate.parse(parameterDate, dateFormatter);
			date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} catch (Exception ex) { }

		// 登録処理を行う
		DishInfDao bDao = new DishInfDao();
		bDao.insert(new DishInf(mStaple,mMain, mMain, mOther,0,0,0,0,0,0,0,0,0,0,date,"00007"));	

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dish.jsp");
		dispatcher.forward(request, response);

		}
}

