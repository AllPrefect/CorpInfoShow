package edu.abc.ruanjianbei.model.bean;

import java.util.ArrayList;
import java.util.HashMap;

public class TouziBean {
	
	private String name;
	private ArrayList<ChildrenBean> children;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<ChildrenBean> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<ChildrenBean> children) {
		this.children = children;
	}
	
	public TouziBean(String name, ArrayList<ChildrenBean> children) {
		super();
		this.name = name;
		this.children = children;
	}
	public TouziBean() {
		super();
	}
	
	@Override
	public String toString() {
		return "Touzi [name=" + name + ", children=" + children + "]";
	}
	
}
