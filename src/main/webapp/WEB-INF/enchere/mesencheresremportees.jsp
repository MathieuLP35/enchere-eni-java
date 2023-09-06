<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enchères remportées par l'utilisateur</title>

    <!-- Include Bootstrap 5 CSS -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
		crossorigin="anonymous">

</head>
<body class="bg-light">
	<jsp:include page="../headerBanner.jsp" />
    <div class="container mt-5 bg-white rounded p-4 shadow">
        <h1 class="mb-2">Enchères remportées par ${utilisateur.nom } ${utilisateur.prenom }</h1>
        <!-- Card deck to display won auctions -->
        <div class="card-deck mt-4">
			<c:forEach items="${lstEncheresRemportees }" var="er">
				<div class="card m-2">
	                <div class="card-body">
	                    <h5 class="card-title">Numéro de l'article : ${er.noArticle}</h5>
	                    <p class="card-text">Nom de l'article : ${er.nomArticle}</p>
	                    <p class="card-text">Enchère remportée au prix de ${er.prixVente} crédits</p>
	                </div>
	            </div>
			</c:forEach>
        </div>
    </div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
		
	</script>
</body>
</html>
