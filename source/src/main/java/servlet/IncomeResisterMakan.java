package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoneyInfDao;
import dao.TaxDao;
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
		int hWage = Integer.parseInt(request.getParameter("hWage"));
		int wWork = Integer.parseInt(request.getParameter("wWork"));
		int tax;
		String dependent = request.getParameter("dependent");
		String u_id = request.getParameter("U_id");
		
		
		// 登録処理を行う
		MoneyInfDao bDao = new MoneyInfDao();
		TaxDao tDao = new TaxDao();
		tax = tDao.gTax(gIncome,dependent);
		if(bDao.insertComp(new MoneyInf(0, gIncome, hWage, wWork, dependent, 0, 0, u_id),tax)) {
		//bDao.insert(new MoneyInf(0, gIncome, hWage, wWork, dependent, 0, 0, u_id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/incomeResult.jsp");
			dispatcher.forward(request, response);	
		}
		else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
		dispatcher.forward(request, response);	
		}
	}
}


