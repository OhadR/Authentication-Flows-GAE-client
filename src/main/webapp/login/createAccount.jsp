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
							<p>Authentication-Flows is a powerful and highly customizable
								framework that covers all flows that authentication-server that
								is based on Spring-Security needs.</p>
							<p></p>
							<p>Flows are Create Account, Forgot Password, Change Password, etc. This demonstration
								walks through all flows. Please login, or Create Account (using 'Authentication-Flows')</p>
							<p></p>
							<p>Create Account flow: an activation email will be sent to the given e-mail, with activation link.
							   The user will have to activate his account (by clicking the link) before he can use it.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<h3>Create Account</h3>

	<%   
	    if ( null != request.getParameter("err_msg") ) {
	%>	
	<div style="margin-top:  25px ;position: relative; color: red; font:15px">
		<span style="font-weight:bold"><%= request.getParameter("err_msg") %></span>
	</div>
	<%   } %>
	
	<form name='f' 
		action='../createAccount'
		method='POST'>
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