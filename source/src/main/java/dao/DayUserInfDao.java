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
			String sql = "SELECT * FROM dayuserinf WHERE u_id = ? ";
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
			String sql = "INSERT INTO dayuserinf(totalCalorie,dayCalcWeight,insertDate,u_id)VALUES(?,?,CURRENT_DATE(),?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getTotalCalorie());
			pStmt.setDouble(2, dto.getDayCalcWeight());
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
		Connection conn = null;
		boolean result = false;

		try {
			conn = conn();
			// SQL文を準備する 上書き
			String sql = "UPDATE dayuserinf SET totalCalorie=?,dayCalcWeight=? WHERE u_id=? and insertDate = current_date;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getTotalCalorie());//分
			pStmt.setDouble(2, dto.getDayCalcWeight());
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
	public boolean delete(DayUserInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	public double selectDayCalcWeight(String U_id) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		double dayCalcWeight = 0;
		
		try {
			conn = conn();//戻り値Connection型 dbに接続する

			// SQL文を準備する
			String sql = """
					    select round(
						(select dayCalcWeight from dayuserinf where U_id = ? order by id desc limit 1)
						 +
						( 
						COALESCE(
						(select totalCalorie from dayuserinf where U_id = ? order by id desc limit 1 offset 1),
						(select  avgCcalorie 
						from cCalorie cc 
						inner join healthinf hi on 1=1 
						where hi.U_id = '00001' and cc.id = CASE
						  WHEN hi.gender = 'M' AND hi.age < 20 THEN 1
						    WHEN hi.gender = 'M' AND hi.age < 30 THEN 2
						    WHEN hi.gender = 'M' AND hi.age < 40 THEN 3
						    WHEN hi.gender = 'M' AND hi.age < 50 THEN 4
						    WHEN hi.gender = 'M' AND hi.age < 60 THEN 5
						    WHEN hi.gender = 'M' AND hi.age < 70 THEN 6
						    WHEN hi.gender = 'M' AND hi.age < 80 THEN 7
						    WHEN hi.gender = 'M' THEN 8
						    WHEN hi.gender = 'F' AND hi.age < 20 THEN 9
						    WHEN hi.gender = 'F' AND hi.age < 30 THEN 10
						    WHEN hi.gender = 'F' AND hi.age < 40 THEN 11
						    WHEN hi.gender = 'F' AND hi.age < 50 THEN 12
						    WHEN hi.gender = 'F' AND hi.age < 60 THEN 13
						    WHEN hi.gender = 'F' AND hi.age < 70 THEN 14
						    WHEN hi.gender = 'F' AND hi.age < 80 THEN 15
						    WHEN hi.gender = 'F' THEN 16
						  END
						))
						 - 
						COALESCE((select cCalorie from schedule where U_id = ? order by id desc limit 1 offset 0),0)
						 -
						COALESCE((select cCalorie from schedule where U_id = ? order by id desc limit 1 offset 1),0)
						-
						((select metaRate from healthinf where U_id = ? order by id desc limit 1 ) * 1.5 ))/7200 ,1 ) dayCalcWeight
						""";

					
					
					
					
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,U_id);
			pStmt.setString(2,U_id);
			pStmt.setString(3,U_id);
			pStmt.setString(4,U_id);
			pStmt.setString(5,U_id);

			// SQL文を実行し、結果を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 結果を1行ずつコレクションにコピーする
			while (rs.next()) {
				dayCalcWeight = rs.getDouble("dayCalcWeight");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			dayCalcWeight= 0;
		} finally {
			// dbを切断
			close(conn);
		}
		
		return dayCalcWeight;
	}

}
