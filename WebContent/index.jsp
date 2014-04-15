<%@page import="com.sun.corba.se.spi.activation.Repository"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="game.*"%>
<%@ page import="dao.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	if (request.getMethod() == "POST") {

	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acerte a Cor</title>

<link href="css/Bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container bs-docs-container">
		<div class="row" role="main">
			<div class="col-md-12">
				<h1 id="overview" class="page-header">Chess Quiz</h1>
			</div>
			<%
				if (request.getAttribute("successMessage") != null) {
			%>
			<div class="col-md-12">
				<div class="alert alert-success">${successMessage}</div>
			</div>
			<%
				}
			%>

			<%
				if (request.getAttribute("errorMessage") != null) {
			%>
			<div class="col-md-12">
				<div class="alert alert-danger">${errorMessage}</div>
			</div>
			<%
				}
			%>

			<%
				if (request.getSession().getAttribute("jogador") != null) {
					Gamer jogador = (Gamer) request.getSession().getAttribute(
							"jogador");
			%>

			<h3 id="overview-doctype">Boa Sorte!</h3>
			<form method="post" action="requestGame" role="form">
				<div class="col-md-4">
					<div class="form-group">
						<label for="cell">Célula</label> <input type="text" name="cell"
							class="form-control" id="cell" placeholder="Cell"
							readonly="readonly" value="<%=Game.getRandCell()%>">
					</div>
					<div class="form-group">
						<label for="gamer">Jogador: </label><%=jogador.Nome%>
						<br /> <input type="hidden" name="gamer" value="<%=jogador.Id%>" />
						<label>Login: </label>
						<%=jogador.Login%>
					</div>
					<div class="form-group">
						<label for="resposta">Resposta</label><br /> <input type="radio"
							checked="checked" name="resposta" value="<%=Game.WHITE%>" /> <label>WHITE</label>
						<br /> <input type="radio" name="resposta"
							value="<%=Game.BLACK%>" /> <label>BLACK</label>
					</div>
				</div>
				<div class="col-md-8">
					<h3 id="overview-doctype">Resultado Parcial</h3>
					<%=jogador.getJogadas()%>
				</div>
				<div class="col-md-12">
					<div class="well">
						<input type="submit" value="ENVIAR" class="btn btn-primary">
						<a class="btn btn-danger" href="logoff.jsp">Sair</a>
						<%
							if (jogador.getTentativas() >= 20) {
						%>
						<a class="btn btn-default" href="ranking.jsp">Ranking</a>
						<%
							}
						%>
					</div>
				</div>

				<%
					} else {
						request.setAttribute("errorMessage",
								"Ocorreu um erro, verifique seus dados e tente novamente!");
						response.sendRedirect("login.jsp");
					}
				%>
			</form>
		</div>
	</div>
	</div>
</body>
</html>