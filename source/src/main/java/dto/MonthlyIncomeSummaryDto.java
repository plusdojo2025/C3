package dto;

import java.io.Serializable;

public class MonthlyIncomeSummaryDto extends CustomTemplateDto implements Serializable {
	private String u_id;//ユーザーID
	private String workMonth;
	private double estimatedMonthlyIncome;
	private int hWage;
	private int totalMonthlyWorkHours;
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getWorkMonth() {
		return workMonth;
	}
	public void setWorkMonth(String workMonth) {
		this.workMonth = workMonth;
	}
	public double getEstimatedMonthlyIncome() {
		return estimatedMonthlyIncome;
	}
	public void setEstimatedMonthlyIncome(double estimatedMonthlyIncome) {
		this.estimatedMonthlyIncome = estimatedMonthlyIncome;
	}
	public int gethWage() {
		return hWage;
	}
	public void sethWage(int hWage) {
		this.hWage = hWage;
	}
	public int getTotalMonthlyWorkHours() {
		return totalMonthlyWorkHours;
	}
	public void setTotalMonthlyWorkHours(int totalMonthlyWorkHours) {
		this.totalMonthlyWorkHours = totalMonthlyWorkHours;
	}
	public MonthlyIncomeSummaryDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public MonthlyIncomeSummaryDto(String u_id, String workMonth, double estimatedMonthlyIncome, int hWage,
			int totalMonthlyWorkHours) {
		this.u_id = u_id;
		this.workMonth = workMonth;
		this.estimatedMonthlyIncome = estimatedMonthlyIncome;
		this.hWage = hWage;
		this.totalMonthlyWorkHours = totalMonthlyWorkHours;
	}
}

