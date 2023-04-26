<%-- 
    Document   : member_login
    Created on : 2023年4月24日, 下午1:46:25
    Author     : kelvinleung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff login</title>
    </head>
    <body>
        <h1>Staff login</h1>
        <form method="post" action="staff">
            <input type="hidden" name="action" value="login" />
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="button" onclick="history.back();" value="Back"/></td>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
