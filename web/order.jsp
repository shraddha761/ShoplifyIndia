
<%@page import="java.util.List"%>
<%@page import="DTO.OrderModel"%>
<%@page import="DAO.orderDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="DTO.loginDTO"%>
<%@page import="DAO.productDAO"%>
<%@page import="DBConnection.DBConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.cancle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  List<OrderModel> od =  null;
    loginDTO auth=(loginDTO)request.getSession().getAttribute("auth");
                if(auth!=null){
                  request.setAttribute("auth",auth);
                
                 }else{
                    //response.sendRedirect("login.jsp");
                }
   DecimalFormat dcf = new DecimalFormat("#.##");
   request.setAttribute("dcf", dcf);
     ArrayList<cancle> cart_list = (ArrayList<cancle>) session.getAttribute("cart-list");
if(cart_list != null){
   productDAO pd = new productDAO(DBConnection.getConn());
  request.setAttribute("cart_list" , cart_list);
  od =new orderDAO(DBConnection.getConn()).userOrder(auth.getId());
}
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@ include file="head.jsp" %>
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
               <th scope="col">Date</th>
               <th scope="col">Name</th>
               <th scope="col">Category</th>
               <th scope="col">Price</th>
               <th scope="col">Quantity</th>
               <th scope="col">Cancel</th>
           </tr>
           </thead>
           <tbody>
           <% 
               if(od != null)
               {
                    for(OrderModel o : od){%>
                    <tr>
                               <td><%=o.getDate()%></td>
                               <td> <%=o.getName()%></td>
                               <td> <%=o.getCategory()%></td>
                               <td> <%=dcf.format(o.getPrice())%></td>
                               <td> <%=o.getQty()%></td>
                               <td> <a class="btn btn-sm btn-danger" href="cancleorder?id=<%=o.getOrderid()%>">Cancel</a></td>
                     </tr>
                   <%}
               }
               %>
           </tbody>
           </table>
         <%@ include file="footer.jsp" %>
    </body>
</html>
