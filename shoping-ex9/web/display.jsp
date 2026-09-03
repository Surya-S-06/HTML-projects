<%@page import="java.sql.*"%>
<html>
<head>
    <title>Order Details</title>
</head>
<body>
<center>
<h1>ORDER DETAILS</h1>
<%

String name = request.getParameter("name");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String product = request.getParameter("product");
String quantity = request.getParameter("quantity");
String address = request.getParameter("address");
String payment = request.getParameter("payment");

try
{

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/onlineshoping?useSSL=false&allowPublicKeyRetrieval=true",
        "root",
        "test@123"
    );

    String sql = "INSERT INTO orders(name,email,phone,product,quantity,address,payment) VALUES(?,?,?,?,?,?,?)";

    PreparedStatement ps = con.prepareStatement(sql);

    ps.setString(1, name);
    ps.setString(2, email);
    ps.setString(3, phone);
    ps.setString(4, product);
    ps.setInt(5, Integer.parseInt(quantity));
    ps.setString(6, address);
    ps.setString(7, payment);

    ps.executeUpdate();

    out.println("<h2>Order Saved Successfully!</h2>");

%>
<table border="1" cellpadding="10">
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Product</th>
    <th>Quantity</th>
    <th>Address</th>
    <th>Payment</th>
</tr>
<tr>
<td><%=name%></td>
<td><%=email%></td>
<td><%=phone%></td>
<td><%=product%></td>
<td><%=quantity%></td>
<td><%=address%></td>
<td><%=payment%></td>
</tr>
</table>
<%
    ps.close();
    con.close();
}
catch(Exception e)
{
    out.println("<h3>Error: " + e + "</h3>");
}
%>
<br><br>
<a href="index.html">
    <button>Back to Shopping</button>
</a>
</center>
</body>
</html>
