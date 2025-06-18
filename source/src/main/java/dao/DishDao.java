package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Dish;

public class DishDao extends CustomTemplateDao<Dish> {

	@Override
	public List<Dish> select(Dish dto) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean insert(Dish dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(Dish dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(Dish dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	// 主食：DishInfテーブルを検索するメソッド
	public List<Dish> select() {
		// 結果セットを格納するコレクション
		List<Dish> list = new ArrayList<Dish>();

		// データベースに接続と切断を行うオブジェクト
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c3"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "select * from dish where type = 1;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// SQL文を実行して検索結果を取得する
			ResultSet rs = pstmt.executeQuery();
			// 検索結果をコレクションに格納する
			while (rs.next()) {
				Dish b = new Dish(rs.getInt("id"), rs.getString("name"), rs.getInt("colorie"), rs.getInt("type"));
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

}
