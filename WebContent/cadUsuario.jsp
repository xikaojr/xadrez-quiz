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
<link href="css/Bootstrap.min.css" rel="stylesheet">
<title>Cadastro de Usuário</title>
</head>
<body>
	<div class="container bs-docs-container">
		<div class="row" role="main">
			<div class="col-md-12">
				<h1 id="overview" class="page-header">Cadastro de Usuário</h1>
			</div>
			<form role="form" name="cadUsuario" method="POST" action="">
				<div class="col-md-12">
					<div class="form-group col-md-4">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" id="nome" placeholder="Entre com seu nome">
					</div>
					<div class="form-group col-md-4">
						<label for="login">Login</label> <input type="text"
							class="form-control" id="login" placeholder="Login">
					</div>
					<div class="form-group col-md-4">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" placeholder="Password">
					</div>
				</div>
				<div class="" style="clear: both;"></div>
				<div class="col-md-4">
					<button type="submit" class="btn btn-default">Enviar</button>
					<button type="reset" class="btn btn-danger">Limpar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>