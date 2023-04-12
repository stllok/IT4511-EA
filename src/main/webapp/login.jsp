<%-- 
    Document   : login
    Created on : 2023年4月12日, 下午6:29:52
    Author     : kelvinleung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            body {
                overflow: hidden;
            }
            #centre-body {
                margin: auto;
                width: 20%;
                flex-direction: column;
                display: flex;
                justify-content: center;
                align-items: center;
                text-align: center;
                min-height: 100vh;
            }
            #login {
                border: solid;
                padding: 5%;
            }
            #login h1 {
                align-self: center;
                display: flex;
                justify-content: space-around;
            }
            #login form {
                display: flex;
                justify-content: space-around;
            }
            .form-button {
                
            }
        </style>
    </head>
    <body>
        <div id="centre-body">
            <div id="login">
                <h1>Login page</h1>
                <form>
                    <table>
                        <tr>
                            <td>Username:</td>
                            <td colspan="2"><input type="text" /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td colspan="2"><input type="password" /></td>
                        </tr>
                        <tr>
                            <td><button class="form-button">Forget password</button></td>
                            <td><button  class="form-button">Register Member</button></td>
                            <td><input  class="form-button" type="submit" value="login" /></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
