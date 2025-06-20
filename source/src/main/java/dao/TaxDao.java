package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dto.Tax;

public class TaxDao extends CustomTemplateDao<Tax> {

	@Override
	public List<Tax> select(Tax dto) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean insert(Tax dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(Tax dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(Tax dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	public int gTax(int gIncome,String dependent) {//目標年収-税金
		Connection conn = null;
		int tax = 0;
		int taxNo =1;
		try {
			conn = conn();
			
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
			else if(gIncome <= 299) {
				if(dependent.equals("NO")) {
					taxNo = 7; 
				} 
				else { 
					taxNo =8; 
				} 
			}
			else if(gIncome <= 399) {
				if(dependent.equals("NO")) {
					taxNo = 9;
				}
				else {
					taxNo = 10;
				} 
			} 
			else if(gIncome <= 499) { 
				if(dependent.equals("NO")) {
					taxNo = 11; 
				} 
				else {
					taxNo = 12; 
				} 
			} 
			else if(gIncome <= 599) {
				if(dependent.equals("NO")) {
					taxNo = 13;
					  } 
				else {
					taxNo = 14;
				} 
			} 
			else if(gIncome <= 699) {
				if(dependent.equals("NO")) { 
					taxNo = 15; 
				}
				else {
					taxNo= 16;
				} 
			} 
			else if(gIncome <= 799) {
				if(dependent.equals("NO")) {
					taxNo = 17;
				}
				else { 
					taxNo = 18;
				} 
			} 
			else if(gIncome <= 899) { 
				if(dependent.equals("NO")) { 
					taxNo = 19; 
				} 
				else {
					taxNo = 20;
				} 
			}
			else {
				if(dependent.equals("NO")) {
					taxNo = 21; 
				}
				else {
					taxNo = 22; 
				} 
			}
			
			 String sql = "SELECT tax FROM tax WHERE id = ?;";
			 PreparedStatement pStmt0 = conn.prepareStatement(sql);
			 pStmt0.setInt(1,taxNo);
			 
			 ResultSet rs = pStmt0.executeQuery(); 
			 while(rs.next()) {
				 tax = rs.getInt("tax");
			 }
			
		} catch (SQLException e) {
		e.printStackTrace();
		return 0;
	} finally {
		// dbを切断
		close(conn);
	}
		  		
		return tax;
	}

}
