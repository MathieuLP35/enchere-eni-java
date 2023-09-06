<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <title>Créer une enchère</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
		crossorigin="anonymous">
</head>
<body class="bg-light">
    <jsp:include page="../headerBanner.jsp"/>
    <div class="container my-5">
        <h1 class="text-center mb-5">Détail de l'Enchère</h1>
        <div class="row">
            <div class="col-md-4">
                <img src="https://picsum.photos/1000?random=2" alt="Image de l'enchère" class="img-fluid enlarge-image">
            </div>
            <div class="col-md-8">
                <!-- Formulaire à droite -->
                <div class="product-details bg-white rounded p-4 shadow">
                    <h2 class="text-center">${nomArticle}</h2>

                    <div class="mb-3">
                        <p class="fw-bold">Description :</p>
                        <p>${description}</p>
                    </div>

                    <div class="mb-3">
                        <p class="fw-bold">Catégorie :</p>
                        <p>${categorie}</p>
                    </div>
                    
                    <form action="FaireEnchereServlet" method="post">
					<div class="mb-3">
					    <p class="product-label">Meilleure Offre :</p>
					    <input type="hidden" name="prixVente" value="${prixVente}" id="${prixVente}">
					    <p id="prixVente">${prixVente}</p>
					</div>

                    <div class="mb-3">
                        <p class="fw-bold">Mise à Prix :</p>
                        <p>${prixInitial}</p>
                    </div>

                    <div class="mb-3">
                        <p class="fw-bold">Début de l'Enchère :</p>
                        <p>${debutEnchere}</p>
                    </div>
                    
                    <div class="mb-3">
                        <p class="fw-bold">Fin de l'Enchère :</p>
                        <p>${finEnchere}</p>
                    </div>

                    <div class="mb-3">
                        <p class="fw-bold">Retrait :</p>
                        <p>${lieuRetraitRue} ${lieuRetraitCP} ${lieuRetraitVille}</p>
                    </div>
                    <div class="mb-3 d-none">
                    	<input type="number" class="form-control" name="idArticle" id="idArticle" value="${idArticle}">
                    </div>                    

                    <div class="mb-3 form-outline">
	                        <p class="product-label font-weight-bold">Proposition de Prix :</p>
	                        <input type="number" class="form-control" name="montant" id="montant">
	                        <button type="submit" name="BTN_SAVE" class="btn btn-primary">Enchérir</button>
                    </div>
                    </form>  
                    ${message}                  
                </div>
            </div>
        </div>
    </div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
	</script>
</body>
</html>