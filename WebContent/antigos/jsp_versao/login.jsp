<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		
		<title>Login</title>
		
			<!--Import Google Icon Font-->
			<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
			<!-- Import materialize.css -->
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css" />
			<!-- Import CSS LOCAL -->
			<link href="/rex/assets/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	</head>
	
	<body class="container full-width row blue-grey lighten-5">
		
		
		
			<div class="container full-width col s12 m12 l12" style="max-width:500px;">
			<fieldset class="row">
				<legend>Acesso Sistema</legend>
	
				<form id="teste" method="post" action="#">
	
					<div class="input-field col s12 m12 l12">
						<input id="nome" name="nome" type="text" class="validate" required="required" />
						<label for="nome">Login</label>
					</div>
	
					<div class="input-field col s12 m12 l12">
						<input id="senha" name="senha" type="password" class="validate" required="required" />
						<label for="senha">Senha</label>
					</div>
		
					<div class="container full-width col s12 m12 l12">
						<fieldset class="row blue-grey lighten-4">
							<legend>Cadastro</legend>	
	
							<div class="col s12 m12 l12">
								<a href="/rex/IndexController?centro=cadastro-acesso.jsp">Realizar Cadastro</a>
							</div>
							<div class="col s12 m12 l12">
								<a href="#!">Recuperar Cadastro</a>
							</div>							
						</fieldset>
					</div>
	
					<div class="row center">
						<button class="btn waves-effect blue white-text">Entrar</button>
						<button class="btn waves-effect red white-text" type="reset">Limpar</button>
						
						<button class="btn waves-effect blue-grey white-text" formmethod="post" 
								formnovalidate="formnovalidate" formaction="/rex/IndexController?centro=landing-page.jsp">Início</button>
	
					</div>
				</form>
			</fieldset>
		</div>
		
		<!--Import jQuery before materialize.js-->
		<script src="https://code.jquery.com/jquery-3.2.1.min.js">
		</script>
		<!-- Compiled and minified JavaScript -->
		<script	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js">
		</script>
		<!-- Scripts Locais -->
		<script src="/rex/assets/js/init.js">
		</script>
	</body>
</html>