package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.GuQuan;
import edu.abc.ruanjianbei.model.bean.Guquanxinxi;

public interface CompanyGuQuanDao extends BaseDao{
	
	//查找个人股东信息
	public GuQuan Selectguquan(String comname);
	//查找公司股东信息
	public ArrayList<Guquanxinxi> Selectcomguquan(String comname);
}
