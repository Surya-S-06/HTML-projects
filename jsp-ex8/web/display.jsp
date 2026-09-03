<%-- 
    Document   : newjsp
    Created on : 3 Sep, 2026, 2:11:30 PM
    Author     : 24uad106
--%>

<!DOCTYPE html>
<html>
<center>
<h2>Submitted Registration Details</h2>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String card = request.getParameter("card");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
%>

Username: <%= username %>
<br><br>
Password: <%= password %>
<br><br>
Name: <%= name %>
<br><br>
Credit Card Number: <%= card %>
<br><br>
Email: <%= email %>
<br><br>
Phone Number: <%= phone %>
<br><br>
</body></center></html>
