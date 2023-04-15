/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.productDAO.con;
import DBConnection.DBConnection;
import DTO.productDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author shrad
 */
public class cancle extends productDTO{
    private int quantity;
    PreparedStatement ps;
    
    
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
     
    
    
    
    public boolean deleteUser(String id){
        boolean b = false;
        try {
            con=DBConnection.getConn();
            ps = con.prepareStatement("delete from product where Sno=?");
            ps.setString(1,id);
            int i = ps.executeUpdate();
            if(i > 0){
               b = true;
            }
            
        } catch (SQLException ex) {
            
        }
        return b;
    }
  
}
