package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public interface CreateDataDao extends BaseDao{
	//插入数据库语句
	public Boolean insertData(String sql);
	
	//搜索数据库,随机查询公司信息
	public ArrayList<String> searchData();
	
	//分页搜索公司一个公司的信息
	public T_CORPBean searchOneCorp(String sql);
		
}
