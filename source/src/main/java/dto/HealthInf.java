package dto;

import java.io.Serializable;

public class HealthInf extends CustomTemplateDto implements Serializable{
	private int id;
	private int iWeight;//目標体重
	private int cWeight;//現在体重
	private int height;
	private int age;
	private String gender;//男女 "M"or"F"
	private int term;//目標体重の到達にかける日数
	private int wMotionDays;//一週間の内運動できる日数
	private int dMotionTime;//１日あたりの運動時間 分
	private int lwCcalorie;//先週の消費カロリー kcal
	private int lwIcalorie;//先週の摂取カロリー kcal
	private int metaRate;//基礎代謝
	private String u_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getiWeight() {
		return iWeight;
	}
	public void setiWeight(int iWeight) {
		this.iWeight = iWeight;
	}
	public int getcWeight() {
		return cWeight;
	}
	public void setcWeight(int cWeight) {
		this.cWeight = cWeight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public int getwMotionDays() {
		return wMotionDays;
	}
	public void setwMotionDays(int wMotionDays) {
		this.wMotionDays = wMotionDays;
	}
	public int getdMotionTime() {
		return dMotionTime;
	}
	public void setdMotionTime(int dMotionTime) {
		this.dMotionTime = dMotionTime;
	}
	public int getLwCcalorie() {
		return lwCcalorie;
	}
	public void setLwCcalorie(int lwCcalorie) {
		this.lwCcalorie = lwCcalorie;
	}
	public int getLwIcalorie() {
		return lwIcalorie;
	}
	public void setLwIcalorie(int lwIcalorie) {
		this.lwIcalorie = lwIcalorie;
	}
	public int getMetaRate() {
		return metaRate;
	}
	public void setMetaRate(int metaRate) {
		this.metaRate = metaRate;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public HealthInf(int id, int iWeight, int cWeight, int height, int age, String gender, int term, int wMotionDays,
			int dMotionTime, int lwCcalorie, int lwIcalorie, int metaRate, String u_id) {
		super();
		this.id = id;
		this.iWeight = iWeight;
		this.cWeight = cWeight;
		this.height = height;
		this.age = age;
		this.gender = gender;
		this.term = term;
		this.wMotionDays = wMotionDays;
		this.dMotionTime = dMotionTime;
		this.lwCcalorie = lwCcalorie;
		this.lwIcalorie = lwIcalorie;
		this.metaRate = metaRate;
		this.u_id = u_id;
	}
	public HealthInf() {
		this(0,0,0,0,0,"",0,0,0,0,0,0,"");
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	
	
	
}
