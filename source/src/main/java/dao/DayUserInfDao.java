package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DayUserInf;

public class DayUserInfDao extends CustomTemplateDao<DayUserInf> {

	@Override
	public List<DayUserInf> select(DayUserInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		List<DayUserInf> duInfo = new ArrayList<DayUserInf>();//不定の配列

		try {
			conn = conn();//戻り値Connection型 dbに接続する

			// SQL文を準備する
			String sql = "SELECT * FROM DayUserInf WHERE u_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,dto.getU_id());

			// SQL文を実行し、結果を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果を1行ずつコレクションにコピーする
			while (rs.next()) {
				DayUserInf us = new DayUserInf(
						rs.getInt("id"), //テーブルの列名
						rs.getInt("totalCalorie"),
						rs.getInt("dayCalcWeight"),
						rs.getDate("insertDate"),
						rs.getString("U_id")
						);
				duInfo.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			duInfo = null;
		} finally {
			// dbを切断
			close(conn);
		}

		// 結果を返す
		return duInfo;
	}

	@Override
	public boolean insert(DayUserInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;

		try {
			conn = conn();

			// SQL文を準備する 上書き
			String sql = "INSERT INTO dayUserInf(totalCalorie,dayCalcWeight,insertDate,u_id)VALUES(?,?,CURRENT_DATE(),?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getTotalCalorie());
			pStmt.setInt(2, dto.getDayCalcWeight());
			pStmt.setString(3,dto.getU_id());

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
	public boolean update(DayUserInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(DayUserInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
