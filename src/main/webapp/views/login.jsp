<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Hind+Siliguri:wght@600&display=swap"
	rel="stylesheet" />
<title>Login page</title>
</head>
<body>
	<nav class="navbar navbar-light">
		<div class="container-fluid">
			<span class="navbar-text"> Query Books </span>
		</div>
	</nav>
	<div class="container-fluid col-lg-6 col-md-6 col-sm-6">
		<div id="header-section">
			<h3>Login</h3>
		</div>
		<div id="middle-section">
			<form action="" method="post">
				<div class="row mb-3">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Username</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3"
							name="username" placeholder="your@gmail.com">
					</div>
				</div>
				<div class="row mb-3">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3"
							name="password" placeholder="Enter your password">
					</div>
				</div>
				<input type="submit" value="Login" class="btn btn-primary">
				
			</form>
		</div>

	</div>
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>