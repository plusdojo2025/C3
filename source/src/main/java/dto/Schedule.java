package dto;

import java.io.Serializable;
import java.util.Date;

public class Schedule extends CustomTemplateDto implements Serializable{
	private int id;
	private int sunWork;//分
	private int sunMotion;//分
	private int monWork;
	private int monMotion;
	private int tueWork;
	private int tueMotion;
	private int wedWork;
	private int wedMotion;
	private int thuWork;
	private int thuMotion;
	private int friWork;
	private int friMotion;
	private int satWork;
	private int satMotion;
	private int cCalorie;//運動で消費したカロリー
	private Date latestDate;//日付 yyyy-mm-dd
	private String u_id;
	private int dayOfWeek;
	
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSunWork() {
		return sunWork;
	}
	public void setSunWork(int sunWork) {
		this.sunWork = sunWork;
	}
	public int getSunMotion() {
		return sunMotion;
	}
	public void setSunMotion(int sunMotion) {
		this.sunMotion = sunMotion;
	}
	public int getMonWork() {
		return monWork;
	}
	public void setMonWork(int monWork) {
		this.monWork = monWork;
	}
	public int getMonMotion() {
		return monMotion;
	}
	public void setMonMotion(int monMotion) {
		this.monMotion = monMotion;
	}
	public int getTueWork() {
		return tueWork;
	}
	public void setTueWork(int tueWork) {
		this.tueWork = tueWork;
	}
	public int getTueMotion() {
		return tueMotion;
	}
	public void setTueMotion(int tueMotion) {
		this.tueMotion = tueMotion;
	}
	public int getWedWork() {
		return wedWork;
	}
	public void setWedWork(int wedWork) {
		this.wedWork = wedWork;
	}
	public int getWedMotion() {
		return wedMotion;
	}
	public void setWedMotion(int wedMotion) {
		this.wedMotion = wedMotion;
	}
	public int getThuWork() {
		return thuWork;
	}
	public void setThuWork(int thuWork) {
		this.thuWork = thuWork;
	}
	public int getThuMotion() {
		return thuMotion;
	}
	public void setThuMotion(int thuMotion) {
		this.thuMotion = thuMotion;
	}
	public int getFriWork() {
		return friWork;
	}
	public void setFriWork(int friWork) {
		this.friWork = friWork;
	}
	public int getFriMotion() {
		return friMotion;
	}
	public void setFriMotion(int friMotion) {
		this.friMotion = friMotion;
	}
	public int getSatWork() {
		return satWork;
	}
	public void setSatWork(int satWork) {
		this.satWork = satWork;
	}
	public int getSatMotion() {
		return satMotion;
	}
	public void setSatMotion(int satMotion) {
		this.satMotion = satMotion;
	}
	public int getcCalorie() {
		return cCalorie;
	}
	public void setcCalorie(int cCalorie) {
		this.cCalorie = cCalorie;
	}
	public Date getLatestDate() {
		return latestDate;
	}
	public void setLatestDate(Date latestDate) {
		this.latestDate = latestDate;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public Schedule(int id, int sunWork, int sunMotion, int monWork, int monMotion, int tueWork, int tueMotion,
			int wedWork, int wedMotion, int thuWork, int thuMotion, int friWork, int friMotion, int satWork,
			int satMotion, int cCalorie, Date latestDate, String u_id) {
		super();
		this.id = id;
		this.sunWork = sunWork;
		this.sunMotion = sunMotion;
		this.monWork = monWork;
		this.monMotion = monMotion;
		this.tueWork = tueWork;
		this.tueMotion = tueMotion;
		this.wedWork = wedWork;
		this.wedMotion = wedMotion;
		this.thuWork = thuWork;
		this.thuMotion = thuMotion;
		this.friWork = friWork;
		this.friMotion = friMotion;
		this.satWork = satWork;
		this.satMotion = satMotion;
		this.cCalorie = cCalorie;
		this.latestDate = latestDate;
		this.u_id = u_id;
	}
	public Schedule() {
		this(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,"");
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	
}
