package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MonthlyIncomeSummaryDto;

public class MonthlyIncomeSummaryDao extends CustomTemplateDao<MonthlyIncomeSummaryDto> {

	@Override
	public List<MonthlyIncomeSummaryDto> select(MonthlyIncomeSummaryDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		List<MonthlyIncomeSummaryDto> mInfo = new ArrayList<MonthlyIncomeSummaryDto>();//不定の配列

		try {
			conn = conn();//戻り値Connection型 dbに接続する

			// SQL文を準備する

			String sql = "SELECT * FROM monthly_income_summary WHERE u_id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,dto.getU_id());

			// SQL文を実行し、結果を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果を1行ずつコレクションにコピーする
			while (rs.next()) {
				MonthlyIncomeSummaryDto us = new MonthlyIncomeSummaryDto(
						rs.getString("U_id"), //テーブルの列名
						rs.getString("work_month"),
						rs.getInt("estimatedMonthlyIncome"),
						rs.getInt("hWage"),
						rs.getInt("totalMonthlyWorkHours")
						);
				mInfo.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			mInfo = null;
		} finally {
			// dbを切断
			close(conn);
		}

		// 結果を返す
		return mInfo;
	}

	@Override
	public boolean insert(MonthlyIncomeSummaryDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(MonthlyIncomeSummaryDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(MonthlyIncomeSummaryDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
