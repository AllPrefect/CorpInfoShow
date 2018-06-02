package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.ChildrenBean;
import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public interface CompanyDao extends BaseDao{
	
	/*
	 * 通过输入的值返回匹配的公司名
	 */
	public ArrayList<T_CORPBean> selectByCompanyName(String name);
	/*
	 * 通过公司名查询公司表的信息
	 */
	public T_CORPBean searchOneCompany(String name);
	/*
	 * 通过公司名，查找向该公司投资的股东
	 */
	public ArrayList<ChildrenBean> selectGuDongByCompanyName(String name,String type,String sql);
	/*
	 * 通过公司名，查找向该公司投资的股东
	 */
	public ArrayList<ChildrenBean> selectGuDongRenByCompanyName(String name,String type);
	/*
	 * 通过公司名，查找向该公司投资的公司
	 */
	public ArrayList<ChildrenBean> selectGuDongComByCompanyName(String name,String type);
	/*
	 * 查找公司股东的投资层级信息
	 */
	public ArrayList<ChildrenBean> selectGuDongByname(String companyname,String gudongname,String type);
	
	public ArrayList<ChildrenBean> selectGuDongRenByCompany(String type,String name,int org,int seq_id);
	public ArrayList<ChildrenBean> selectGuDongComByCompany(String type,String name,int org,int seq_id);
}
