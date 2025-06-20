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
//		if (checkNoneLogin(request, response)) {
//			return;
//		}
//			
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String dateParam = request.getParameter("ymd");
        
//        // リクエストが JavaScript の fetch からかどうかを判定
//        boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
//
//        if (isAjax) {
//            // fetch() からのリクエスト → JSONで返す
//            response.setContentType("application/json; charset=UTF-8");
//
//            if (dateParam == null || dateParam.isEmpty()) {
//                dateParam = java.time.LocalDate.now().toString();
//            }
//
//            DishInfDao dao = new DishInfDao();
//            List<DishInf> dish = dao.selectByDate("00007", dateParam);
//
//            Gson gson = new Gson();
//            String json = gson.toJson(dish);
//            response.getWriter().write(json);
//            return; // フォワードせずに終了
//        }

        // 通常アクセス（画面遷移）
        if (dateParam == null || dateParam.isEmpty()) {
            dateParam = java.time.LocalDate.now().toString();
        }
	    HttpSession session = request.getSession();
	    String U_id = (String) session.getAttribute("id");
	    DishInfDao dao = new DishInfDao();
	    
	    List<Dish> dish = dao.selectByDate(U_id, dateParam); // ユーザーIDを仮に固定

	    request.setAttribute("dish", dish);
	    request.setAttribute("selectedDate", dateParam);
		  		
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
