
<%@page import="DTO.loginDTO"%>
<%@page import="DAO.productDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBConnection.DBConnection"%>
<%@page import="DAO.cancle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  
 loginDTO auth = (loginDTO) request.getSession().getAttribute("auth");
 if(auth != null){
     request.setAttribute("auth" , auth);
 }%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@ include file="head.jsp" %>
    </head>
    <body>
        <%@ include file="main.jsp" %>

<%ArrayList<cancle> cart_list = (ArrayList<cancle>) session.getAttribute("cart-list");
if(cart_list != null){
   productDAO pd = new productDAO(DBConnection.getConn());
  request.setAttribute("cart_list" , cart_list);
}
    %>
  <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-centre">User login</div>
                <div class="card-body">
                    <form action="login" method="post">
                        <div class="form-group">
                            <label>Email Address</label>
                            <input type="email" class="form-control" name="login-email" placeholder="Enter your email" required>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="login-password" placeholder="********" required>
                        </div>
                        <div class="text-centre">
                            <input type = 'submit' />
                        </div>
                        
                    </form>
                    <br>
                    <a href="register.jsp">Register</a>
                </div>
            </div>
        </div>

         <%@ include file="footer.jsp" %>
    </body>
</html>
