
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>
    </head>
    <body>
        <span> We already send a verification code to mail</span>
        
        <form action ="VerifyCode" method="post">
        <input type="text" name="auth">
        <input type="submit" value="verify">
        </form>
    </body>
</html>
