package com.cg.dao;

import static org.junit.Assert.*;

import com.cg.exceptions.LoginAndCommonException;

import org.junit.Test;
public class AdminDAOTest {

 

    @Test
    public void testUserExists() throws LoginAndCommonException{
        AdminDAO obj=new AdminDAO();
        boolean saved=obj.isUserExists("SUMITHRA");
        assertTrue(saved);
        
        
        
    }
    @Test
    public void testLogin()throws LoginAndCommonException
    {
        AdminDAO obj =new AdminDAO();
        boolean saved=obj.loginValidation("SUMITHRA", "Sai@123");
        assertTrue(saved);
       
    }
   @Test
   public void testGetRoleCode() throws LoginAndCommonException
   {
       AdminDAO obj=new AdminDAO();
       String saved=obj.getRoleCode("SUMITHRA", "Sai@123");
       assertEquals("UW",saved);
      
   }
   

 

}