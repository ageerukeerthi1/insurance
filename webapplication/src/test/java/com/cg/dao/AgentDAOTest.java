package com.cg.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.exceptions.LoginAndCommonException;

public class AgentDAOTest {

	    @Test
	    public void testUserExist() throws LoginAndCommonException {
	        AgentDAO obj=new AgentDAO();
	        boolean saved=obj.isUserExists("Anuja12");
	        assertEquals(true,saved);    
	    }
	    @Test
	    public void testAccountValidation()throws LoginAndCommonException
	    {
	        AgentDAO obj=new AgentDAO();
	        boolean saved=obj.accountValidation("Anuja12");
	        assertEquals(true,saved);
	    }
	    @Test
	    public void testAccountExist()throws LoginAndCommonException
	    {
	        AgentDAO obj=new AgentDAO();
	        boolean saved=obj.isAccountExists(690985);
	        assertEquals(true,saved);
	    }
	}