package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.HealthInf;

public class HealthInfDao extends CustomTemplateDao<HealthInf> {
	

	@Override
	public List<HealthInf> select(HealthInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		List<HealthInf> hInfo = new ArrayList<HealthInf>();//不定の配列

		try {
			conn = conn();//戻り値Connection型 dbに接続する

			// SQL文を準備する
			String sql = "SELECT * FROM healthinf WHERE u_id = ? order by id desc limit 1;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,dto.getU_id());

			// SQL文を実行し、結果を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果を1行ずつコレクションにコピーする
			while (rs.next()) {
				HealthInf us = new HealthInf(
						rs.getInt("id"), //テーブルの列名
						rs.getInt("iWeight"),
						rs.getInt("cWeight"),
						rs.getInt("height"),
						rs.getInt("age"),
						rs.getString("gender"),
						rs.getInt("term"),
						rs.getInt("wMotionDays"),
						rs.getInt("dMotionTime"),
						rs.getInt("lwCcalorie"),
						rs.getInt("lwIcalorie"),
						rs.getInt("metaRate"),
						rs.getString("u_id")
						);
				hInfo.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			hInfo = null;
		} finally {
			// dbを切断
			close(conn);
		}

		// 結果を返す
		return hInfo;
	}
	
	// つけたし
	public List<HealthInf> select1() {
		// 結果セットを格納するコレクション
				List<HealthInf> hInfo = new ArrayList<HealthInf>();

				// データベースに接続と切断を行うオブジェクト
				Connection conn = null;

				try {
					conn = conn();

					// SQL文を準備する
					String sql = "SELECT * FROM healthinf WHERE u_id = ?; ";
					PreparedStatement pstmt = conn.prepareStatement(sql);

					// SQL文を実行して検索結果を取得する
					ResultSet rs = pstmt.executeQuery();
					// 検索結果をコレクションに格納する
					while (rs.next()) {
						HealthInf us = new HealthInf(
								rs.getInt("id"), //テーブルの列名
								rs.getInt("iWeight"),
								rs.getInt("cWeight"),
								rs.getInt("height"),
								rs.getInt("age"),
								rs.getString("gender"),
								rs.getInt("term"),
								rs.getInt("wMotionDays"),
								rs.getInt("dMotionTime"),
								rs.getInt("lwCcalorie"),
								rs.getInt("lwIcalorie"),
								rs.getInt("metaRate"),
								rs.getString("u_id")
								);
						hInfo.add(us);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					// データベースを切断
					close(conn);
				}
				// 検索結果が格納されたコレクションを返す
				return hInfo;
			}
	// ここまで
	
	@Override
	public boolean insert(HealthInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;
		double metaRate;
		int metaRatei;
		double conCal;//日常で消費するカロリー
		int lowerCal;//期間中に減らす全カロリー
		int weekCal;//一週間で必要な差分カロリー
		int age = dto.getAge();
		int cId;
		int avgCal = 0;//初週
		int dayCal;//一日で必要な運動消費カロリー
		double dMotionTime;
		int dMotionTimei;
		
		final double RATE = 0.5473;

		try {
			conn = conn();
			
			//基礎代謝量の計算
			metaRate = 0.1238+(0.0481*dto.getcWeight())+(0.0234*dto.getHeight())-(0.0138*age);
			if(dto.getGender().equals("M")) {//男
				metaRate = (metaRate - RATE)*1000/4.186;
			}
			else {//女
				metaRate = (metaRate - (RATE*2))*1000/4.186;
			}
			metaRatei = (int)metaRate;
			//
			
			//１週間の運動時間の計算　一日あたり
			conCal = metaRatei * 1.5;
			lowerCal = (dto.getcWeight() - dto.getiWeight())*7200;
			weekCal = lowerCal/(dto.getTerm()/7);
			
			
			//男女年齢別平均摂取カロリー
			if(dto.getGender().equals("M")) {//男
				if(age < 20) {
					cId = 1;
				}
				else if(age < 30) {
					cId = 2;
				}
				else if(age < 40) {
					cId = 3;
				}
				else if(age < 50) {
					cId = 4;
				}
				else if(age < 60) {
					cId = 5;
				}
				else if(age < 70) {
					cId = 6;
				}
				else if(age < 80) {
					cId = 7;
				}
				else {
					cId = 8;
				}
			}
			else {
				if(age < 20) {
					cId = 9;
				}
				else if(age < 30) {
					cId = 10;
				}
				else if(age < 40) {
					cId = 11;
				}
				else if(age < 50) {
					cId = 12;
				}
				else if(age < 60) {
					cId = 13;
				}
				else if(age < 70) {
					cId = 14;
				}
				else if(age < 80) {
					cId = 15;
				}
				else {
					cId = 16;
				}
			}
			String sql0 = "SELECT avgCcalorie from cCalorie WHERE id = ?;" ;
			PreparedStatement pStmt0 = conn.prepareStatement(sql0);
			pStmt0.setInt(1,cId);
			ResultSet rs = pStmt0.executeQuery();
			if (rs.next()) {
				avgCal = rs.getInt("avgCcalorie");
			}
			
			dayCal = (avgCal * 7 + weekCal - (int)conCal * 7)/dto.getwMotionDays();
			dMotionTime = dayCal / (4*dto.getcWeight()*1.05) * 60;
			dMotionTimei = (int)dMotionTime;


			// SQL文を準備する 上書き
			String sql = "INSERT INTO healthinf(iWeight,cWeight,height,age,gender,term,wMotionDays,dMotionTime,lwCcalorie,lwIcalorie,metaRate,u_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setInt(1, dto.getiWeight());
				pStmt.setInt(2, dto.getcWeight());
				pStmt.setInt(3, dto.getHeight());
				pStmt.setInt(4, age);
				pStmt.setString(5, dto.getGender());
				pStmt.setInt(6, dto.getTerm());
				pStmt.setInt(7, dto.getwMotionDays());
				pStmt.setInt(8, dMotionTimei);
				pStmt.setInt(9, avgCal);//lwCcalorie
				pStmt.setInt(10,0);//lwIcalorie
				pStmt.setInt(11,metaRatei);
				pStmt.setString(12, dto.getU_id());
			

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
	public boolean update(HealthInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;
		double metaRate;
		int metaRatei;
		double conCal;//日常で消費するカロリー
		int lowerCal;//期間中に減らす全カロリー
		int weekCal;//一週間で必要な差分カロリー
		int age = dto.getAge();
		int dayCal;//一日で必要な運動消費カロリー
		double dMotionTime;
		int dMotionTimei;
		
		final double RATE = 0.5473;

		try {
			conn = conn();
			//基礎代謝量の計算
			metaRate = 0.1238+(0.0481*dto.getcWeight())+(0.0234*dto.getHeight())-(0.0138*age);
			if(dto.getGender().equals("M")) {//男
				metaRate = (metaRate - RATE)*1000/4.186;
			}
			else {//女
				metaRate = (metaRate - (RATE*2))*1000/4.186;
			}
			metaRatei = (int)metaRate;
			//
			
			//１週間の運動時間の計算　一日あたり
			conCal = metaRatei * 1.5;
			lowerCal = (dto.getcWeight() - dto.getiWeight())*7200;
			weekCal = lowerCal/(dto.getTerm()/7);
			

			dayCal = (dto.getLwIcalorie() + weekCal - (int)conCal * 7)/dto.getwMotionDays();
			dMotionTime = dayCal / (4*dto.getcWeight()*1.05) * 60;
			dMotionTimei = (int)dMotionTime;
			//


			// SQL文を準備する 上書き
			String sql =  "UPDATE healthinf SET iWeight=?,cWeight=?,height=?,age=?,gender=?,term=?,wMotionDays=?,dMotionTime=?,lwCcalorie=?,lwIcalorie=?,metaRate=? WHERE u_id=?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (dto.getiWeight() != 0) {
				pStmt.setInt(1, dto.getiWeight());
			} else {
				pStmt.setInt(1, 0);
			}
			if (dto.getcWeight() != 0) {
				pStmt.setInt(2, dto.getcWeight());
			} else {
				pStmt.setInt(2, 0);
			}
			if (dto.getHeight() != 0) {
				pStmt.setInt(3, dto.getHeight());
			} else {
				pStmt.setInt(3, 0);
			}
			if (dto.getAge() != 0) {
				pStmt.setInt(4, dto.getAge());
			} else {
				pStmt.setInt(4, 0);
			}
			if (dto.getGender() != null) {
				pStmt.setString(5, dto.getGender());
			} else {
				pStmt.setString(5, "");
			}
			if (dto.getTerm() != 0) {
				pStmt.setInt(6, dto.getTerm());
			} else {
				pStmt.setInt(6, 0);
			}
			if (dto.getwMotionDays() != 0) {
				pStmt.setInt(7, dto.getwMotionDays());
			} else {
				pStmt.setInt(7, 0);
			}
			if (dto.getdMotionTime() != 0) {
				pStmt.setInt(8,dMotionTimei);
			} else {
				pStmt.setInt(8, 0);
			}
			if (dto.getLwCcalorie() != 0) {
				pStmt.setInt(9, dto.getLwCcalorie());
			} else {
				pStmt.setInt(9, 0);
			}
			if (dto.getLwIcalorie() != 0) {
				pStmt.setInt(10, dto.getLwIcalorie());
			} else {
				pStmt.setInt(10, 0);
			}
			if (dto.getMetaRate() != 0) {
				pStmt.setInt(11, dto.getMetaRate());
			} else {
				pStmt.setInt(11, 0);
			}
			pStmt.setString(12, dto.getU_id());
		
			

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
	public boolean delete(HealthInf dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	public boolean updateCalorie(int lwCcal ,int lwIcal,String uId) {//先週の消費　先週の摂取
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;

		try {
			conn = conn();
			
			// SQL文を準備する 上書き
			String sql =  "UPDATE healthinf SET lwCcalorie=?,lwIcalorie=? WHERE u_id=?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setInt(1,lwCcal);
				pStmt.setInt(2,lwIcal);
				pStmt.setString(3,uId);

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
	
	public boolean isOneData(String u_id) {
		Connection conn = null;
		boolean Result = false;

		try {
			conn = conn();

			// SELECT文を準備する
			String sql = "SELECT count(*) FROM healthInf WHERE u_id=? ;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, u_id);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				Result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Result = false;
		} finally {
			// データベースを切断
			close(conn);
		}
		
		// 結果を返す
		return Result;
	}

	

}
