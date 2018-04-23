<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<title>Página da Excessão NullPointer</title>
		
		<!--Import Google Icon Font-->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
		<!-- Import materialize.css -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css" />
							
		<!-- Import CSS LOCAL -->
		<link href="/rex/assets/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	</head>
	
	<body class="background">
		
		
		
			<div class="container full-width col s12 m12 l12 center">
				<div>
					<h1>NullPointer</h1>
				</div>
				<div>
					<form>
						<button class="btn btn-primary" type="submit" formaction="/rex/index.jsp">
							Voltar
						</button>
						<button class="btn btn-primary" name="centro" value="landing-page.jsp" type="submit" formaction="/rex/IndexController">
							Início
						</button>
					</form>
				</div>
			</div>
		
		<!--Import jQuery before materialize.js-->
		<script src="https://code.jquery.com/jquery-3.2.1.min.js">
		</script>
		<!-- Compiled and minified JavaScript -->
		<script	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js">
		</script>
		
	</body>
</html>