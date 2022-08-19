<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.nagarro.clientapp.service.Book"%>
<%
List<Book> bookdata = (List<Book>) session.getAttribute("booksdata");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; ">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Hind+Siliguri:wght@600&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/homestyle.css" />
<title>Home page</title>
</head>
<body>
	<nav class="navbar navbar-light">
		<div class="container-fluid">
			<span class="navbar-text">Query for Books </span> <span
				id="user-show"> Hello <%=session.getAttribute("username")%></span>
			<form class="d-flex" action="logout" method="post">
				<button class="logout-btn btn btn-primary" type="submit">
					logout</button>
			</form>
		</div>
	</nav>


	<div class="row mb-4 input-details">
		<span id="input-detail-text"> Please enter Book details to add </span>

		<form action="addbook" method="post">
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">bookcode</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
						name="bookcode" placeholder="bookcode" />
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">Author</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputPassword3"
						name="author" placeholder="author" />
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">bookname</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
						name="bookname" placeholder="bookname" />
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">dateadded</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="inputEmail3"
						name="dateadded" placeholder="date added" />
				</div>
			</div>

			<div class="d-grid gap-2 d-md-block">
				<button class="browse-btn btn btn-primary" type="submit">
					Enter</button>
			</div>
		</form>
	</div>
	
	
	<div class="container-fluid">
		<table class="table table-striped">

			<thead>
				<th class="table-heading" style="text-align: center;">SNo</th>
				<th class="table-heading" style="text-align: center;">BookCode</th>
				<th class="table-heading" style="text-align: center;">Author</th>
				<th class="table-heading" style="text-align: center;">BookName</th>
				<th class="table-heading" style="text-align: center;">Dateadded</th>
				<th class="table-heading" style="text-align: center;"></th>
				<th class="table-heading" style="text-align: center;"></th>
			</thead>

			<tbody>
				<%
					int i=0;
					for (Book iter : bookdata) {
						i++;
				%>
				<tr>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%= i %></td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%= iter.getBookcode()%>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%= iter.getAuthor()%>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%= iter.getBookname()%>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%= iter.getDateaddedString() %>
					</td>
							<td class="table-data"
						style="text-align: center; vertical-align:middle;">
						<form action="edit" method="get">
							<button class="btn btn-primary" type="submit" name="submit"
								value="<%= iter.getId() %>">Edit</button>
						</form>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;">
						<form action="delete" method="post">
							<button class="btn btn-primary" type="submit" name="submit"
								value="<%= iter.getId() %>">Delete</button>
						</form>
					</td>
					
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>