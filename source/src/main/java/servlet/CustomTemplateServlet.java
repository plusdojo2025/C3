package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class CustomTemplateServlet extends HttpServlet {
	
	protected final boolean checkNoneLogin(HttpServletRequest request, HttpServletResponse response) 
			   throws IOException {
		HttpSession session = request.getSession();
		boolean result = (session.getAttribute("id") == null);
		if (result) {
			// ログインサーブレットにリダイレクトする
			response.sendRedirect("login");
		}
		return result;
			 
			 }
	
	protected final boolean checkDoneLogin(HttpServletRequest request, HttpServletResponse response) 
			   throws IOException {
		HttpSession session = request.getSession();
		boolean result = (session.getAttribute("id") != null);
		if (result) {
			// ホームサーブレットにリダイレクトする
			response.sendRedirect("home");
		}
		return result;
			 
			 }
	
	@Override
	protected abstract void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	
	@Override
	protected abstract void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
