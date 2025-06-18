package dto;

import java.io.Serializable;

public class Dish extends CustomTemplateDto implements Serializable{
	private int id;
	private String name;
	private int calorie;//摂取カロリー
	private int type;//1:主食 2:主菜 3:副菜 4:その他
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public Dish(int id, String name, int calorie, int type) {
		super();
		this.id = id;
		this.name = name;
		this.calorie = calorie;
		this.type = type;
	}
	public Dish() {
		this(0,"",0,0);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	

	
}
