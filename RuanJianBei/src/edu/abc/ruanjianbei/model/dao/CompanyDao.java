package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public interface CompanyDao extends BaseDao{
	ArrayList<T_CORPBean> selectByCompanyName(String name);
	T_CORPBean searchOneCompany(String name);
}
