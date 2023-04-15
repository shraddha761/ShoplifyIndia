<%@page import="DTO.loginDTO"%>
<%@page import="DAO.cancle"%>
<%@page import="DBConnection.DBConnection"%>
<%@page import="DTO.productDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.productDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

         <%   
             loginDTO auth=(loginDTO)request.getSession().getAttribute("auth");
                if(auth!=null){
                  request.setAttribute("auth",auth);
                 }
             
             productDAO pda = new productDAO(DBConnection.getConn());
          List<productDTO> products = pda.getAllProduct();
        %>
        
<%ArrayList<cancle> cart_list = (ArrayList<cancle>) session.getAttribute("cart-list");
if(cart_list != null){
   productDAO pd = new productDAO(DBConnection.getConn());
  request.setAttribute("cart_list" , cart_list);
}
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cosmetics</title>
        <%@ include file="head.jsp" %>
    </head>   
    <body>
        <%@include file = "main.jsp" %>
        <div class="container">
           <div class="card-header my-3">ALL Product
           <div class="row">
      <% 
          if(!products.isEmpty()){
          for(productDTO p : products){%>
              <div class="col-md-3 my-3">
               <div class="card w-100" style="width: 18rem;">
                  <img class="card-img-top" style="height:15rem; width: 16rem; object-fit: cover;" src="image/<%= p.getImage()%>" alt="Card image cap">
        <div class="card-body">
   <h5 class="card-title"><%= p.getName()%></h5>
   <h6 class="price">Price: <%= p.getPrice()%></h6>
   <h6 class="category">Category: <%= p.getCategory()%></h6>
   
         <a href="AddToCart?id=<%=p.getId()%>" class="btn btn-dark">Add to Cart</a>
         <a href="orderNow?quantity=1&id=<%=p.getId()%>" class="btn btn-primary">Buy Now</a>
         <% if(auth != null){
             int a=auth.getTyp();   
         if(a == 1){%>
         <a href="delete?id=<%=p.getId()%>" class="btn btn-sm btn-danger">Remove</a>
         <%}}%>
     
                  </div>
                </div>
              </div>
          <%}
      }
       %>
         <%@ include file="footer.jsp" %>
    </body>
</html>

