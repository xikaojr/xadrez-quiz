<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="game.*"%>
<%@ page import="dao.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="css/Bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<%
			if (request.getAttribute("errorMessage") != null) {
		%>
		<div class="col-md-12">
			<div class="alert alert-danger">${errorMessage}</div>
		</div>
		<%
			}
		%>

		<form class="form-signin" role="form" action="login" method="POST">
			<h2 class="form-signin-heading">Log in</h2>
			<input type="text" name="login" class="form-control"
				placeholder="Login" required autofocus> <input
				type="password" name="senha" class="form-control"
				placeholder="Senha" required> <label class="checkbox">
				<input type="checkbox" value="remember-me"> Mater-me
				conectado
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Log
				in</button>
		</form>
	</div>
	<!-- /container -->
</body>
</html>