<%-- 
    Document   : home
    Created on : Sep 25, 2022, 9:34:02 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body
    class="w-full bg-blue-100 flex justify-center flex-col items-center md:grid md:grid-cols-2 lg:grid-cols-3 p-10"
  >
    <div
      class="w-2/3 my-5 shadow-md p-5 hover:shadow-xl transition-all duration-200 cursor-pointer bg-white rounded-md flex justify-center flex-col items-center min-w-[40]"
    >
      <h1 class="font-semibold text-center">Type of fuel</h1>
      <div class="flex w-full items-center justify-between mt-5">
        <p class="">Availability</p>
        <p class="font-semibold text-green-600">Amount L</p>
      </div>
      <div class="flex items-center justify-between w-full mt-4">
        <p>Price</p>
        <p class="font-semibold text-blue-600"><span>Price</span> /L</p>
      </div>
      <button
        class="w-1/2 bg-green-600 px-3 py-1 font-semibold text-white rounded-sm mt-5 hover:bg-green-400 duration-200"
      >
        Order
      </button>
    </div>
    
    
  </body>
</html>
