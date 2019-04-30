<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js">
	</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js">
	</script>


<meta charset="ISO-8859-1">
<title>Página Mesário</title>
</head>
<head>
<link href="css/paginaMesario.css" rel="stylesheet">
</head>
<body>
	<form class="boxMesario" action="updateServelet" method="post">
		<h1>Formulário para liberar Eleitor</h1>
		
		<label for="txtCOD_TITULO"> <span>Número do título</span>
		<input type="text" id="titulo" name="txtCOD_TITULO" required maxlength="14" />
		</label>
		 
		<label for="txtZONA"> <span>Zona</span>
		<input type="text" name="txtZONA" required maxlength="3" />
		</label> 
		
		<label for="txtSECAO_ELEITORAL"> <span>Seção Eleitoral</span>
		<input type="text" name="txtSECAO_ELEITORAL" required maxlength="4" />
		</label>
		
		<div>
			<input type="radio" name="PERMITE_VOTAR" value="S"> Liberado
			<br> <input type="radio" name="PERMITE_VOTAR" value="N">
			Bloqueado <br>
		</div>
		
		<table class="tabela">
				<tr>
				<td><input type="submit" onClick="alteracao()" value="Validar"/></td>
					<td><input type="submit" onclick="redirecionar()"  value="Sair" /></td>
				</tr>
			</table>
	</form>
	
	<script type="text/javascript">
	function redirecionar() {
  	  alert("Obrigada por colaborar com a votação.");
        window.location.href = "login.jsp";
     }
       
       function alteracao() {
    	   	alert("Eu sou um alert!");
     	 	window.location.href = "login.jsp";
        }
    </script>
</body>
</html>