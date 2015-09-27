package com.tongyi.cms.account.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tongyi.cms.account.AccountInfo;
import com.tongyi.cms.account.dao.AccountDao;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int createAccount(AccountInfo accountInfo) {
		return 0;
	}

	public int updateAccount(int id, String password) {
		return 0;
	}

	public AccountInfo queryAccountInfoById(int id) {
		return null;
	}

}
