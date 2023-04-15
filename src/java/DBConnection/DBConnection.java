/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author shrad
 */ 

public class DBConnection {
    static Connection con;
    public static Connection getConn(){
        try{
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","");
 }
   catch(Exception tt)
 {
  System.out.print(tt);
 }
          return con;
     }
 }

