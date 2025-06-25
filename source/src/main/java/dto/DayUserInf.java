package dto;

import java.io.Serializable;
import java.util.Date;

public class DayUserInf extends CustomTemplateDto implements Serializable{
	private int id;
	private int totalCalorie;//kcal
	private double dayCalcWeight;//キロ
	private Date insertDate;
	private String u_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalCalorie() {
		return totalCalorie;
	}
	public void setTotalCalorie(int totalCalorie) {
		this.totalCalorie = totalCalorie;
	}
	public double getDayCalcWeight() {
		return dayCalcWeight;
	}
	public void setDayCalcWeight(double dayCalcWeight) {
		this.dayCalcWeight = dayCalcWeight;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public DayUserInf(int id, int totalCalorie, double dayCalcWeight, Date insertDate, String u_id) {
		super();
		this.id = id;
		this.totalCalorie = totalCalorie;
		this.dayCalcWeight = dayCalcWeight;
		this.insertDate = insertDate;
		this.u_id = u_id;
	}
	public DayUserInf() {
		this(0,0,0,null,"");
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	
}
