package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HealthInfDao;
import dto.HealthInf;

/**
 * Servlet implementation class HealthUpdateMakan
 */
@WebServlet("/HealthUpdateMakan")
public class HealthUpdateMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (checkNoneLogin(request, response)) {
//			return;
//		}
		// セッションスコープからID取得
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("id");
		
		// インスタンス生成
		HealthInfDao bDao = new HealthInfDao();
		HealthInf bDto = new HealthInf();
		bDto.setU_id(u_id);
		List<HealthInf> hInfo = new ArrayList<HealthInf>();
		hInfo = bDao.select(bDto);
		request.setAttribute("emp",hInfo);
		
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthUpdate.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");				
		int iWeight = Integer.parseInt(request.getParameter("iWeight"));
		int cWeight = Integer.parseInt(request.getParameter("cWeight"));
		int height= Integer.parseInt(request.getParameter("height"));
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		int term = Integer.parseInt(request.getParameter("term"));
		int wMotionDays= Integer.parseInt(request.getParameter("wMotionDays"));
		int lwCcalorie= Integer.parseInt(request.getParameter("lwCcalorie"));
		int lwIcalorie= Integer.parseInt(request.getParameter("lwIcalorie"));
		String U_id = request.getParameter("U_id");

		// セッションスコープからID取得
		HttpSession session = request.getSession();
		session.setAttribute("gender" ,gender);
		//String gender = (String) session.getAttribute("gender");
		
		// 更新処理を行う
		if(lwCcalorie == 0) {
		// 更新処理を行う(初週)
		HealthInfDao bDao = new HealthInfDao();
		bDao.update(new HealthInf(0,iWeight , cWeight, height, age, gender, term, wMotionDays, 1, 1, 1, 1, U_id));
		}
		else {
		// 更新処理を行う(2週目以降)
		HealthInfDao bDao = new HealthInfDao();
		bDao.update(new HealthInf(0,iWeight , cWeight, height, age, gender, term, wMotionDays, 1, lwCcalorie, lwIcalorie, 1, U_id));	
		}
		// リダイレクト	
		response.sendRedirect(request.getContextPath() + "/HealthResultDefaultMakan");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthUpdate.jsp");
//		dispatcher.forward(request, response);
	}

}
