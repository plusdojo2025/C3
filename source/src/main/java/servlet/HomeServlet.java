package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScheduleDao;
import dto.HealthInf;
import dto.MoneyInf;



@WebServlet("/HomeMakan")
public class HomeServlet extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//			if (checkNoneLogin(request,response)) {
//				return;
//			}
			
			// 検索処理を行う
			ScheduleDao sDao = new ScheduleDao ();
			
			List<MoneyInf> mInfoList = sDao.select(new MoneyInf());
			request.setAttribute("dWork", mInfoList);
			request.setAttribute("wWork", mInfoList);
			
			List<HealthInf> hInfoList = sDao.select(new HealthInf());
			request.setAttribute("dWalk", hInfoList);
			request.setAttribute("wWalk", hInfoList);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
			dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
