package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HealthInfDao;
import dto.HealthInf;


/**
 * Servlet implementation class HealthResistServlet
 */
@WebServlet("/HealthResistMakan")
public class HealthResistMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (checkNoneLogin(request, response)) {
			return;
		}
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("id");
		HealthInfDao bDao = new HealthInfDao();
		if(bDao.isOneData(u_id) == true) {
			// 更新ページにリダイレクト	
		response.sendRedirect(request.getContextPath() + "/HealthUpdateMakan");
		}
		else {
			// 計算結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthResist.jsp");
		dispatcher.forward(request, response);
		}
		
		
		
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
				int  wMotionDays= Integer.parseInt(request.getParameter("wMotionDays"));
				String U_id = request.getParameter("U_id");
		
				// 登録処理を行う
				HealthInfDao bDao = new HealthInfDao();
				bDao.insert(new HealthInf(0,iWeight , cWeight, height, age, gender, term, wMotionDays, 0, 0, 0, 0, U_id)); // 登録成功
				// 結果画面(初週)へリダイレクト	
				response.sendRedirect(request.getContextPath() + "/HealthResultFirstWeekMakan");
//		// フォワード
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthResultDefault0.jsp");
//		dispatcher.forward(request, response);
	}

}
