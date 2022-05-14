$(document).ready(function() 
{  
		$("#alertSuccess").hide();  
	    $("#alertError").hide(); 
}); 
 
 
// SAVE ============================================ 
$(document).on("click", "#btnSave", function(event) 
{  
	// Clear alerts---------------------  
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text("");  
	$("#alertError").hide(); 
 
	// Form validation-------------------  
	var status = validateUnitForm();  
	if (status != true)  
	{   
		$("#alertError").text(status);   
		$("#alertError").show();   
		return;  
	} 
 
	// If valid------------------------  
	var type = ($("#hidUnitIDSave").val() == "") ? "POST" : "PUT"; 

	$.ajax( 
	{  
			url : "UnitService",  
			type : type,  
			data : $("#formUnit").serialize(),  
			dataType : "text",  
			complete : function(response, status)  
			{   
				onUnitSaveComplete(response.responseText, status);  
			} 
	}); 
}); 


function onUnitSaveComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			$("#alertSuccess").text("Successfully saved.");    
			$("#alertSuccess").show(); 

			$("#divUnitGrid").html(resultSet.data);   
		} else if (resultSet.status.trim() == "error")   
		{    
			$("#alertError").text(resultSet.data);    
			$("#alertError").show();   
		} 

	} else if (status == "error")  
	{   
		$("#alertError").text("Error while saving.");   
		$("#alertError").show();  
	} else  
	{   
		$("#alertError").text("Unknown error while saving..");   
		$("#alertError").show();  
	} 

	$("#hidUnitIDSave").val("");  
	$("#formUnit")[0].reset(); 
} 

 
// UPDATE========================================== 
$(document).on("click", ".btnUpdate", function(event) 
{     
	$("#hidUnitIDSave").val($(this).closest("tr").find('#hidUnitIDUpdate').val());     
	$("#uAccNo").val($(this).closest("tr").find('td:eq(0)').text());     
	$("#uEmail").val($(this).closest("tr").find('td:eq(1)').text());
	$("#uTotalUnit").val($(this).closest("tr").find('td:eq(2)').text());
	$("#uAmount").val($(this).closest("tr").find('td:eq(3)').text());     
}); 




//REMOVE===========================================
$(document).on("click", ".btnRemove", function(event) 
{  
	$.ajax(  
	{   
		url : "UnitService",   
		type : "DELETE",   
		data : "uID=" + $(this).data("unitid"),   
		dataType : "text",   
		complete : function(response, status)   
		{    
			onUnitDeleteComplete(response.responseText, status);   
		}  
	}); 
}); 

function onUnitDeleteComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			
			$("#alertSuccess").text("Successfully deleted.");    
			$("#alertSuccess").show(); 
		
			$("#divUnitGrid").html(resultSet.data); 
			
		} else if (resultSet.status.trim() == "error")   
		{    
			$("#alertError").text(resultSet.data);    
			$("#alertError").show();   
		}
		

	} else if (status == "error")  
	{   
		$("#alertError").text("Error while deleting.");   
		$("#alertError").show();  
	} else  
	{   
		$("#alertError").text("Unknown error while deleting..");   
		$("#alertError").show();  
	}
}
 
// CLIENT-MODEL========================================================================= 
function validateUnitForm() 
{  
	// ACCOUNT  
	var tmpAccNo = $("#uAccNo").val().trim();
	if (!$.isNumeric(tmpAccNo)) 
	 {
	 return "Insert Account No.";
	 }

	// EMAIL------------------------  
	if ($("#uEmail").val().trim() == "")  
	{   
		return "Insert Email.";  
	} 
	
	// UNIT------------------------  
	var tmpUnit = $("#uTotalUnit").val().trim();
	if (!$.isNumeric(tmpUnit)) 
	 {
	 return "Insert Unit.";
	 }
	
	
	//AMOUNT-------------------------------
	 var tmpAmount = $("#uAmount").val().trim();
	if (!$.isNumeric(tmpAmount)) 
	 {
	 return "Insert Amount.";
	 }

	return true; 
}