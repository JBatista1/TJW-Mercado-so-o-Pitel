<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
* {
  box-sizing: border-box;
}

body {
  background-color: #ffffff;
  padding: 20px;
  font-family: Arial;
}
body {
  font-family: Verdana, sans-serif;
  margin: 0;
}

* {
  box-sizing: border-box;
}

.row > .column {
  padding: 0 8px;
}

.row:after {
  content: "";
  display: table;
  clear: both;
}

.column {
  float: left;
  width: 25%;
  transition: 0.3s;
}

/* The Modal (background) */
.modal {
  display: none;
  position: fixed;
  z-index: 1;
  padding-top: 100px;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: black;
}

/* Modal Content */
.modal-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  width: 90%;
  max-width: 1200px;
}

/* The Close Button */
.close {
  color: white;
  position: absolute;
  top: 10px;
  right: 25px;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #999;
  text-decoration: none;
  cursor: pointer;
}

.mySlides {
  display: none;
}

.cursor {
  cursor: pointer;
}

/* Next & previous buttons */
.prev,
.next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -50px;
  color: white;
  font-weight: bold;
  font-size: 20px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
  -webkit-user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover,
.next:hover {
  background-color: rgba(0, 0, 0, 0.8);
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

img {
  margin-bottom: -4px;
}

.caption-container {
  text-align: center;
  background-color: black;
  padding: 2px 16px;
  color: white;
}

.demo {
  opacity: 0.6;
}

.active,
.demo:hover {
  opacity: 1;
}

img.hover-shadow {
  transition: 0.3s;
}

.hover-shadow:hover {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
#rightbox{ 
float:right; 
}
.nobr { white-space: nowrap }

#left{float:left;width:100px;}
#right{float:right;width:100px;}
#center{margin:0 auto;width:100px;}

div {
    word-wrap: break-word;         /* All browsers since IE 5.5+ */
    overflow-wrap: break-word;     /* Renamed property in CSS3 draft spec */
    width: 100%;
}

</style>
<meta charset="ISO-8859-1">
<title>Mercadinho só ó Pitel</title>

</head>
<body>

<!--NavBAr-->

<div class="topnav">
<c:forEach items="${categorias}" var="categoria">
<a class="${categoria.catgoriaID == filter ? "active" : " "}" href="/MercadoSoOPitel/HomeController?filter=${categoria.catgoriaID}"><c:out value="${categoria.nome}"/></a>
</c:forEach>
  <a id = "rightbox" href= "/MercadoSoOPitel/HomeController?app=login">Login</a>
  <a id = "rightbox" href= "/MercadoSoOPitel/HomeController?app=cadastrar">Cadastro</a>
</div>

<div style="padding-left:16px">
  <h1>Mercadinho só o pitel</h1>
</div>

<!--Products-->
<h2 style="text-align:center">O que procura meu cumpade?</h2>

<div class="row">
<c:forEach items="${produtos}" var="produto">
  <div class="column hover-shadow cursor ">
    <img src ="<%=request.getContextPath()%>${produto.urlImage}" style="width:100%">
     <table style="width:100%">
        <tr>
        <td>
            <div>
               <h4 id = "left"><c:out value="${produto.nome}"/> </h4> 
            </div>
        </td>
        <td>
            <div>
               <h4 id = "right">R$:<c:out value="${produto.preco}"/></h4> 
             </div>
        </td>       
        </tr>
    </table>
    <div>
    	<p><c:out value="${produto.descricao}"/></p>
    </div>
    </c:forEach>
</div>


</body>
</html>
