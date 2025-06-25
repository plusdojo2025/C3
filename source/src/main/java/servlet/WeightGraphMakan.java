package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DayUserInfDao;
import dao.HealthInfDao;
import dto.DayUserInf;
import dto.HealthInf;

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
		
	    HttpSession session = request.getSession();
	    String U_id = (String) session.getAttribute("id");
	    
//	    DayUserInfDao dao = new DayUserInfDao();
	    
//	    double dayCalcWeight = dao.setDayCalcWeight(U_id);
	    
	    DayUserInfDao dayUserInfDao = new DayUserInfDao();
	    DayUserInf dayUserInf = new DayUserInf();
	    dayUserInf.setU_id(U_id);
	    
	    dayUserInf = dayUserInfDao.select(dayUserInf).get(0);
	    dayUserInf.setDayCalcWeight(dayUserInfDao.selectDayCalcWeight(U_id));
	    dayUserInfDao.update(dayUserInf);
		request.setAttribute("uInfo", dayUserInf.getDayCalcWeight());
	    
	    
		
		HealthInfDao healthInfDao = new HealthInfDao();
		HealthInf healthInf = new HealthInf();
		
		healthInf.setU_id(U_id);
		request.setAttribute("hInfo",healthInfDao.select(healthInf));
		
		
		
		
		
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
