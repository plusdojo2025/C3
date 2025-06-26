package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MoneyInfDao;
import dao.TaxDao;
import dto.MoneyInf;

/**
 * Servlet implementation class IncomeResultMakan
 */
@WebServlet("/IncomeResultMakan")
public class IncomeResultMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (checkNoneLogin(request, response)) {
			return;
		}

		// リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		// セッションからユーザーIDを取得
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("id");
		System.out.println("【DEBUG】セッションのu_id: " + u_id);
		// DTOに検索条件をセット
		MoneyInf dto = new MoneyInf();
		dto.setU_id(u_id);
		
		// データベースを検索して結果をリクエストスコープに格納する
		MoneyInfDao dao = new MoneyInfDao();
		List<MoneyInf> emp = dao.select(dto);
		request.setAttribute("emp",emp);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/incomeResult.jsp");
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
					
					// リクエストパラメータ取得
					request.setCharacterEncoding("UTF-8");
					// セッションからユーザーIDを取得
					HttpSession session = request.getSession();
					//System.out.println("【DEBUG】セッションのu_id: " + u_id);
					// DTOに検索条件をセット
					MoneyInf dto = new MoneyInf();
					dto.setU_id(u_id);
					
					// データベースを検索して結果をリクエストスコープに格納する
					MoneyInfDao dao = new MoneyInfDao();
					List<MoneyInf> emp = dao.select(dto);
					request.setAttribute("emp",emp);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/incomeResult.jsp");
					dispatcher.forward(request, response);
					
				}
				else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
				dispatcher.forward(request, response);	
				}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/incomeResult.jsp");
		dispatcher.forward(request, response);		
	}


}
