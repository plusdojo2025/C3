package dto;

import java.io.Serializable;

public class Tax extends CustomTemplateDto implements Serializable{
	private int id;
	private int tax;
	
	//ゲッター＆セッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	
	//コンストラクタ
	public Tax(int id, int tax) {
		super();
		this.id = id;
		this.tax = tax;
	}
	public Tax() {
		this(0,0);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	

}
