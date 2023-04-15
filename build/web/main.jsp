<%-- 
    Document   : main
    Created on : 18 Feb, 2023, 3:37:08 PM
    Author     : shrad
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
    <a class="navbar-brand" href="index.jsp">Cosmetics</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
        
    
      
        <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        <li class="nav-item">
          <a class="nav-link" href="cart.jsp">Cart<span class="badge badge-danger">${cart_list.size()}</span></a>
      </li>
      <%if(auth!=null){
          int a = auth.getTyp();
          if(a == 0){     
       %>
      <li class="nav-item">
               <a class="nav-link" href="order.jsp">Order</a>
      </li>
      
       <%}else if (a == 1) {%>
            <li class="nav-item">
        <a class="nav-link disabled" href="AddProduct.jsp"> AddProduct</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="Record.jsp">Record</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="AdminReg.jsp">Registration</a>
      </li>   
      <%}
}%>
                <li class="nav-item">
              <a class="nav-link" href="login.jsp">Login</a>
                </li>
                    
      </li> 
      
    
  </div>
</nav>