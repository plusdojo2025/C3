package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DishInfDao;
import dto.Dish;

/**
 * Servlet implementation class DishMakan
 */
@WebServlet("/DishMakan")
public class DishMakan extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (checkNoneLogin(request, response)) {
			return;
		}
			
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String dateParam = request.getParameter("ymd");
        

        // 通常アクセス（画面遷移）
        if (dateParam == null || dateParam.isEmpty()) {
            dateParam = java.time.LocalDate.now().toString();
        }
	    HttpSession session = request.getSession();
	    String U_id = (String) session.getAttribute("id");
	    DishInfDao dao = new DishInfDao();
	    
	    List<Dish> dish = dao.selectByDate(U_id, dateParam); 
	    List<Dish> dishN = dao.selectByDateN(U_id, dateParam);
	    List<Dish> dishE = dao.selectByDateE(U_id, dateParam);
	    List<Dish> dishS = dao.selectByDateS(U_id, dateParam);

	    request.setAttribute("dish", dish);
	    request.setAttribute("selectedDate", dateParam);
	    
	    request.setAttribute("dishN", dishN);
	    request.setAttribute("selectedDateN", dateParam);
	    
	    request.setAttribute("dishE", dishE);
	    request.setAttribute("selectedDateE", dateParam);
	    
	    request.setAttribute("dishS", dishS);
	    request.setAttribute("selectedDateS", dateParam);
		  		
		// 食事表示画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dish.jsp");
		dispatcher.forward(request, response);
}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
