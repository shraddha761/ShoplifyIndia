/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBConnection.DBConnection;
import DTO.loginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertDB {
    PreparedStatement ps;
    ResultSet rs;
    static Connection con1;
     boolean b = false;
     boolean a = false;
    public boolean insert(String name, String email,String pass) throws SQLException{
        try{
        con1 = DBConnection.getConn();
      
         ps = con1.prepareStatement("insert into register(firstnm,email,pass) values(?,?,?)");
              ps.setString(1,name);
              ps.setString(2,email);
              ps.setString(3,pass);
             
              ps.executeUpdate();
              b = true;
            }
    catch(Exception e)
    { 
        System.out.print(e);
    }
        return b;
    }
    public boolean Ainsert(loginDTO u){
        try{
            boolean a = false;
            con1 = DBConnection.getConn();
      
          ps = con1.prepareStatement("insert into register(firstnm,email,pass,status) values(?,?,?,?)");  
              ps.setString(1, u.getName());
              ps.setString(2,u.getEmail());
              ps.setString(3,u.getPassword());
              ps.setInt(4,u.getTyp());
              ps.executeUpdate();
              a = true;
            
        }catch(Exception e)
        {
        System.out.print(e);
        }
        return a;
    }
    
   
     public loginDTO userlogin(String email,String pass)
    {
        loginDTO user=null;
        try{
            con1=DBConnection.getConn();
            
            ps=con1.prepareStatement("select * from register where email=? and pass=?");
            ps.setString(1,email);
            ps.setString(2,pass);
            rs=ps.executeQuery();
            if(rs.next())
            {
                user=new loginDTO();
                user.setId(rs.getInt("Sn"));
                user.setName("firstnm");
                user.setEmail("email"); 
                user.setTyp(rs.getInt("status"));
            }
        }catch(Exception tt)
        {
            System.out.println(tt);
        }
        return user;
    }
    }

