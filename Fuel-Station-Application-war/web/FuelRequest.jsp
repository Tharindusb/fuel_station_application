<%-- 
    Document   : FuelRequest
    Created on : Sep 17, 2022, 3:49:21 PM
    Author     : Dushyantha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fuel Request Page</title>
    </head>
    <body>
        <div align="center">
            <h1>Customer Registration Form</h1>
            <form action="FuelRequestServlet" method="POST">
                <table style="with: 80%">
                    <tr>
                        <td>Vehicle No</td>
                        <td><input type="text" name="vehicleNo" /></td>
                    </tr>
                    <tr>
                        <td>Vehicle Type</td>
                        <td><input type="text" name="vehicleType" /></td>
                    </tr>
                    <tr>
                        <td>Mobile</td>
                        <td><input type="text" name="mobile" /></td>
                    </tr>
                </table>
                <input type="submit" value="Submit" />
            </form>
            
        </div>
    </body>
</html>
