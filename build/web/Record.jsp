<%-- 
    Document   : Record
    Created on : 25 Feb, 2023, 6:15:56 PM
    Author     : shrad
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="DTO.loginDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%   
             loginDTO auth=(loginDTO)request.getSession().getAttribute("auth");
                if(auth!=null){
                  request.setAttribute("auth",auth);
                 }%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Record</title>
        <%@include file = "head.jsp" %>
    </head>
    <body>
        <%@include file = "main.jsp" %>
         <div class="container">
           <div class="card-header my-3">ALL Order
               <div class="row"></div>
           </div>
         <table class="table table-loght">
  <thead>
          <tr>
               <th scope="col">Id</th>
               <th scope="col">Date</th>
               <th scope="col">Product</th>
               <th scope="col">Category</th>
               <th scope="col">Price</th>
               <th scope="col">Email</th>
           </tr>
           </thead>
           
               <%
                 try{
                     String query = "select o_id,odate,name,cat,price,email from `order` inner join product on product.Sno = `order`.p_id inner join register on register.Sn = `order`.u_id";
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","");
                     Statement stm = con.createStatement();
                     ResultSet rs = stm.executeQuery(query);
                     while(rs.next()){%>
                       <tbody>
                        <td><%=rs.getInt("o_id")%></td>
                         <td><%=rs.getString("odate") %></td>
                         <td><%=rs.getString("name") %></td>
                         <td><%=rs.getString("cat") %></td>
                         <td><%=rs.getDouble("price") %></td>
                          <td><%=rs.getString("email") %></td>
    </tr>
    
  </tbody>
                     <%}
                 }catch(Exception e)
                 {
                    System.out.print(e);
                  }
               
               %>
           </tbody>  
           <%@include file = "footer.jsp" %>
    </body>
</html>
