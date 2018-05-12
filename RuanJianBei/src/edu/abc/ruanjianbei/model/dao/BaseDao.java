package edu.abc.ruanjianbei.model.dao;

public interface BaseDao {
	String driverClassName="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String username="bankadmin";
	String password="bankadmin";
	
	public Boolean add(Object o);
	public Boolean delete(Object o);
	public Boolean update(Object o);
	public Object list();
}
