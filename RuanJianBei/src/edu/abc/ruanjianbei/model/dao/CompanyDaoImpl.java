package edu.abc.ruanjianbei.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {

	@Override
	public Boolean add(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<T_CORPBean> selectByCompanyName(String name) {
		ArrayList<T_CORPBean > companys=new ArrayList<>();
		StringBuffer sql=new StringBuffer();
		PreparedStatement pst=null;
		ResultSet rs=null;
		sql.append(" select CORP_NAME from T_CORP ");
		sql.append(" where CORP_NAME like ?");
		Connection conn=BaseDaoImpl.getConnection();
		try {
			pst=conn.prepareStatement(sql.toString());
			pst.setString(1, "%"+name+"%");
			rs=pst.executeQuery();
			while(rs.next()) {
				String companyname=rs.getString("CORP_NAME");
				T_CORPBean company=new T_CORPBean();
				company.setCORP_NAME(companyname);
				companys.add(company);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			BaseDaoImpl.close(conn, pst, rs);
		}
		return companys;
	}

	@Override
	public T_CORPBean searchOneCompany(String name) {
		T_CORPBean company = null;
		StringBuffer sql=new StringBuffer();
		PreparedStatement pst=null;
		ResultSet rs=null;
		sql.append(" select * from T_CORP ");
		sql.append(" where CORP_NAME=?");
		Connection conn=BaseDaoImpl.getConnection();
		try {
			pst=conn.prepareStatement(sql.toString());
			pst.setString(1, name);
			rs=pst.executeQuery();
			while(rs.next()) {
				String CORP_NAME=rs.getString("CORP_NAME");
				String REG_NO=rs.getString("REG_NO");
				String ADDR=rs.getString("ADDR");
				company=new T_CORPBean();
				company.setADDR(ADDR);
				company.setCORP_NAME(CORP_NAME);
				company.setREG_NO(REG_NO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			BaseDaoImpl.close(conn, pst, rs);
		}
		return company;
	}
	
	
}
