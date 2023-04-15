
package DAO;

import DBConnection.DBConnection;
import DTO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class orderDAO {
    private Connection con;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs; 
    
    public orderDAO(Connection con)
    {
        this.con = con;
    }
    public boolean insertOrder(OrderModel model){
        boolean a = false;
        System.out.println(model.getId());
        System.out.println(model.getQty());
        try{
            con = DBConnection.getConn();
            ps = con.prepareStatement("insert into `order`(p_id,u_id,o_qty,odate) values(?,?,?,?)");
            ps.setInt(1,model.getId());
            ps.setInt(2,model.getUid());
            ps.setInt(3,model.getQty());
            ps.setString(4, model.getDate());
            ps.executeUpdate();
            a = true;
        }catch(Exception e)
        {
          System.out.print(e);
        }
        System.out.print(a);
        return a;
    }
    
    public List<OrderModel> userOrder(int id){
        List<OrderModel> list = new ArrayList<>();
        try{
            query = "select * from `order` where u_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                OrderModel order = new OrderModel();
                productDAO prdao = new productDAO(this.con);
                int pid = rs.getInt("p_id");
                 productDTO pr = prdao.getSingleProduct(pid);
                 
                 order.setOrderid(rs.getInt("o_id"));
                 order.setId(pid);
                 order.setName(pr.getName());
                 order.setCategory(pr.getCategory());
                 order.setPrice(pr.getPrice() * rs.getInt("o_qty"));
                 order.setQty(rs.getInt("o_qty"));
                 list.add(order);
                 
            }
        }catch(Exception e)
        {
         System.out.print(e);
        }
        
        return list;
    }
    
    public void cancleOrder(int id){
        try{
        query = "delete from `order` where o_id=?";
        ps = this.con.prepareStatement(query);
        ps.setInt(1,id);
        ps.execute();
    }catch(Exception e)
            {}
    }
}
