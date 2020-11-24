package com.cg.dao;


import java.sql.SQLException;

import com.cg.model.User;


public interface IUserRoleDAO 
{
	public String verifyUser(User userRole) throws SQLException;
	public int addUser(User userRole) throws SQLException;
}
