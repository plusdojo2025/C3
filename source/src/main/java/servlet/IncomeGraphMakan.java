package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MonthlyIncomeSummaryDao;
import dto.MonthlyIncomeSummaryDto;

/**
 * Servlet implementation class IncomeGraphMakan
 */
@WebServlet("/IncomeGraphMakan")
public class IncomeGraphMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		if (checkNoneLogin(request, response)) {
//			return;
//		}
		String u_id;
		HttpSession session = request.getSession();
		u_id = "00001";																					// (String) session.getAttribute("id");
//		MoneyInfDao mDao = new MoneyInfDao(); 
//		MoneyInf mDto = new MoneyInf();//空のコンストラクタ　×
//		MonthIncomeDao miDao = new MonthIncomeDao();
//		MonthIncome miDto = new MonthIncome(0,0,null,u_id);//空のコンストラクタ　×
//		//目標収入の描画
//		List<MoneyInf> mInf = mDao.select(mDto);
//		//
//		
//		//収入のグラフ(実績)
//		//scheduleから月別の労働時間合計を出す 1.scheduleDaoに関数を追加
//		//moneyInfの時給×scheduleの労働時間合計＝monthIncomeのmIncomeに保存
//		List<MonthIncome> mInc = miDao.select(miDto);
		//
		
		MonthlyIncomeSummaryDao monthlyIncomeDao = new MonthlyIncomeSummaryDao();
		MonthlyIncomeSummaryDto monthlyIncomeDto = new MonthlyIncomeSummaryDto();
		
		monthlyIncomeDto.setU_id(u_id);
		
		request.setAttribute("mInfo",monthlyIncomeDao.select(monthlyIncomeDto));
		
//		request.setAttribute("mInfo",mInf);
//		request.setAttribute("mIncome",mInc);
		
		// 体重グラフにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/incomeGraph.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		

}
}
