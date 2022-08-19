<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; ">
<meta name="viewport" content="width=device-width, initial-scale=1" />
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
<title>Edit page</title>
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
		<span id="input-detail-text"> Please enter Book details to add
		</span>

		<form action="edit" method="post">
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
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>
