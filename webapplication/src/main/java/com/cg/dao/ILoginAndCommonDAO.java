package com.cg.dao;

import java.sql.SQLException;

import com.cg.model.Insured;

public interface ILoginAndCommonDAO 
{
	public String accountDetails(Insured insured) throws SQLException;
	public String accountExists(String userName) throws SQLException ;
	public String findAccountNumber(String userName) throws SQLException;
}
