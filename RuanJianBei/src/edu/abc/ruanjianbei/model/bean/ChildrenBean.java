package edu.abc.ruanjianbei.model.bean;

public class ChildrenBean {
	
	private String name;
	private String value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public ChildrenBean(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public ChildrenBean() {
		super();
	}
	
	@Override
	public String toString() {
		return "Children [name=" + name + ", value=" + value + "]";
	}
	
}
