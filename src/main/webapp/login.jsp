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
                width: 75%;
                flex-direction: column;
                display: flex;
                justify-content: center;
                align-items: center;
                text-align: center;
                min-height: 100vh;
            }
            #login {
                border: 3px solid;
                padding: 5%;
                border-radius: 5px;
                background-color: #dfdfdf;
            }
        </style>
        <%@include file="include.jsp" %>
    </head>
    <body>
        <div id="centre-body">
            <div id="login">
                <h2>Login page</h2>
                <form>
                    <table>
                        <tr>
                            <td><label for="username">Username:</label></td>
                            <td colspan="2"><input type="text" class="form-control" id="username"/></td>
                        </tr>
                        <tr>
                            <td><label for="pw">Password:</label></td>
                            <td colspan="2"><input type="password" class="form-control" id="pw" /></td>
                        </tr>
                        <tr>
                            <td colspan="1">    
                                <div class="form-check mt-2 mb-2">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="checkbox" name="remember"> Remember me
                                    </label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td><button class="btn btn-danger">Forget password</button></td>
                            <td><button  class="btn btn-secondary">Register Member</button></td>
                            <td><input  class="btn btn-primary" type="submit" value="login" /></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
