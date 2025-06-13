package dto;

import java.io.Serializable;//Beansのお約束

public class users extends CustomTemplateDto implements Serializable{
	private String id;//dbのテーブルと同じ
	private String pass;
	private String name;

	//ゲッター＆セッター
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//コンストラクタ
	public users(String id, String pass, String name) {//ソース→フィールドを使用して
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
	}

	//コンストラクタ
	public users() {//ソース→スーパークラスから
		this("","","");
		// TODO 自動生成されたコンストラクター・スタブ
	}
}
