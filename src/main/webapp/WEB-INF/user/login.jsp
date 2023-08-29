<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Enchère - Connexion</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">
	<div class="card text-center w-50">
		<div class="card-body">
			<form class="mb-4" action="LoginServlet" method="post">
				<div class="mb-3 d-flex">
					<label for="pseudo" class="form-label me-2 text-nowrap">Identifiant:</label>
					<input type="text" class="form-control" id="pseudo" name="pseudo"/>
				</div>
				<div class="mb-3 d-flex">
					<label for="motdepasse" class="form-label me-2 text-nowrap">Mot de passe:</label>
					<input type="password" class="form-control" id="motdepasse" name="motdepasse"/>
				</div>
				<div class="row mb-3">
					<div class="col">
						<div class="d-flex justify-content-center">
							<button type="submit" class="btn btn-primary">Connexion</button>
						</div>
					</div>
					<div class="col">
						<div class="form-check d-flex justify-content-center">
							<input type="checkbox" class="form-check-input" id="rememberMe"/>
							<label class="form-check-label ms-2 text-nowrap" for="rememberMe">Se souvenir de moi</label>
						</div>
						<div class="mt-2">
							<a href="#" class="text-muted text-nowrap">Mot de passe oublié</a>
						</div>
					</div>
				</div>
			</form>
			
			<button class="btn btn-secondary btn-lg btn-block">Créer un compte</button>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
