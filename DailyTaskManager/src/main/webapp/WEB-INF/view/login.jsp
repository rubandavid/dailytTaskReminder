<!DOCTYPE html>

    
<html>
	<head>
		<meta charset="utf-8">
		<title>Login Page</title>
		 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/css/login.css">
  
  <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" media="screen" />
		
	</head> 
	<body>
	
	<div class="backGroundImg">
	

	
	<div class="loginForm">
	<div class="dtm">Daily Task Manager</div>
	<div class="loginmodule">
	<div class="msg"><%=session.getAttribute("msg")%></div>
	<form action="validateUser" method="POST" onsubmit='return validate()'>
	
		<div class="shell"><input type="email" placeholder="E-mail address" name="userName"/></div>
		<div class="shell"> <input type="password" placeholder="Password" name="password"/></div>
		<div class="btnset"><button class ="btn" type= 'submit'>Sign In</button>&nbsp;&nbsp;&nbsp;<div class ="btn"  onclick="toggleDiv()" >Sign Up</div></div>
		</form>
		</div>
		<div class="registermodule">
		
		<div class="form" >
	
		<div class="shell"><input type="text" id="username" placeholder="Enter your Name" /></div>
		<div class="shell"> <input type="email" id="emailId" placeholder="Enter E-mail Id" /></div>
		<div class="shell"> <input type="password" id="upassword" placeholder="Enter Password" /></div>
		<div class="shell"> <input type="password" id="cpassord" placeholder="Re-enter Password" /></div>
		
		<div class="btnset"><button class ="btn" onclick='registerValidate()'>Register</button>&nbsp;&nbsp;&nbsp;<div class ="btn" onclick="toggleDiv()" >Back</div></div>
		</div>
		
		
		</div>
	</div>	
		
	</div>	
		<div class="footer">dtm@DailyTaskManager pvt ltd</div>
		<script src='resources/js/jquery.min.js'></script>
			<script src='resources/js/common.js'></script>
		<script src='resources/js/login.js'></script>
	
	</body>
</html>
