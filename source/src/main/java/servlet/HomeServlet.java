package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ScheduleDao;
import dto.HealthInf;
import dto.MoneyInf;
import dto.Schedule;



@WebServlet("/HomeMakan")
public class HomeServlet extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	public static Date[] getCurrentWeekDates() {
        // 現在の日付を取得
        Calendar calendar = Calendar.getInstance();

        // 週の最初を日曜日に設定（デフォルトでそうなっていることが多いが明示的に指定）
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);

        // 現在の曜日を取得（日曜 = 1, 月曜 = 2, ..., 土曜 = 7）
        int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // カレンダーをその週の日曜日に移動
        calendar.add(Calendar.DATE, Calendar.SUNDAY - currentDayOfWeek);

        // 日〜土の7日間の日付を
        Date[] result = new Date[7];
        for (int i = 0; i < 7; i++) {
        	result [i] = calendar.getTime();
            calendar.add(Calendar.DATE, 1); // 次の日へ進める
        }
        return result;
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//			if (checkNoneLogin(request,response)) {
//				return;
//			}
			
			// リクエストパラメータ取得
			request.setCharacterEncoding("UTF-8");
				
			// セッションからユーザーIDを取得
			HttpSession session = request.getSession();
			String u_id = (String) session.getAttribute("id");
		
			// 検索処理を行う
			ScheduleDao sDao = new ScheduleDao ();
			MoneyInf mInf = new MoneyInf();
			//dto.setU_id(u_id);
			mInf.setU_id(u_id);		
			List<MoneyInf> mInfoList = sDao.select(mInf);
			List<MoneyInf> dWork = new ArrayList<MoneyInf>();
			if(mInfoList.size() == 1) {
				for(int i = 0; i< mInfoList.get(0).getwWork(); i++) {
//					MoneyInf us = new MoneyInf(rs.getInt("id"), // テーブルの列名
//							rs.getInt("gIncome"), rs.getInt("hWage"), rs.getInt("wWork"), rs.getString("dependent"),
//							rs.getInt("netIncome"), rs.getInt("dWork"), rs.getString("U_id"));
					MoneyInf data = new MoneyInf(
							mInfoList.get(0).getId(),
							mInfoList.get(0).getgIncome(),
							mInfoList.get(0).gethWage(),
							mInfoList.get(0).getwWork(),
							mInfoList.get(0).getDependent(),
							mInfoList.get(0).getNetIncome(),
							mInfoList.get(0).getdWork() * 60,
							mInfoList.get(0).getId()+"-"+i
							);
					
					dWork.add(data);
				}
			}
			request.setAttribute("dWork", dWork);
			
			
			
			HealthInf hInf = new HealthInf();
			hInf.setU_id(u_id);
			List<HealthInf> hInfoList = sDao.select(hInf);
			List<HealthInf> dWalk = new ArrayList<HealthInf>();
			if(hInfoList.size() == 1) {
				for(int i = 0; i< hInfoList.get(0).getwMotionDays(); i++) {
//					HealthInf us = new HealthInf(rs.getInt("id"), // テーブルの列名
//							rs.getInt("iWeight"), rs.getInt("cWeight"), rs.getInt("height"), rs.getInt("age"),
//							rs.getString("gender"), rs.getInt("term"), rs.getInt("wMotionDays"), rs.getInt("dMotionTime"),
//							rs.getInt("lwCcalorie"), rs.getInt("lwIcalorie"), rs.getInt("metaRate"), rs.getString("u_id"));
					HealthInf data = new HealthInf(
							hInfoList.get(0).getId(),
							hInfoList.get(0).getiWeight(),
							hInfoList.get(0).getcWeight(),
							hInfoList.get(0).getHeight(),
							hInfoList.get(0).getAge(),
							hInfoList.get(0).getGender(),
							hInfoList.get(0).getTerm(),
							hInfoList.get(0).getwMotionDays(),
							hInfoList.get(0).getdMotionTime(),
							hInfoList.get(0).getLwCcalorie(),
							hInfoList.get(0).getLwIcalorie(),
							hInfoList.get(0).getMetaRate(),
							hInfoList.get(0).getId()+"-"+i
							);
					
					dWalk.add(data);
				}
			}
			request.setAttribute("dWalk", dWalk);
			
			
			request.setAttribute("week", getCurrentWeekDates());
			
			Schedule schedule = new Schedule();
			schedule.setU_id(u_id);
			List<Schedule> scheduleList = sDao.select(schedule);
			request.setAttribute("sList", scheduleList);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			request.setAttribute("now", cal.get(Calendar.DAY_OF_WEEK));
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
			dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
						
		// セッションからユーザーIDを取得
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("id");
		
		ScheduleDao sDao = new ScheduleDao ();
		Schedule schedule = new Schedule();
		schedule.setU_id(u_id);
		List<Schedule> scheduleList = sDao.select(schedule);
		schedule = (scheduleList.size() == 1)?scheduleList.get(0): new Schedule();
		
		HealthInf hInf = new HealthInf();
		hInf.setU_id(u_id);
		List<HealthInf> hInfoList = sDao.select(hInf);
		
		MoneyInf mInf = new MoneyInf();
		mInf.setU_id(u_id);		
		List<MoneyInf> mInfoList = sDao.select(mInf);
		
		String[] idArray = request.getParameterValues("idList");
		for (String id: idArray) {
			//item-0-0
			int id1 = (int)Float.parseFloat(request.getParameter(id + "[0]"));
			int id2 = (int)(Float.parseFloat(request.getParameter(id + "[1]")) * 10 / 4);
			String id3 = request.getParameter(id + "[2]");
			
			if("sun".equals(id3)) {
				if(mInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setSunWork(id2);
				}
				if(hInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setSatMotion(id2);
				}
			}
			else if("mon".equals(id3)) {
				if(mInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setMonWork(id2);
				}
				if(hInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setMonMotion(id2);
				}
				
			}
			else if("tue".equals(id3)) {
				if(mInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setTueWork(id2);
				}
				if(hInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setTueMotion(id2);
				}
			}
			else if("wed".equals(id3)) {
				if(mInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setWedWork(id2);
				}
				if(hInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setWedMotion(id2);
				}
			}
			else if("thu".equals(id3)) {
				if(mInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setThuWork(id2);
				}
				if(hInfoList.size() == 1 && id.startsWith(("item-"+hInfoList.get(0).getId()+"-")) ) {
					schedule.setThuMotion(id2);
				}
			}
			else if("fri".equals(id3)) {
				if(mInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setFriWork(id2);
				}
				if(hInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setFriMotion(id2);
				}
			}
			else if("sat".equals(id3)) {
				if(mInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setSatWork(id2);
				}
				if(hInfoList.size() == 1 && id.startsWith(("item-"+mInfoList.get(0).getId()+"-")) ) {
					schedule.setSatMotion(id2);
				}
			}
			else {
				continue;
			}
			
		}
		
		schedule.setcCalorie(1000);
		
		schedule.setLatestDate(new Date());
		if(schedule.getId() < 1) {
			schedule.setU_id("00007");
			sDao.insert(schedule);
			
		} else {
			sDao.update(schedule);
		}
		response.sendRedirect("HomeMakan");
	}
}
