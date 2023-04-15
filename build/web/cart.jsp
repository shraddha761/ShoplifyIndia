<%@page import="DTO.loginDTO"%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="DBConnection.DBConnection"%>
<%@page import="DAO.productDAO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.cancle"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     loginDTO auth=(loginDTO)request.getSession().getAttribute("auth");
                if(auth!=null){
                  request.setAttribute("auth",auth);
                 }
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
 %> 
<%
ArrayList<cancle> cart_list = (ArrayList<cancle>) session.getAttribute("cart-list");
List<cancle> cartProduct = null;
if(cart_list != null){
   productDAO pd = new productDAO(DBConnection.getConn());
  cartProduct = pd.getCartProduct(cart_list);
 double total =  pd.getTotalCartPrice(cart_list);
  request.setAttribute("cart_list" , cart_list);
  request.setAttribute("total", total);
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <%@ include file="head.jsp" %>
        <style type="text/css">
            .table tbody td{
                vertical-align: middle;
            }
            .btn-incre,.btn-decre{
                box-shadow: none;
                font-size: 25px;
            }
        </style>
    </head>
    <body>
        <%@ include file="main.jsp" %>
        
   <div class ="container">
      <div class="d-flex py-3"><h3>Total Price: ${ total>0?dcf.format(total) : 0 }</h3>
          <a class="mx-3 btn btn-primary" href="checkout">Check outs</a></div>
      <table class="table table-loght">
  <thead>
    <tr>
               <th scope="col">Name</th>
               <th scope="col">Category</th>
               <th scope="col">Price</th>
               <th scope="col">Buy Now</th>
               <th scope="col">Cancel</th>
           </tr>
       </thead>
     <tbody>
      <% 
         if(cart_list != null){
             for(cancle c : cartProduct){%>
                 <tr>
                       <td><%=c.getName()%></td>
                       <td><%=c.getCategory()%></td>
                       <td><%=c.getPrice()%></td>
                       <td>
                           <form action="orderNow" method="post" class="form-inline">
                               <input type="hidden" name="id" value="<%=c.getId()%>" class="form-input">
                               <div class="form-group d-flex justify-content-between w-50">
                                   <a class="btn btn-sm btn-decre" href="qtyIncDec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
                                   <input type="text" name="quantity" class="form-control w-50" value="<%=c.getQuantity()%>" readonly>
                                   <a class="btn btn-sm btn-incre" href="qtyIncDec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a>
                               </div>
                              
                               <a href="orderNow?quantity=1&id=<%=c.getId()%>" class="btn btn-primary">Buy Now</a>
                           </form>
                       </td>
                       <td><a class="btn btn-sm btn-danger" href="Remove?id=<%=c.getId()%>">Remove</a></td>
                   </tr>
             <%}
         }
      %>
     </td>
  </tbody>
</table>
        <%@ include file="footer.jsp" %>
    </body>
</html>
