package edu.abc.ruanjianbei.model.bean;

import java.util.ArrayList;

public class OneGuongSiMoneyBean {

	private int ORG;
	private ArrayList<Integer> ID;
	private int SEQ_ID;
	private int guDongcount;
	private float allMoney;
	private String chenglishijian;
	
	
	public String getChenglishijian() {
		return chenglishijian;
	}

	public void setChenglishijian(String chenglishijian) {
		this.chenglishijian = chenglishijian;
	}

	public int getGuDongcount() {
		return guDongcount;
	}

	public void setGuDongcount(int guDongcount) {
		this.guDongcount = guDongcount;
	}

	public OneGuongSiMoneyBean() {
		super();
	}

	public OneGuongSiMoneyBean(int oRG, int sEQ_ID, float allMoney) {
		super();
		ORG = oRG;
		SEQ_ID = sEQ_ID;
		this.allMoney = allMoney;
	}

	public int getORG() {
		return ORG;
	}

	public void setORG(int oRG) {
		ORG = oRG;
	}
	
	public ArrayList<Integer> getID() {
		return ID;
	}

	public void setID(ArrayList<Integer> iD) {
		ID = iD;
	}

	public int getSEQ_ID() {
		return SEQ_ID;
	}

	public void setSEQ_ID(int sEQ_ID) {
		SEQ_ID = sEQ_ID;
	}

	public float getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(float allMoney) {
		this.allMoney = allMoney;
	}

	@Override
	public String toString() {
		return "OneGuongSiMoneyBean [ORG=" + ORG + ", SEQ_ID=" + SEQ_ID + ", guDongcount=" + guDongcount + ", allMoney="
				+ allMoney + ", chenglishijian=" + chenglishijian + "]";
	}
	
}
