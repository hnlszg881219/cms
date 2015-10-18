package com.tongyi.cms.account.dao;

import com.tongyi.cms.account.AccountInfo;

public interface AccountDao {
	
	/**
	 * ¥¥Ω®’À∫≈
	 * @param accountInfo
	 * @return
	 */
	int createAccount(AccountInfo accountInfo);
	
	int updateAccount(int id,String password);
	
	AccountInfo queryAccountInfoById(int id);
	
	
}
