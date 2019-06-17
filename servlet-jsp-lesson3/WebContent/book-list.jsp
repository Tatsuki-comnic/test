<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Book List</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	</head>
	
	<body class="#efebe9 brown lighten-5">
		<div class="container">
			<nav>
				<div class="nav-wrapper #a1887f brown lighten-2">
					<a href="#" class="brand-logo">Book List</a>
					<ul id="nav-mobile" class="right hide-on-med-and-down">
						<li>LastLoginTime: <javatime:format value="${account.lastLoginTime}" pattern="hh:mm:ss" /></li>
						<li><a href="logout.do"><i class="material-icons">exit_to_app</i></a></li>
					</ul>
				</div>
			</nav>
			
			<h1>Book List</h1>
			
			<form action="book-list.do" method="post">
				<div class="row">
					<div class="input-field col s6">
	                   	<input id="title" name="title" type="text" class="validate">
	                    <label for="title">TITLE</label>
		            </div>
		            <div class="input-field col s6">
			            <input type="submit" value="Find" 
		            	       class="btn waves-effect #d7ccc8 brown lighten-4">
	            	</div>
	            </div>
			</form>
			
			<c:if test="${param.title.length() > 0}">
				<h5>Search results for the title: <span class="red-text darken-4">${param.title}</span></h5>
			</c:if>
			
			<table class="highlight responsive-table">
				<tr>
					<th></th>
					<th>ISBN</th>
					<th>TITLE</th>
					<th>AUTHOR</th>
					<th>PUBLISHER</th>
					<th>PRICE</th>
				</tr>
				<c:forEach var="book" items="${bookList}">
					<tr>
						<td><img src="img/${book.isbn}.webp" width="65px" height="15%"></td>
						<td>${book.isbn}</td>
						<td>${book.title}</td>
						<td>${book.author.name}</td>
						<td>${book.publisher.name}</td>
						<td><fmt:formatNumber value="${book.price}" type="CURRENCY" currencyCode="USD" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>