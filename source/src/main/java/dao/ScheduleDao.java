package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dto.HealthInf;
import dto.MoneyInf;
import dto.Schedule;

public class ScheduleDao extends CustomTemplateDao<Schedule> {

	public List<MoneyInf> select(MoneyInf dto) {
		Connection conn = null;
		List<MoneyInf> mInfo = new ArrayList<MoneyInf>();

		try {
			conn = conn();
			String sql = "select * from moneyinf where u_id = ? order by id desc limit 1";
			;
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, dto.getU_id());

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				MoneyInf us = new MoneyInf(rs.getInt("id"), // テーブルの列名
						rs.getInt("gIncome"), rs.getInt("hWage"), rs.getInt("wWork"), rs.getString("dependent"),
						rs.getInt("netIncome"), rs.getInt("dWork"), rs.getString("U_id"));
				mInfo.add(us);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			mInfo = null;
		} finally {
			close(conn);
		}
		return mInfo;
	}

	public List<HealthInf> select(HealthInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		List<HealthInf> hInfo = new ArrayList<HealthInf>();// 不定の配列

		try {
			conn = conn();// 戻り値Connection型 dbに接続する

			// SQL文を準備する
			String sql = "SELECT * FROM healthinf WHERE u_id = ? order by id desc limit 1;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getU_id());

			// SQL文を実行し、結果を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果を1行ずつコレクションにコピーする
			while (rs.next()) {
				HealthInf us = new HealthInf(rs.getInt("id"), // テーブルの列名
						rs.getInt("iWeight"), rs.getInt("cWeight"), rs.getInt("height"), rs.getInt("age"),
						rs.getString("gender"), rs.getInt("term"), rs.getInt("wMotionDays"), rs.getInt("dMotionTime"),
						rs.getInt("lwCcalorie"), rs.getInt("lwIcalorie"), rs.getInt("metaRate"), rs.getString("u_id"));
				hInfo.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			hInfo = null;
		} finally {
			// dbを切断
			close(conn);
		}

		// 結果を返す
		return hInfo;
	}

	@Override
	public List<Schedule> select(Schedule dto) {
		Connection conn = null;
		List<Schedule> hInfo = new ArrayList<Schedule>();// 不定の配列

		try {
			conn = conn();// 戻り値Connection型 dbに接続する

			// SQL文を準備する
			String sql = "SELECT * FROM schedule WHERE U_id = ? and WEEK(latestDate,0) = WEEK(CURRENT_TIMESTAMP,0);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getU_id());

			// SQL文を実行し、結果を取得する
			ResultSet rs = pStmt.executeQuery();
			
			Calendar cal = Calendar.getInstance();
			// 結果を1行ずつコレクションにコピーする
			while (rs.next()) {
				Schedule us = new Schedule(rs.getInt("id"), // テーブルの列名
						rs.getInt("sunWork"), rs.getInt("sunMotion"), rs.getInt("monWork"), rs.getInt("monMotion"),
						rs.getInt("tueWork"), rs.getInt("tueMotion"), rs.getInt("wedWork"), rs.getInt("wedMotion"),
						rs.getInt("thuWork"), rs.getInt("thuMotion"), rs.getInt("friWork"), rs.getInt("friMotion"),
						rs.getInt("satWork"), rs.getInt("satMotion"), rs.getInt("cCalorie"), rs.getDate("latestDate"),
						rs.getString("U_id"));
				cal.setTime(us.getLatestDate());
				us.setDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
				hInfo.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			hInfo = null;
		} finally {
			// dbを切断
			close(conn);
		}

		// 結果を返す
		return hInfo;
	}

	@Override
	public boolean insert(Schedule dto) {//日曜日に確定ボタンを押す
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;

		try {
			conn = conn();
			// SQL文を準備する 上書き
			String sql = "INSERT INTO schedule(sunWork,sunMotion,monWork,monMotion,tueWork,tueMotion,wedWork,wedMotion,thuWork,thuMotion,friWork,friMotion,satWork,satMotion,cCalorie,latestDate,U_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_DATE(),?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getSunWork());//分
			pStmt.setInt(2, dto.getSunMotion());
			pStmt.setInt(3, dto.getMonWork());
			pStmt.setInt(4, dto.getMonMotion());
			pStmt.setInt(5,dto.getTueWork());
			pStmt.setInt(6,dto.getTueMotion());
			pStmt.setInt(7,dto.getWedWork());
			pStmt.setInt(8,dto.getWedMotion());
			pStmt.setInt(9,dto.getThuWork());
			pStmt.setInt(10,dto.getThuMotion());
			pStmt.setInt(11,dto.getFriWork());
			pStmt.setInt(12,dto.getFriMotion());
			pStmt.setInt(13,dto.getSatWork());
			pStmt.setInt(14,dto.getSatMotion());
			pStmt.setInt(15,dto.getcCalorie());
			pStmt.setString(16,dto.getU_id());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				//ResultSet res = pStmt.getGeneratedKeys(); //AUTO INCREMENT
				//res.next();
				//dto.setId(res.getInt(1));
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return result;
	}

	@Override
	public boolean update(Schedule dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;

		try {
			conn = conn();
			// SQL文を準備する 上書き
			String sql = "UPDATE schedule SET sunWork=?,sunMotion=?,monWork=?,monMotion=?,tueWork=?,tueMotion=?,wedWork=?,wedMotion=?,thuWork=?,thuMotion=?,friWork=?,friMotion=?,satWork=?,satMotion=?,cCalorie=?,latestDate=CURRENT_DATE() WHERE u_id=?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getSunWork());//分
			pStmt.setInt(2, dto.getSunMotion());
			pStmt.setInt(3, dto.getMonWork());
			pStmt.setInt(4, dto.getMonMotion());
			pStmt.setInt(5,dto.getTueWork());
			pStmt.setInt(6,dto.getTueMotion());
			pStmt.setInt(7,dto.getWedWork());
			pStmt.setInt(8,dto.getWedMotion());
			pStmt.setInt(9,dto.getThuWork());
			pStmt.setInt(10,dto.getThuMotion());
			pStmt.setInt(11,dto.getFriWork());
			pStmt.setInt(12,dto.getFriMotion());
			pStmt.setInt(13,dto.getSatWork());
			pStmt.setInt(14,dto.getSatMotion());
			pStmt.setInt(15,dto.getcCalorie());
			pStmt.setString(16,dto.getU_id());
			

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				//ResultSet res = pStmt.getGeneratedKeys(); AUTO INCREMENT
				//res.next();
				//dto.Set~~~(res.getInt(1));
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return result;
	}

	@Override
	public boolean delete(Schedule dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
