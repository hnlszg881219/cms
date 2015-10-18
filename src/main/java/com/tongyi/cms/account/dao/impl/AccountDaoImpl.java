package com.tongyi.cms.account.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tongyi.cms.account.AccountInfo;
import com.tongyi.cms.account.dao.AccountDao;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
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
