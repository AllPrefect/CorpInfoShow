package edu.abc.ruanjianbei.model.dao;

import edu.abc.ruanjianbei.model.bean.UserBean;

public interface UserDao extends BaseDao {
	
	//处理登录事件
	public UserBean login(String account, String password);
	//验证用户是否已经存在
	public boolean checkUserExist(String account);

}
