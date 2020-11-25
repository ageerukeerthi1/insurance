package com.cg.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.exceptions.LoginAndCommonException;

public class InsuredDAOTest {


    @Test
    public void testUserExist() throws LoginAndCommonException {
        InsuredDAO obj=new InsuredDAO();
        boolean saved=obj.isUserExists("KEERTHI");
        assertEquals(true,saved);
       
       
    }
    @Test
    public void testAccountValidation()throws LoginAndCommonException
    {
        InsuredDAO obj=new InsuredDAO();
        boolean saved=obj.accountValidation("sreeNIDHI12");
        assertEquals(true,saved);
    }
    
    @Test
    public void testGetAccountNumber()throws LoginAndCommonException
    {
        InsuredDAO obj=new InsuredDAO();
        int saved=obj.getAccountNumber("sreeNIDHI12");
        assertEquals(619036,saved);
    }
}