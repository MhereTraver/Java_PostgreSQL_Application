<%-- 
    Document   : register
    Created on : 19 Sept 2024, 07:58:35
    Author     : mhere
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"> 
        <link  href="css/register.css" rel="stylesheet" type="text/css"/>
        <title>Register Page</title>
    </head>
    <body>    
            <div class="wrapper">
                <div class="form-wrapper sign-in">
                    <form name="register "action="RegisterServlet" method="POST">
                        <h2>Sign up</h2>
                        <div class="input-group">
                            <input type="text" name="txtUsername">
                            <label for="">Username:</label>
                        </div>
                         <div class="input-group">
                            <input type="text" name="txtName">
                            <label for="">Name:</label>
                        </div>
                        <div class="input-group">
                            <input type="text" name="txtSurname">
                            <label for="">Surname:</label>
                        </div>
                         <div class="input-group">
                            <input type="text" name="txtEmail">
                            <label for="">Email:</label>
                        </div>
                         <div class="input-group">
                            <input type="text" name="txtPhone">
                            <label for="">Phone:</label>
                        </div>
                        <div class="input-group">
                            <input type="password" name="txtPassword">
                            <label for="">Password:</label>
                        </div>    
                        <button type="submit">Sign up</button>
                        <br><br>
                        <button type="reset">Clear</button>  
                        <div class="signup-link">
                            <a href="login.jsp">Login</a>       
                        </div> 
                    </form>
                </div>          
            </div>
    </body>
</html>
