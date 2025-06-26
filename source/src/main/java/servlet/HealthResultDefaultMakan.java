package servlet;

import java.io.IOException;
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
 * Servlet implementation class HealthResultDefaultMakan
 */
@WebServlet("/HealthResultDefaultMakan")
public class HealthResultDefaultMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (checkNoneLogin(request, response)) {
//			return;
//		}
		int lwCcalorie;
		// セッションからユーザーIDを取得
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("id");
		System.out.println("【DEBUG】セッションのu_id: " + u_id);
		
		// DTOに検索条件をセット
		HealthInf dto = new HealthInf();
		dto.setU_id(u_id);
		
		// データベースを検索して結果をリクエストスコープに格納する
		HealthInfDao dao = new HealthInfDao();
		List<HealthInf> emp = dao.select(dto);
		lwCcalorie = emp.get(0).getLwCcalorie();		
		request.setAttribute("emp",emp);
		
		// 先週の消費カロリーを取得
		
		
		// 先週の消費カロリーがない場合(初週)の分岐
		if(lwCcalorie == 0) {
			// 結果(初週)リダイレクト
			response.sendRedirect(request.getContextPath() + "/HealthResultFirstWeekMakan");
		}
		else {
			// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthResultDefault.jsp");
		dispatcher.forward(request, response);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/healthResultDefault.jsp");
		dispatcher.forward(request, response);
	}

}
