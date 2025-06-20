package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		String sql = "select dWork,wWork from MoneyInf where u_id = ?";;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		pStmt.setString(1,dto.getU_id());
		
		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			MoneyInf us = new MoneyInf(
					rs.getInt("id"), //テーブルの列名
					rs.getInt("gIncome"),
					rs.getInt("hWage"),
					rs.getInt("wWork"),
					rs.getString("dependent"),
					rs.getInt("netIncome"),
					rs.getInt("dWork"),
					rs.getString("U_id")
					);
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
		List<HealthInf> hInfo = new ArrayList<HealthInf>();//不定の配列

		try {
			conn = conn();//戻り値Connection型 dbに接続する

			// SQL文を準備する
			String sql = "SELECT dMotionTime,wMotionDays FROM healthinf WHERE u_id = ? order by id desc limit 1;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,dto.getU_id());

			// SQL文を実行し、結果を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果を1行ずつコレクションにコピーする
			while (rs.next()) {
				HealthInf us = new HealthInf(
						rs.getInt("id"), //テーブルの列名
						rs.getInt("iWeight"),
						rs.getInt("cWeight"),
						rs.getInt("height"),
						rs.getInt("age"),
						rs.getString("gender"),
						rs.getInt("term"),
						rs.getInt("wMotionDays"),
						rs.getInt("dMotionTime"),
						rs.getInt("lwCcalorie"),
						rs.getInt("lwIcalorie"),
						rs.getInt("metaRate"),
						rs.getString("u_id")
						);
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
		return null;
	}

	@Override
	public boolean insert(Schedule dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(Schedule dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(Schedule dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
