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

import dao.usersDao;
import dto.users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginMakan")
public class LoginServlet extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (checkDoneLogin(request, response)) {
			return;
		}
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//if (checkDoneLogin(request, response)) {
		//	return;
		//}
		
		String id = request.getParameter("loginID");//inputのname
		String pw = request.getParameter("loginPassword");
		usersDao uDao = new usersDao();
		users uDto = new users(id,pw,"");
		List<users> userInfo = new ArrayList<users>();
		
		if(uDao.isLoginOK(uDto)) {//アカウント照合
			userInfo = uDao.selectI_N(uDto);
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			session.setAttribute("userInf",userInfo.get(0));//userInf.id pass name
			response.sendRedirect(request.getContextPath() + "/HomeMakan");
		}
		else {
			request.setAttribute("loginMiss","ログイン失敗! IDまたはパスワードに間違いがあります。");
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");///WEB-INF/jsp/
			dispatcher.forward(request, response);
		}
		

		
	}

    
	}


