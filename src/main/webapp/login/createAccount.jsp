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

							<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top"> 
								<input type="hidden" name="cmd" value="_s-xclick"> 
								<input type="hidden" name="encrypted" value="-----BEGIN PKCS7-----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-----END PKCS7-----">
								<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!"> <img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
							</form>
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