<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer registraion file....</title>
</head>
<body>
<h1> customer registration page </h1>
<form action ="regCustomer" method ="post">
 name : <input type ="text" name ="tbname" id="tbname"/><br>
 Email : <input type ="email" name ="tbemail" id ="tbemail"/><br>
 mobile : <input type ="text" name ="tbmobile" id ="tbmobile"/><br>
 password : <input type ="password" name ="tbpwd" id ="tbpwd"/><br>
 State: <select name ="ddlstates">
  <option value ="">---select---</option>
 
 <option value ="karnataka">KA</option>
 <option value ="Tamoilnadu">TN</option>
 <option value ="Andraparadesh">AP</option>
 <option value ="kerala">KL</option>

</select>
<br>
       
        <input type ="submit" value ="register"/>




</form>
</body>
</html>