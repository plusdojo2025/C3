package dto;

import java.io.Serializable;
import java.util.Date;

public class DishInf extends CustomTemplateDto implements Serializable{
	private int id;
	private int mStaple;//主食
	private int mMain;//主菜
	private int mSide;//副菜
	private int mOther;//その他
	private int nStaple;//主食
	private int nMain;//主菜
	private int nSide;//副菜
	private int nOther;//その他
	private int eStaple;//主食
	private int eMain;//主菜
	private int eSide;//副菜
	private int eOther;//その他
	private int snack;//間食　その他のみ
	private Date insertDate;//登録した日付
	private String u_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getmStaple() {
		return mStaple;
	}
	public void setmStaple(int mStaple) {
		this.mStaple = mStaple;
	}
	public int getmMain() {
		return mMain;
	}
	public void setmMain(int mMain) {
		this.mMain = mMain;
	}
	public int getmSide() {
		return mSide;
	}
	public void setmSide(int mSide) {
		this.mSide = mSide;
	}
	public int getmOther() {
		return mOther;
	}
	public void setmOther(int mOther) {
		this.mOther = mOther;
	}
	public int getnStaple() {
		return nStaple;
	}
	public void setnStaple(int nStaple) {
		this.nStaple = nStaple;
	}
	public int getnMain() {
		return nMain;
	}
	public void setnMain(int nMain) {
		this.nMain = nMain;
	}
	public int getnSide() {
		return nSide;
	}
	public void setnSide(int nSide) {
		this.nSide = nSide;
	}
	public int getnOther() {
		return nOther;
	}
	public void setnOther(int nOther) {
		this.nOther = nOther;
	}
	public int geteStaple() {
		return eStaple;
	}
	public void seteStaple(int eStaple) {
		this.eStaple = eStaple;
	}
	public int geteMain() {
		return eMain;
	}
	public void seteMain(int eMain) {
		this.eMain = eMain;
	}
	public int geteSide() {
		return eSide;
	}
	public void seteSide(int eSide) {
		this.eSide = eSide;
	}
	public int geteOther() {
		return eOther;
	}
	public void seteOther(int eOther) {
		this.eOther = eOther;
	}
	public int getSnack() {
		return snack;
	}
	public void setSnack(int snack) {
		this.snack = snack;
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
	public DishInf(int id, int mStaple, int mMain, int mSide, int mOther, int nStaple, int nMain, int nSide, int nOther,
			int eStaple, int eMain, int eSide, int eOther, int snack, Date insertDate, String u_id) {
		super();
		this.id = id;
		this.mStaple = mStaple;
		this.mMain = mMain;
		this.mSide = mSide;
		this.mOther = mOther;
		this.nStaple = nStaple;
		this.nMain = nMain;
		this.nSide = nSide;
		this.nOther = nOther;
		this.eStaple = eStaple;
		this.eMain = eMain;
		this.eSide = eSide;
		this.eOther = eOther;
		this.snack = snack;
		this.insertDate = insertDate;
		this.u_id = u_id;
	}
	public DishInf() {
		this(0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,"");
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public DishInf(int i, int mStaple2, int mMain2, int mSide2, int mOther2, Object object, String string) {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	
}
