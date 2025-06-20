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
	public List<DishInf> selectByDate(String userId, String date) {
		  List<DishInf> list = new ArrayList<>();
		  Connection conn = null;
		  try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp2?useSSL=false&serverTimezone=JST", "root", "password");

		    String sql = """
		        SELECT di1.name, di1.calorie FROM dishInf AS df
		        LEFT JOIN dish AS di1 ON df.mStaple = di1.id
		        WHERE df.U_id = ? AND df.insertDate = ?
		        UNION ALL
		        SELECT di1.name, di1.calorie FROM dishInf AS df
		        LEFT JOIN dish AS di1 ON df.mMain = di1.id
		        WHERE df.U_id = ? AND df.insertDate = ?
		        UNION ALL
		        SELECT di1.name, di1.calorie FROM dishInf AS df
		        LEFT JOIN dish AS di1 ON df.mSide = di1.id
		        WHERE df.U_id = ? AND df.insertDate = ?
		        UNION ALL
		        SELECT di1.name, di1.calorie FROM dishInf AS df
		        LEFT JOIN dish AS di1 ON df.snack = di1.id
		        WHERE df.U_id = ? AND df.insertDate = ?
		        """;

		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    for (int i = 0; i < 4; i++) {
		      pstmt.setString(i * 2 + 1, userId);
		      pstmt.setString(i * 2 + 2, date);
		    }

		    ResultSet rs = pstmt.executeQuery();
		    while (rs.next()) {
		      list.add(new DishInf(rs.getString("name"), rs.getInt("calorie")));
		    }
		    return list;
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    try {
		      if (conn != null) conn.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
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
