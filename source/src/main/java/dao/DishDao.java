package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Dish;

public class DishDao extends CustomTemplateDao<Dish> {
	public Map<Integer,Integer> select() {
		// TODO 自動生成されたメソッド・スタブ
		// 結果セットを格納するコレクション
		Map<Integer,Integer> list = new HashMap<>();

		// データベースに接続と切断を行うオブジェクト
		Connection conn = null;

		try {
			conn = conn();

			// SQL文を準備する
			String sql = "select * from dish;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// SQL文を実行して検索結果を取得する
			ResultSet rs = pstmt.executeQuery();
			// 検索結果をコレクションに格納する
			while (rs.next()) {
				Dish b = new Dish(rs.getInt("id"), rs.getString("name"), rs.getInt("calorie"), rs.getInt("type"));
				list.put(b.getId(),b.getCalorie());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			close(conn);
		}
		// 検索結果が格納されたコレクションを返す
		return list;
	}
	
	@Override
	public List<Dish> select(Dish dto) {
		// TODO 自動生成されたメソッド・スタブ
		// 結果セットを格納するコレクション
		List<Dish> list = new ArrayList<Dish>();

		// データベースに接続と切断を行うオブジェクト
		Connection conn = null;

		try {
			conn = conn();

			// SQL文を準備する
			String sql = "select * from dish;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// SQL文を実行して検索結果を取得する
			ResultSet rs = pstmt.executeQuery();
			// 検索結果をコレクションに格納する
			while (rs.next()) {
				Dish b = new Dish(rs.getInt("id"), rs.getString("name"), rs.getInt("calorie"), rs.getInt("type"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			close(conn);
		}
		// 検索結果が格納されたコレクションを返す
		return list;
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
	public List<Dish> select1() {
		// 結果セットを格納するコレクション
		List<Dish> list = new ArrayList<Dish>();

		// データベースに接続と切断を行うオブジェクト
		Connection conn = null;

		try {
			conn = conn();

			// SQL文を準備する
			String sql = "select * from dish where type = 1;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// SQL文を実行して検索結果を取得する
			ResultSet rs = pstmt.executeQuery();
			// 検索結果をコレクションに格納する
			while (rs.next()) {
				Dish b = new Dish(rs.getInt("id"), rs.getString("name"), rs.getInt("calorie"), rs.getInt("type"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			close(conn);
		}
		// 検索結果が格納されたコレクションを返す
		return list;
	}
	
	//主菜の情報
	public List<Dish> select2() {
		// 結果セットを格納するコレクション
		List<Dish> list = new ArrayList<Dish>();

		// データベースに接続と切断を行うオブジェクト
		Connection conn = null;

		try {
			conn = conn();

			// SQL文を準備する
			String sql = "select * from dish where type = 2;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// SQL文を実行して検索結果を取得する
			ResultSet rs = pstmt.executeQuery();
			// 検索結果をコレクションに格納する
			while (rs.next()) {
				Dish b = new Dish(rs.getInt("id"), rs.getString("name"), rs.getInt("calorie"), rs.getInt("type"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			close(conn);
		}
		// 検索結果が格納されたコレクションを返す
		return list;
	}
	
	//副菜の情報
	public List<Dish> select3() {
		// 結果セットを格納するコレクション
		List<Dish> list = new ArrayList<Dish>();

		// データベースに接続と切断を行うオブジェクト
		Connection conn = null;

		try {
			conn = conn();

			// SQL文を準備する
			String sql = "select * from dish where type = 3;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// SQL文を実行して検索結果を取得する
			ResultSet rs = pstmt.executeQuery();
			// 検索結果をコレクションに格納する
			while (rs.next()) {
				Dish b = new Dish(rs.getInt("id"), rs.getString("name"), rs.getInt("calorie"), rs.getInt("type"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			close(conn);
		}
		// 検索結果が格納されたコレクションを返す
		return list;
	}
	
	//その他の情報
	public List<Dish> select4() {
		// 結果セットを格納するコレクション
		List<Dish> list = new ArrayList<Dish>();

		// データベースに接続と切断を行うオブジェクト
		Connection conn = null;

		try {
			conn = conn();

			// SQL文を準備する
			String sql = "select * from dish where type = 4;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// SQL文を実行して検索結果を取得する
			ResultSet rs = pstmt.executeQuery();
			// 検索結果をコレクションに格納する
			while (rs.next()) {
				Dish b = new Dish(rs.getInt("id"), rs.getString("name"), rs.getInt("calorie"), rs.getInt("type"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			close(conn);
		}
		// 検索結果が格納されたコレクションを返す
		return list;
	}
}
