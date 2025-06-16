package dto;

import java.io.Serializable;

public class MoneyInf extends CustomTemplateDto implements Serializable{
	private int id;
	private int gIncome;//目標年収
	private int hWage;//時給
	private int wWork;//一週間の労働日数
	private String dependent;//扶養YESorNO
	private int netIncome;//推定手取り
	private int dWork;//一日あたりの労働時間
	private String u_id;//ユーザーID
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getgIncome() {
		return gIncome;
	}
	public void setgIncome(int gIncome) {
		this.gIncome = gIncome;
	}
	public int gethWage() {
		return hWage;
	}
	public void sethWage(int hWage) {
		this.hWage = hWage;
	}
	public int getwWork() {
		return wWork;
	}
	public void setwWork(int wWork) {
		this.wWork = wWork;
	}
	public String getDependent() {
		return dependent;
	}
	public void setDependent(String dependent) {
		this.dependent = dependent;
	}
	public int getNetIncome() {
		return netIncome;
	}
	public void setNetIncome(int netIncome) {
		this.netIncome = netIncome;
	}
	public int getdWork() {
		return dWork;
	}
	public void setdWork(int dWork) {
		this.dWork = dWork;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public MoneyInf(int id, int gIncome, int hWage, int wWork, String dependent, int netIncome, int dWork,
			String u_id) {
		super();
		this.id = id;
		this.gIncome = gIncome;
		this.hWage = hWage;
		this.wWork = wWork;
		this.dependent = dependent;
		this.netIncome = netIncome;
		this.dWork = dWork;
		this.u_id = u_id;
	}
	public MoneyInf() {
		this(0,0,0,0,"",0,0,"");
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	

}
