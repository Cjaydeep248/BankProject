package com.cjc.bms.service;

import java.sql.SQLException;

public interface Rbi {
	public void createAccount() throws Exception;
	public void displayAllDetails() throws Exception;
	public void depositeMoney() throws Exception;
	public void withDrawal() throws Exception;
	public void balanceCheck() throws Exception;
}
