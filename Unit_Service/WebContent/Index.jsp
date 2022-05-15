<%@ page import="com.Unit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unit Service</title>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Components/jquery-3.4.1.min.js"></script> 
<script src="Components/valicustom.js"></script> 
</head>
<body>
 <nav class="navbar navbar-dark bg-dark" style="justify-content: center">
            <h3 style="color: white">ElectroGrid</h3>
     </nav>
     <br>
<div class="container"style="max-width: 90%"> 
<div style="text-align: center">
		<h1>Billing Service</h1><br></br>
	</div>
	<div class="row">  
		<div class="col-4"> 
		
				<form id="formUnit" name="formUnit" method="post" action="Index.jsp">  
					Account No:  
 	 				<input id="uAccNo" name="uAccNo" type="text"  class="form-control form-control-sm">
					<br>Email:   
  					<input id="uEmail" name="uEmail" type="text" class="form-control form-control-sm">   
  					<br>Unit Total:   
  					<input id="uTotalUnit" name="uTotalUnit" type="text"  class="form-control form-control-sm">
					<br>Total Amount:   
  					<input id="uAmount" name="uAmount" type="text"  class="form-control form-control-sm">
					<br>  
					<input id="btnSave" name="btnSave" type="button" value="SAVE" class="btn btn-info">  
					<input type="hidden" id="hidUnitIDSave" name="hidUnitIDSave" value=""> 
				</form>
				
			   <br>
			   
				<div id="alertSuccess" class="alert alert-success"> </div>
				
			   <div id="alertError" class="alert alert-danger"></div>
			   <br>
			   </div>
				
				<div id="divUnitGrid"class="col-8" style="text-align: center">
				<br>
					<%
						Unit UnitObj = new Unit();
						out.print(UnitObj.readUnit());
					%>
				</div>
				
				 
			</div>
		</div>

 
</body>
</html>