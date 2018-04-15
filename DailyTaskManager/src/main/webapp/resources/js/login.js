


function validate(){
	
		
	if($('[name = "userName"]').val() == ''){
		alert("Please enter email id ");
		$('[name = "userName"]').focus();
		return false;
	}else if($('[name = "password"]').val() == ''){
		
		alert("Please enter password")
		$('[name = "password"]').focus();
		return false;
	}
	
	return true;
	
}

function toggleDiv(){
	
	 $('#username').val("");
	 $('#emailId').val("");
	$('#upassword').val("");
	 $('#cpassord').val("");
	 $('[name = "userName"]').val("");
	 $('[name = "password"]').val("");
	 
	$('.registermodule').toggle();
	$('.loginmodule').toggle();

}

function registerValidate(){
	
	var username = $('#username'),
	emailId = $('#emailId'),
	password = $('#upassword'),
	cpassord = $('#cpassord');
	
	console.log(cpassord.val())
	if(username.val() == '' ){
		alert('Please enter your name .');
		username.focus();
		return;
		
	}else if(emailId.val() == '' ){
		alert('Please enter your E-mail Id .');
		emailId.focus();
		return;
		
	}else if(password.val() == ''){
		alert('Please enter your password .');
		password.focus();
		return;
		
	}else if( cpassord.val() == ''){
		alert('Please enter your password .');
		cpassord.focus();
		return;
		
	}else if(password.val() !=  cpassord.val()){
		alert('Sorry Password not match .');
		password.focus();
		return;
		
	}
	
	var obj = {
			emailId : emailId.val(),
			userName : username.val(),
			password : password.val(),
			status : "Active"
			
	}
	
	
	var register = postMehod('register',JSON.stringify(obj));

	register.done(function(data){

		alert("Registered Sucessfuly. Sign in using your email id");
		toggleDiv();
		return;
	})
	

	
	
}
