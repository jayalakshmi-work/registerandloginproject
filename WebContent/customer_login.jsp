<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer login page...</title>
</head>
<body>
<h1> login here</h1>
<form action ="logcustomer" method ="post">
<label for ="tbemail">Email :</label> 
<input type ="email" name ="tbemaillog" id ="tbemail" value ="<%=request.getParameter("tbemail") %>"/><br>     <!-- here for value just paste name from myservet where  u have reading the data i.e.tbemail-- -->

<label for ="tbpass">Password :</label> 
<input type ="password" name ="tbpwdpass" id ="tbpass" value ="<%=request.getParameter("tbpwd")%>"/><br>

<button>login</button>
</form>
</body>
</html>