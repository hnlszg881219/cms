package com.tongyi.cms.account.item;

/**
 *  �˻�״̬
 * @author Administrator
 * create time 2015-09-26 21:15:00
 */
public enum AccountStatus {
	//δ����
    UNACIVE(-2), 
    //���� 
    LOCK(-1),
    //����
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
