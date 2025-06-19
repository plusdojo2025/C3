package dto;

import java.io.Serializable;
import java.util.Date;

public class MonthIncome extends CustomTemplateDto implements Serializable{
	private int id;
	private int mIncome;//円
	private Date insertMonth;
	private String u_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getmIncome() {
		return mIncome;
	}
	public void setmIncome(int mIncome) {
		this.mIncome = mIncome;
	}
	public Date getInsertMonth() {
		return insertMonth;
	}
	public void setInsertMonth(Date insertMonth) {
		this.insertMonth = insertMonth;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public MonthIncome(int id, int mIncome, Date insertMonth, String u_id) {
		super();
		this.id = id;
		this.mIncome = mIncome;
		this.insertMonth = insertMonth;
		this.u_id = u_id;
	}
	public MonthIncome() {
		this(0,0,null,"");
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	
}
