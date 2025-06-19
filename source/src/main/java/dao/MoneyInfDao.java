package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MoneyInf;

public class MoneyInfDao extends CustomTemplateDao<MoneyInf> {

	@Override
	public List<MoneyInf> select(MoneyInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		List<MoneyInf> mInfo = new ArrayList<MoneyInf>();//不定の配列

		try {
			conn = conn();//戻り値Connection型 dbに接続する

			// SQL文を準備する
			String sql = "SELECT * FROM MoneyInf WHERE u_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,dto.getU_id());

			// SQL文を実行し、結果を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果を1行ずつコレクションにコピーする
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
			// dbを切断
			close(conn);
		}

		// 結果を返す
		return mInfo;
	}

	@Override
	public boolean insert(MoneyInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;

		try {
			conn = conn();
			/*
			 * int gIncome = dto.getgIncome(); int hWage = dto.gethWage(); int wWork =
			 * dto.getwWork(); String dependent = dto.getDependent(); int taxNo = 1;
			 * 
			 * //仮置き if(gIncome <= 102) { if(dependent.equals("NO")) { taxNo = 1; } else {
			 * taxNo = 2; } } else if(gIncome <= 129) { if(dependent.equals("NO")) { taxNo =
			 * 3; } else { taxNo = 4; } } else if(gIncome <= 149) {
			 * if(dependent.equals("NO")) { taxNo = 5; } else { taxNo = 6; } } else
			 * if(gIncome <= 299) { if(dependent.equals("NO")) { taxNo = 7; } else { taxNo =
			 * 8; } } else if(gIncome <= 399) { if(dependent.equals("NO")) { taxNo = 9; }
			 * else { taxNo = 10; } } else if(gIncome <= 499) { if(dependent.equals("NO")) {
			 * taxNo = 11; } else { taxNo = 12; } } else if(gIncome <= 599) {
			 * if(dependent.equals("NO")) { taxNo = 13; } else { taxNo = 14; } } else
			 * if(gIncome <= 699) { if(dependent.equals("NO")) { taxNo = 15; } else { taxNo
			 * = 16; } } else if(gIncome <= 799) { if(dependent.equals("NO")) { taxNo = 17;
			 * } else { taxNo = 18; } } else if(gIncome <= 899) { if(dependent.equals("NO"))
			 * { taxNo = 19; } else { taxNo = 20; } } else if(gIncome <= 1000) {
			 * if(dependent.equals("NO")) { taxNo = 21; } else { taxNo = 22; } }
			 * 
			 * String sql0 = "SELECT tax FROM tax WHERE id = ?"; PreparedStatement pStmt0 =
			 * conn.prepareStatement(sql0); pStmt0.setInt(1,taxNo);
			 * 
			 * ResultSet rs = pStmt0.executeQuery(); int netIncome = gIncome -
			 * rs.getInt("tax"); //
			 * 
			 * 
			 * //仮置き 一日辺りの労働時間 int kari = gIncome/12; kari = kari/4; int workTime =
			 * kari/hWage; int dWork = workTime/wWork; //ここまで
			 */
			// SQL文を準備する 上書き
			String sql = "INSERT INTO MoneyInf(gIncome,hWage,wWork,dependent,netIncome,dWork,u_id)VALUES(?,?,?,?,?,?,?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getgIncome());
			pStmt.setInt(2, dto.gethWage());
			pStmt.setInt(3, dto.getwWork());
			pStmt.setString(4, dto.getDependent());
			pStmt.setInt(5,100);//目標年収-税金
			pStmt.setInt(6,2);//
			pStmt.setString(7,dto.getU_id());

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
	public boolean update(MoneyInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;

		try {
			conn = conn();
			/*
			 * int gIncome = dto.getgIncome(); int hWage = dto.gethWage(); int wWork =
			 * dto.getwWork(); String dependent = dto.getDependent(); int taxNo = 0;
			 * 
			 * //仮置き if(gIncome <= 102) { if(dependent.equals("NO")) { taxNo = 1; } else {
			 * taxNo = 2; } } else if(gIncome <= 129) { if(dependent.equals("NO")) { taxNo =
			 * 3; } else { taxNo = 4; } } else if(gIncome <= 149) {
			 * if(dependent.equals("NO")) { taxNo = 5; } else { taxNo = 6; } } if(gIncome <=
			 * 299) { if(dependent.equals("NO")) { taxNo = 7; } else { taxNo = 8; } }
			 * if(gIncome <= 399) { if(dependent.equals("NO")) { taxNo = 9; } else { taxNo =
			 * 10; } } if(gIncome <= 499) { if(dependent.equals("NO")) { taxNo = 11; } else
			 * { taxNo = 12; } } if(gIncome <= 599) { if(dependent.equals("NO")) { taxNo =
			 * 13; } else { taxNo = 14; } } if(gIncome <= 699) { if(dependent.equals("NO"))
			 * { taxNo = 15; } else { taxNo = 16; } } if(gIncome <= 799) {
			 * if(dependent.equals("NO")) { taxNo = 17; } else { taxNo = 18; } } if(gIncome
			 * <= 899) { if(dependent.equals("NO")) { taxNo = 19; } else { taxNo = 20; } }
			 * if(gIncome <= 1000) { if(dependent.equals("NO")) { taxNo = 21; } else { taxNo
			 * = 22; } }
			 * 
			 * String sql0 = "SELECT tax FROM tax WHERE id = ?"; PreparedStatement pStmt0 =
			 * conn.prepareStatement(sql0); pStmt0.setInt(1,taxNo);
			 * 
			 * ResultSet rs = pStmt0.executeQuery(); int netIncome = gIncome -
			 * rs.getInt("tax"); //
			 * 
			 * 
			 * //仮置き 一日辺りの労働時間 int kari = gIncome/12; kari = kari/4; int workTime =
			 * kari/hWage; int dWork = workTime/wWork; //ここまで
			 */
			// SQL文を準備する 上書き
			String sql = "UPDATE moneyInf SET gIncome=?,hWage=?,wWork=?,dependent=?,netIncome=?,dWork=? WHERE u_id=?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getgIncome());
			pStmt.setInt(2, dto.gethWage());
			pStmt.setInt(3, dto.getwWork());
			pStmt.setString(4, dto.getDependent());
			pStmt.setInt(5,0);//目標年収-税金
			pStmt.setInt(6,0);//
			pStmt.setString(7,dto.getU_id());

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
	public boolean delete(MoneyInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	public boolean insertComp(MoneyInf dto,int tax) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;
		int gIncome = dto.getgIncome();
		int hWage = dto.gethWage();
		int wWork = dto.getwWork();

		try {
			conn = conn();
			 int netIncome = gIncome - tax;
			
			  //仮置き 一日辺りの労働時間 
			 int kari = gIncome/12; 
			 kari = kari/4;
			 int workTime =kari/hWage; 
			 int dWork = workTime/wWork; //ここまで
			
			// SQL文を準備する 上書き
			String sql = "INSERT INTO MoneyInf(gIncome,hWage,wWork,dependent,netIncome,dWork,u_id)VALUES(?,?,?,?,?,?,?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1,gIncome);
			pStmt.setInt(2,hWage);
			pStmt.setInt(3,wWork);
			pStmt.setString(4, dto.getDependent());
			pStmt.setInt(5,netIncome);//目標年収-税金
			pStmt.setInt(6,dWork);//1日あたりの労働時間
			pStmt.setString(7,dto.getU_id());

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

}
