<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
	  
		<title>Cadastro Acesso</title>
	
			<!-- CSS  -->
			<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
			<!-- Import materialize.css -->
			<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
			<!-- Import CSS LOCAL -->
			<link href="/rex/assets/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	</head>
	<body class="background">
	
		<div class="container full-width col s12 m12 l12">
			<fieldset class="row">
						<legend>Cadastro de Doação</legend>
	
				<form id="teste" method="post" action="/rex/CadastroAcesso">
					<ul id="tabs-swipe-demo" class="tabs background">
						<li class="tab col s6 m6 l6"><a class="active" href="#tab-endereco">Endereço</a></li>
						<li class="tab col s6 m6 l6"><a href="#tab-material">Material</a></li>
					</ul>

					<div id="tab-endereco" class="container full-width col s12 m12 l12">
								<fieldset class="row">
								
									<legend>Dados Gerais:</legend>
									
									
									<div class="col s12 m12 l12 row">
									<div class="input-field col s12 m7 l3">
										<select>
											<option value="" disabled="disabled" selected="selected">Selecione</option>
											<option value="bra" selected="selected">Brasil</option>
										</select>
										<label>País</label>
									</div>
									
									<div class="input-field col s12 m5 l3">
										<input id="cep" name="cep" type="text" class="validate" required="required" maxlength="8" onkeypress="return mascaraGenerica(event, this, '####-###');" />
										<label for="cep">CEP</label>
										
									</div>

									<div class="input-field col s12 m12 l6">
										<select id="estado" class="validate">
											<option value="" disabled="disabled" selected="selected">Selecione</option>
											<option value="sc">Santa Catarina</option>
											<option value="rs">Rio Grande do Sul</option>
										</select>
										<label for="estado">Estado</label>
									</div>
									</div>
									
									<div class="col s12 m12 l12 row">
									<div class="input-field col s12 m6 l6">
										<input type="text" id="autocomplete-input-municipio" />
										<label for="autocomplete-input-municipio">Município</label>
									</div>
									<div class="input-field col s12 m6 l6">
										<input type="text" id="autocomplete-input-bairro" />
										<label for="autocomplete-input-bairro">Bairro</label>
									</div>	
									</div>
									
									<div class="col s12 m12 l12 row">
									<div class="input-field col s12 m5 l4">
										<select id="tipo-logradouro" class="validate">
											<option value="" disabled="disabled" selected="selected">Selecione</option>
											<option value="rua">Rua</option>
											<option value="avenida">Avenida</option>
										</select>
										<label for="tipo-logradouro">Tipo Logradouro</label>	
									</div>
									
									<div class="input-field col s12 m7 l8">
										<input type="text" id="autocomplete-input-logradouro" />
										<label for="autocomplete-input-logradouro">Logradouro</label>
									</div>
									
									</div>
									
									
									<div class="input-field col s12 m9 l9">
										<input id="complemento" name="complemento" type="text" class="validate" required="required" />
										<label for="complemento">Complemento</label>
									</div>
									
									<div class="input-field col s12 m3 l3">
										<input id="numero" name="numero" type="text" class="validate" required="required" />
										<label for="numero">Numero</label>
									</div>			
								</fieldset>
					</div>
					<div id="tab-material" class="container full-width col s12 m12 l12">
								<fieldset class="row">
								
									<legend>Dados dos Materiais:</legend>

										<div class="input-field col s12 m6 l6">
											<select id="tipo-pessoa" class="validate">
												<option value="" disabled="disabled">Selecione</option>
												<option value="fisica" selected="selected">Física</option>
												<option value="juridica">Jurídica</option>
											</select>
											<label for="tipo-pessoa">Tipo de Pessoa</label>
										</div>
										
										<div class="input-field col s12 m6 l6">
											<input id="doc" name="doc" type="text" class="validate" required="required" maxlength="14" onkeypress="return mascaraGenerica(event, this, '###.###.###-##');" />
											<label for="doc">CPF/CNPJ:</label>
										</div>
										
										<div class="input-field col s12 m5 l6">
											<input id="nome" name="nome" type="text" class="validate nome-proprio" required="required" />
											<label for="nome">Nome</label>
										</div>
						
										<div class="input-field col s12 m7 l6">
											<input id="sobrenome" name="sobrenome" type="text" class="validate nome-proprio" required="required" /> 
											<label for="sobrenome">Sobrenome</label>
										</div>
									
								</fieldset>
					
					</div>
			
						<div class="col s12 m12 l12 center">
								<button class="btn waves-effect blue white-text">Salvar</button>
								<button class="btn waves-effect red white-text" type="reset">Limpar</button>
								
								<button class="btn waves-effect blue-grey white-text" formmethod="get" name="centro" value="landing-page.jsp"
										formnovalidate="formnovalidate" formaction="/rex/IndexController">Início</button>
			
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