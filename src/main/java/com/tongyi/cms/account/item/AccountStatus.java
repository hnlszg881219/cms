package com.tongyi.cms.account.item;

/**
 *  ÕË»§×´Ì¬
 * @author Administrator
 * create time 2015-09-26 21:15:00
 */
public enum AccountStatus {
	//Î´¼¤»î
    UNACIVE(-2), 
    //Ëø¶¨ 
    LOCK(-1),
    //¼¤»î
	ACTIVE(0);
	
	private AccountStatus(int value) {
		this.value = value;
	}
    
	private int value;

	public int getValue() {
		return value;
	}
	
	public Long getLongValue() {
		return (long) value;
	}
	
}
