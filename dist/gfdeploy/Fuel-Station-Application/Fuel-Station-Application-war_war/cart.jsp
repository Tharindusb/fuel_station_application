<%-- 
    Document   : cart
    Created on : Oct 3, 2022, 7:13:23 PM
    Author     : tharindu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cart!</h1>
        <form>
            <table>
                <tr>
                    <td>Vehicle No: </td>
                    <td><label type="text" name="vehicleNo" /><%= request.getAttribute("vehicleNo") %></td>
                </tr>
                <tr>
                    <td>Vehicle Type: </td>
                    <td><label type="text" name="vehicleType" /><%= request.getAttribute("vehicleType") %></td>
                </tr>
                <tr>
                    <td>Fuel Amount</td>
                    <td><input type="text" name="fuelAmount" /></td>
                    <td> <input type="submit" value="Submit" /></td>
                </tr>
                
            </table>
        </form>
    </body>
</html>
