package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DishInf;

public class DishInfDao extends CustomTemplateDao<DishInf> {

	@Override
	public List<DishInf> select(DishInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		List<DishInf> dInfo = new ArrayList<DishInf>();//不定の配列

		try {
			conn = conn();//戻り値Connection型 dbに接続する

			// SQL文を準備する
			String sql = "SELECT * FROM DishInf WHERE u_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,dto.getU_id());

			// SQL文を実行し、結果を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果を1行ずつコレクションにコピーする
			while (rs.next()) {
				DishInf us = new DishInf(
						rs.getInt("id"), //テーブルの列名
						rs.getInt("mStaple"),
						rs.getInt("mMain"),
						rs.getInt("mSide"),
						rs.getInt("mOther"),
						rs.getInt("mStaple"),
						rs.getInt("mMain"),
						rs.getInt("mSide"),
						rs.getInt("mOther"),
						rs.getInt("mStaple"),
						rs.getInt("mMain"),
						rs.getInt("mSide"),
						rs.getInt("mOther"),
						rs.getInt("snack"),
						rs.getDate("insertDate"),
						rs.getString("U_id")
						);
				dInfo.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			dInfo = null;
		} finally {
			// dbを切断
			close(conn);
		}

		// 結果を返す
		return dInfo;
	}

	@Override
	public boolean insert(DishInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;

		try {
			conn = conn();

			// SQL文を準備する 上書き
			String sql = "INSERT INTO dishInf(mStaple,mMain,mSide,mOther,nStaple,nMain,nSide,nOther,eStaple,eMain,eSide,eOther,snack,insertDate,u_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_DATE(),?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getmStaple());
			pStmt.setInt(2, dto.getmMain());
			pStmt.setInt(3, dto.getmSide());
			pStmt.setInt(4, dto.getmOther());
			pStmt.setInt(5, dto.getnStaple());
			pStmt.setInt(6, dto.getnMain());
			pStmt.setInt(7, dto.getnSide());
			pStmt.setInt(8, dto.getnOther());
			pStmt.setInt(9, dto.geteStaple());
			pStmt.setInt(10, dto.geteMain());
			pStmt.setInt(11, dto.geteSide());
			pStmt.setInt(12, dto.geteOther());
			pStmt.setInt(13, dto.getSnack());
			pStmt.setString(14,dto.getU_id());

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

	// dishInfテーブルを検索するメソッド
	public List<DishInf> select() {
		// 結果セットを格納するコレクション
		List<DishInf> list = new ArrayList<DishInf>();

		// データベースに接続と切断を行うオブジェクト
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp2?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT di1.name, di1.calorie FROM dishInf AS df\r\n"
					+ "INNER JOIN dish AS di1 ON df.mStaple = di1.id WHERE df.U_id = '00007'\r\n"
					+ "UNION ALL\r\n"
					+ "SELECT di1.name, di1.calorie FROM dishInf AS df\r\n"
					+ "INNER JOIN dish AS di1 ON df.mMain = di1.id WHERE df.U_id = '00007'\r\n"
					+ "UNION ALL\r\n"
					+ "SELECT di1.name, di1.calorie FROM dishInf AS df\r\n"
					+ "INNER JOIN dish AS di1 ON df.mSide = di1.id WHERE df.U_id = '00007'\r\n"
					+ "UNION ALL\r\n"
					+ "SELECT di1.name, di1.calorie FROM dishInf AS df\r\n"
					+ "INNER JOIN dish AS di1 ON df.mOther = di1.id WHERE df.U_id = '00007';";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// SQL文を実行して検索結果を取得する
			ResultSet rs = pstmt.executeQuery();

			// 検索結果をコレクションに格納する
			while (rs.next()) {
				DishInf b = new DishInf(rs.getString("name"), rs.getInt("calorie"));
				list.add(b);
			}

			// 検索結果が格納されたコレクションを返す
			return list;

		} catch (Exception e) {
			// 例外処理
			e.printStackTrace();
			return null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public boolean update(DishInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(DishInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	


}
