/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.insertDB.con1;
import DBConnection.DBConnection;
import DTO.productDTO;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shrad
 */
public class productDAO {
    static Connection con;
    ResultSet rs;
    PreparedStatement pst;
    public productDAO(Connection con)
    {
        this.con=con;
    }
   
    public boolean insertpro(productDTO pd){
        boolean b = false;
        try{
            con = DBConnection.getConn();
            PreparedStatement ps = con.prepareStatement("insert into product(name,cat,price,image) values(?,?,?,?)");
            ps.setString(1,pd.getName());
            ps.setString(2,pd.getCategory());
            ps.setDouble(3,pd.getPrice());
            ps.setString(4,pd.getImage());
            ps.executeUpdate();
            b = true;
        }catch(Exception ex)
        {
          System.out.print(ex);
        }
        return b;
    }
    
    public List<productDTO> getAllProduct(){
        List<productDTO> products = new ArrayList<>();
        
        try {
            con = DBConnection.getConn();
            Statement stm = con.createStatement();
            rs = stm.executeQuery("select * from product");
            while(rs.next()){
            productDTO row = new productDTO();
            row.setId(rs.getInt("Sno"));
            row.setName(rs.getString("name"));
            row.setCategory(rs.getString("cat"));
            row.setPrice(rs.getDouble("price"));
            row.setImage(rs.getString("image"));
            products.add(row);
          }
           
        } catch (SQLException ex) {
            Logger.getLogger(productDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return products;
    }
    
    public List<cancle> getCartProduct(ArrayList<cancle> cartList){
        List<cancle> products = new ArrayList<>();
        
        try{
            if(cartList.size() > 0){
                for(cancle item : cartList){
                    pst = con.prepareStatement("select * from product where Sno = ?");
                    pst.setInt(1,item.getId());
                    rs = pst.executeQuery();
                    while(rs.next()){
                        cancle row = new cancle();
                        row.setId(rs.getInt("Sno"));
                        row.setName(rs.getString("name"));
                        row.setCategory(rs.getString("cat"));
                        row.setPrice(rs.getDouble("price")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                    }
                }
            }
            
        }catch(Exception e){
            System.out.print(e);
        }
        
        return products;
    }
    public double getTotalCartPrice(ArrayList<cancle> cartList){
        double sum = 0;
        try{
            if(cartList.size() > 0){
            for(cancle item : cartList){
                pst = con.prepareStatement("select price from product where Sno = ?");
                pst.setInt(1, item.getId());
                rs = pst.executeQuery();
                
                while(rs.next()){
                    sum += rs.getDouble("price") * item.getQuantity();
                }
            }
          }
        }catch(Exception e){
            System.out.print(e);
        }
        return sum;
    }
    public productDTO getSingleProduct(int id){
        productDTO row = null;
        try{ 
            
            pst = this.con.prepareStatement("select * from product where Sno = ?");
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            while(rs.next()){
                row = new productDTO();
                row.setId(rs.getInt("Sno"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("cat"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));
            }
        }catch(Exception e){}
        return row;
    }
}
