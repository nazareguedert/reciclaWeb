<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
		
		<title>RecilAPP Index Page</title>
	
			<!-- CSS  -->
			<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
			<!-- Import materialize.css -->
			<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
			<!-- Import CSS LOCAL -->
			<link href="/rex/assets/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	</head>
	
	<body class="background">
		<div class="navbar-fixed">
			<nav class="teal darken-3" role="navigation">
				<div class="nav-wrapper container">
					<a href="/rex/IndexController?centro=landing-page.jsp" id="logo-container" class="brand-logo">
						RecilAPP
					</a>
					
					<ul class="right hide-on-med-and-down">
						<li><a href="/rex/IndexController?centro=reciclagem.jsp">Reciclagem</a></li>
						<li><a href="/rex/IndexController?centro=cadastro-doacao.jsp">Doar</a></li>
						<li><a href="#">Pontos de Coleta</a></li>
						<li><a href="/rex/IndexController?centro=login.jsp">Login</a></li>
					</ul>
					
					<a href="#" data-activates="nav-mobile" class="button-collapse">
						<i class="material-icons">menu</i>
					</a>
				  
				</div>
			</nav>
		</div>
	  		<ul id="nav-mobile" class="side-nav">
					<li><a href="/rex/IndexController?centro=reciclagem.jsp">Reciclagem</a></li>
					<li><a href="/rex/IndexController?centro=cadastro-doacao.jsp">Doar</a></li>
					<li><a href="#">Pontos de Coleta</a></li>
					<li><a href="/rex/IndexController?centro=login.jsp">Login</a></li>
			</ul>
	  
	  
	  
		<!-- LÓGICA DO CENTRO DINÂMICO -->
		<script src="https://www.w3schools.com/lib/w3.js">
		</script>
		<div w3-include-html=${ centro != null ? centro : 'landing-page.jsp' } >
		 </div>
		<script>
			w3.includeHTML();
		</script> 
		
<!-- 			<div w3-include-html="landing-page.jsp"> 			-->
		 		<%
// 				 		if(session.getServletContext().getAttribute("centro") != null) {
// 				 		if(request.getAttribute("centro") != null) {
// 				 			out.println(session.getServletContext().getAttribute("centro"));
// 				 			out.println(request.getAttribute("centro"));
// 				 		} 
// 				 		else {
// 				 			out.println("landing-page.jsp");
// 				 		}
			 		%>
			 		
<%-- 			 		<c:if test="${ centro != null }"> --%>
<%-- 						${centro} --%>
<%-- 					</c:if> --%>
<%-- 			 		<c:if test="${ centro == null }"> --%>
<%-- 						${'landing-page.jsp'} --%>
<%-- 					</c:if> --%>
		
		<footer class="page-footer teal darken-4">
		  <div class="container">
		    <div class="row">
		      <div class="col s12 m8 l10">
		        <h5 class="white-text">Você em um mundo de boas relações</h5>
		        <p class="grey-text text-lighten-4 justificado">Somos uma equipe realizando um projeto que nasce para conclusão do curso com intenção de expandir ao mercado e melhorar a qualidade de vida tanto para quem possui muitos materiais a doar quanto aos profissionais do ramo.</p>
				<p class="grey-text text-lighten-4">Autores: Nazaré, Augusto, Nilton, Guilherme</p>
		
		      </div>
<!-- 		      <div class="col l3 s12"> -->
<!-- 		        <h5 class="white-text">Settings</h5> -->
<!-- 		        <ul> -->
<!-- 		          <li><a class="white-text" href="#!">Link 1</a></li> -->
<!-- 		          <li><a class="white-text" href="#!">Link 2</a></li> -->
<!-- 		          <li><a class="white-text" href="#!">Link 3</a></li> -->
<!-- 		          <li><a class="white-text" href="#!">Link 4</a></li> -->
<!-- 		        </ul> -->
<!-- 		      </div> -->
		      <div class="col s12 m4 l2">
		        <h5 class="white-text">Contato</h5>
		        <ul>
		          <li><a class="white-text" href="#!">Presidente</a></li>
		          <li><a class="white-text" href="#!">Supervisor</a></li>
		          <li><a class="white-text" href="#!">Implementador</a></li>
		          <li><a class="white-text" href="#!">Implementador</a></li>
		        </ul>
		      </div>
		    </div>
		  </div>
			<div class="footer-copyright teal darken-3">
			    <div class="container">
			    <p>Made by <a class="yellow-text text-lighten-3" href="http://materializecss.com" target="_blank">Materialize</a></p>
			    <p>on <a class="orange-text text-lighten-3" href="http://materializecss.com/templates/starter-template/preview.html" target="_blank">Starter Template</a></p>
			    </div>
			</div>
		  
		</footer>
	
	
	
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