<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Enchère - Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../headerBanner.jsp"/>
	<div class="d-flex justify-content-center align-items-center mt-5">
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
		${message}
	</div>
</div>
</body>
</html>
