


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <%@ include file="head.jsp" %>
    </head>
    <body>
        
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-centre">AddProduct</div>
                <div class="card-body">
                    <form action="AddPro" method="post" enctype ="multipart/form-data"
                        enctype="multipart/form-data">
                        <div class="form-group">
                            <label>Product name</label>
                            <input type="text" class="form-control" name="prnm" placeholder="Enter product name" required>
                        </div>
                        <div class="form-group">
                            <label>Category</label>
                            <input type="text" class="form-control" name="cat" placeholder="product category" required>
                        </div>
                        <div class="form-group">
                            <label>Price</label>
                            <input type="text" class="form-control" name="price" placeholder="Price" required>
                        </div>
                        
                        <div class="form-group">
                            <label>Image</label>
                            
                            <input type="file" class="form-control" name="image" required>
                         </div>
                        <div class="text-centre">
                            <button type="submit" class="btn btn-primary">Add Product</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file = "footer.jsp" %>
    </body>
</html>
