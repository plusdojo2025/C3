package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dto.MoneyInf;

public class MoneyInfDao extends CustomTemplateDao<MoneyInf> {

	@Override
	public List<MoneyInf> select(MoneyInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean insert(MoneyInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;

		try {
			conn = conn();
			int gIncome = dto.getgIncome();
			int hWage = dto.gethWage();
			int wWork = dto.getwWork();
			String dependent = dto.getDependent();
			int taxNo = 0;
			
			//仮置き
			if(gIncome <= 102) {
				if(dependent.equals("NO")) {
					taxNo = 1;
				}
				else {
					taxNo = 2;
				}
			}
			else if(gIncome <= 129) {
				if(dependent.equals("NO")) {
					taxNo = 3;
				}
				else {
					taxNo = 4;
				}
			}
			else if(gIncome <= 149) {
				if(dependent.equals("NO")) {
					taxNo = 5;
				}
				else {
					taxNo = 6;
				}
			}

			String sql = "SELECT tax FROM tax WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,taxNo);
			
			ResultSet rs = pStmt.executeQuery();
			int netIncome = gIncome - rs.getInt("tax");
			//
				
			
			//仮置き　一日辺りの労働時間
			int kari = gIncome/12;
			kari = kari/4;
			int workTime = kari/hWage;
			int dWork = workTime/wWork;
			//ここまで

			// SQL文を準備する 上書き
			sql = "INSERT INTO MoneyInf(gIncome,hWage,wWork,dependent,netIncome,dWork,u_id)VALUES(?,?,?,?,?,?,?);";
			pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getgIncome());
			pStmt.setInt(2, dto.gethWage());
			pStmt.setInt(3, dto.getwWork());
			pStmt.setString(4, dto.getDependent());
			pStmt.setInt(5,netIncome);//目標年収-税金
			pStmt.setInt(6,dWork);//
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
	public boolean update(MoneyInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(MoneyInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
