package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoneyInfDao;
import dto.MoneyInf;


/**
 * Servlet implementation class IncomeResisterMakan
 */
@WebServlet("/IncomeResisterMakan")
public class IncomeResisterMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (checkNoneLogin(request, response)) {
//			return;
//		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/incomeResister.jsp");
		dispatcher.forward(request, response);	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
	
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int gIncome = Integer.parseInt(request.getParameter("gIncome"));
		int wWage = Integer.parseInt(request.getParameter("wWage"));
		int wWork = Integer.parseInt(request.getParameter("wWork"));
		String dependent = request.getParameter("dependent");
		String U_id = request.getParameter("U_id");
		
		
		// 登録処理を行う
		MoneyInfDao bDao = new MoneyInfDao();
		bDao.insert(new MoneyInf(0, gIncome, wWage, wWork, dependent, 0, 0, U_id));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/incomeResister.jsp");
		dispatcher.forward(request, response);	
	}
	}


