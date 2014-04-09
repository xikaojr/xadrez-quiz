<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="game.*"%>
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

<link href="css/Bootstrap.min.css"
	  rel="stylesheet">
</head>
<body>
	<div class="container bs-docs-container">
		<div class="row" role="main">
			<div class="col-md-12">
				<h1 id="overview" class="page-header">Chess Quiz</h1>
			</div>
			<div class="col-md-4">
				<h3 id="overview-doctype">The Game</h3>
				<form method="post" action="requestGame" role="form">
					<div class="form-group">
						<label for="cell">Célula</label>
						<input type="text"
							name="cell"
							class="form-control" id="cell" placeholder="Cell"
							readonly="readonly" value="<%=Game.getRandCell()%>">
					</div>
					<div class="form-group">
						<label for="gamer">Gamer</label> 
						<select name="gamer" 
							class="form-control">
							<%
								for (int i = 1; i <= 10; i++) {
							%>
							<option value="<%=i%>">Jogador -
								<%=i%></option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<label for="resposta">Resposta</label><br/>
						<input type="radio" checked="checked" name="resposta" value="<%=Game.WHITE%>" />
						<label>WHITE</label> <br /> 
						<input type="radio" name="resposta" value="<%=Game.BLACK%>" />
						<label>BLACK</label>
					</div>
					<div class="well">
						<input type="submit" value="ENVIAR" class="btn btn-primary">
						<a href="requestGame" class="btn btn-warning">Zerar Resultados</a>				      
				    </div>
				</form>
			</div>
			<div class="col-md-8">
				<h3 id="overview-doctype">Results</h3>
				${jogo}
			</div>
		</div>
	</div>
</body>
</html>