package dto;

import java.io.Serializable;

public class Ccalorie extends CustomTemplateDto implements Serializable{
	private int id;//16パターン
	private int avgCcalorie;//初週で使う消費カロリー
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAvgCcalorie() {
		return avgCcalorie;
	}
	public void setAvgCcalorie(int avgCcalorie) {
		this.avgCcalorie = avgCcalorie;
	}
	public Ccalorie(int id, int avgCcalorie) {
		super();
		this.id = id;
		this.avgCcalorie = avgCcalorie;
	}
	public Ccalorie() {
		this(0,0);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	
}
