package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.Links;

public interface CompanyGuanXiDao extends BaseDao{
//	查询该主体的股东在外投资情况
	public ArrayList<Links> selectTouZiOutside(String corpName);
	public ArrayList<Links> selectRenZhiOutside(String corpName,String sql);
//	查询该主体股东在外任职情况
	public ArrayList<Links> selectGuDongRenZhiOutside(String corpName);
//	查询该主体高管在外任职情况
	public ArrayList<Links> selectGaoGuanRenZhiOutside(String corpName);
}
