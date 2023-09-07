<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Enchère - Mot de passe oublié</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body class="bg-light">
	<jsp:include page="../headerBanner.jsp"/>
	<div class="d-flex justify-content-center align-items-center mt-5 bg-white rounded p-4 shadow container py-5">
		<div class="card border-0 text-center w-50">
			<h3 class="mx-2">Mot de passe oublié</h3>
			<c:if test="${message != null}">
				<div id="message" class="alert alert-primary my-2 cursor-pointer" role="alert">
				  ${message}
				</div>
			</c:if>
			<div class="card-body">
				<form class="mb-4" action="ForgotPasswordServlet" method="post">
					<div class="mb-3 d-flex align-items-center">
						<label for="email" class="form-label me-2 text-nowrap">Email:</label>
						<input type="text" class="form-control" id="email" name="email" placeholder="Email de votre compte"/>
					</div>
					<div class="row mb-3">
						<div class="col">
							<div class="d-flex justify-content-center">
								<button type="submit" class="btn btn-primary">Récupérer mon mot de passe</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
