<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="http://projects.spring.io/spring-security/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" 	href="http://projects.spring.io/spring-security/font-awesome/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="http://projects.spring.io/spring-security/bootstrap/css/bootstrap-select.css"/>
	<link rel="stylesheet" type="text/css"
		href="http://projects.spring.io/spring-security/css/main.css.css" />
	<link rel="stylesheet" type="text/css" href="http://projects.spring.io/spring-security/css/typography.css.css"/>
	<link rel="stylesheet" type="text/css" href="http://projects.spring.io/spring-security/css/icons.css.css"/>
	<link rel="stylesheet" type="text/css"
		href="http://projects.spring.io/spring-security/css/projects.css.css" />
	<link rel="stylesheet" type="text/css" href="../css/auth-flows.css"/>

	<script type="text/javascript" src="https://code.jquery.com/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="./javascript/oauth.js"></script>
	<title>Create Account Page</title>
</head>

<body onload='document.f.email.focus();InitCreateAccount();'>

	<div class="billboard--wrapper project-header--wrapper">
		<div class="billboard--container">
			<div class="project-icon"></div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span8 billboard--area">
						<div class="content--title">
							<p>
								<a href="http://www.ohadr.com">OHADR.COM</a>
							</p>
						</div>
						<div class="project--title">
							Authentication-Flows Demo: Create Account Page
						</div>
						<div class="project--description">
							<p>Create Account flow: an activation email will be sent to the given e-mail, with activation link.
							   The user will have to activate his account (by clicking the link) before he can use it.</p>
							<p>The link is created using crypto library. It contains the timestamp and the username. Encrpytion is 
								crucial so hackers cannot intercept or forge links.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<form name='f' action='../createAccount' method='POST'>
		<h3>Create Account</h3>
	
		<%   
		    if ( null != request.getParameter("err_msg") ) {
		%>	
		<div style="margin-top:  25px ;position: relative; color: red; font:15px">
			<span style="font-weight:bold"><%= request.getParameter("err_msg") %></span>
		</div>
		<%   } %>

		<table>
			<tr>
				<td>User (Email):</td>
				<td><input type='text' name='email' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type='password' name='confirm_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value='Create Account' /></td>
			</tr>
		</table>
	</form>
</body>
</html>