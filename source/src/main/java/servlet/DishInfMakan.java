package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DayUserInfDao;
import dao.DishDao;
import dao.DishInfDao;
import dao.HealthInfDao;
import dto.DayUserInf;
import dto.Dish;
import dto.DishInf;
import dto.HealthInf;



/**
 * Servlet implementation class DishInf
 */
@WebServlet("/DishInfMakan")
public class DishInfMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//ログイン画面にリダイレクト
		if (checkNoneLogin(request, response)) {
			return;
		}
		
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
		int nStaple = 0;
		nStaple = Integer.parseInt(request.getParameter("nStaple"));
		int nMain = 0;
		nMain = Integer.parseInt(request.getParameter("nMain"));
		int nSide = 0;
		nSide = Integer.parseInt(request.getParameter("nSide"));
		int nOther = 0;
		nOther = Integer.parseInt(request.getParameter("nOther"));
		int eStaple = 0;
		eStaple = Integer.parseInt(request.getParameter("eStaple"));
		int eMain = 0;
		eMain = Integer.parseInt(request.getParameter("eMain"));
		int eSide = 0;
		eSide = Integer.parseInt(request.getParameter("eSide"));
		int eOther = 0;
		eOther = Integer.parseInt(request.getParameter("eOther"));
		int snack = 0;
		snack = Integer.parseInt(request.getParameter("snack"));
		
	    HttpSession session = request.getSession();
	    String U_id = (String) session.getAttribute("id");


		// 登録処理を行う
		DishInfDao bDao = new DishInfDao();
		bDao.insert(new DishInf(0, mStaple,mMain, mSide, mOther,nStaple,nMain,nSide,nOther,eStaple,eMain,eSide,eOther,snack,null,U_id));
		
		HealthInfDao hDao = new HealthInfDao();
		List<HealthInf> hInfo = hDao.select(new HealthInf(0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0,U_id));
		
		DishDao dDao = new DishDao();
		Map<Integer,Integer> dList = dDao.select();
		
		DayUserInfDao uDao = new DayUserInfDao();
		DayUserInf uDto =new DayUserInf (0, 0, 0, new Date(), U_id);
		uDto.setTotalCalorie(
				dList.get(mStaple) +
				dList.get(mMain) +
				dList.get(mSide) +
				dList.get(mOther) +
				dList.get(nStaple) +
				dList.get(nMain) +
				dList.get(nSide) +
				dList.get(nOther) +
				dList.get(eStaple) +
				dList.get(eMain) +
				dList.get(eSide) +
				dList.get(eOther) +
				dList.get(snack));
		uDto.setDayCalcWeight(hInfo.get(0).getcWeight());
		uDao.insert(uDto);
		
		// 結果ページにフォワードする
		response.sendRedirect(request.getContextPath() + "/DishMakan?ymd=");


		}
}

