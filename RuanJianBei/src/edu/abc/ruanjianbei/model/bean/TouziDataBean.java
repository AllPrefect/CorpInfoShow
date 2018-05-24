package edu.abc.ruanjianbei.model.bean;

import java.util.ArrayList;

public class TouziDataBean {
	
	private String name;
	private ArrayList<TouziBean> children;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<TouziBean> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<TouziBean> children) {
		this.children = children;
	}
	
	public TouziDataBean(String name, ArrayList<TouziBean> children) {
		super();
		this.name = name;
		this.children = children;
	}
	public TouziDataBean() {
		super();
	}
	
	@Override
	public String toString() {
		return "Alldata [name=" + name + ", children=" + children + "]";
	}
	
}
