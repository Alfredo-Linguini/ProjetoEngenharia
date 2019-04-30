<%@page import="servelet.NivelControllers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nível de usuário</title>
</head>
<head>
<link href="css/nivel.css" rel="stylesheet">
</head>
<body>
<form class = "boxNivel" name="formnivel" action="nivel" method="post">
<h1>Informe seu nível </h1>
  <select class="basic" id=opcao name=opcao>
    <option value="" ></option>
    <option value="1" >Eleitor</option>
    <option value="2" >Mesário</option>
    <option value="3" >Chefe de seção</option>
</select>
<input type="submit" name="enviar" value="Entrar">
</form>
</body>
</html>