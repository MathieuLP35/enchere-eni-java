<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Account</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../headerBanner.jsp"/>
    <div class="container mt-5 w-100 justify-content-center">
        <div class="row">
            <div class="col text-center">
                <h1>Liste des enchères</h1>
            </div>
        </div>
        ${user}
        <div class="row mt-4">
            <div class="col">
                <h4>Filtres:</h4>
                <input class="form-control" type="text" placeholder="Le nom de l'article contient" />
                <label for="categorie" class="mt-3">Catégorie:</label>
                <select class="form-control" id="categorie">
                	<option>Toutes</option>
                	<c:forEach items="${model.lstCategories}" var="categorie">
                    	<option value="${categorie.noCategorie}">${categorie.libelle}</option>
                    </c:forEach>
                </select>
                <div class="mt-3">
                    <div class="row">
					    <div class="col">
							<div class="form-check">
		                        <input type="radio" class="form-check-input" name="choix" id="achats" value="achats">
		                        <label class="form-check-label" for="achats">Achats</label>
		                        <div class="ms-2">
			                        <div class="form-check">
				                        <input type="checkbox" class="form-check-input" id="achat1">
				                        <label class="form-check-label" for="achat1">enchères ouvertes</label>
				                    </div>
				                    <div class="form-check">
				                        <input type="checkbox" class="form-check-input" id="achat2">
				                        <label class="form-check-label" for="achat2">mes enchères en cours</label>
				                    </div>
				                    <div class="form-check">
				                        <input type="checkbox" class="form-check-input" id="achat3">
				                        <label class="form-check-label" for="achat3">mes enchères remportées</label>
				                    </div>
			                    </div>
	                    	</div>
					    </div>
					    <div class="col">
							<div class="form-check">
		                        <input type="radio" class="form-check-input" name="choix" id="ventes" value="ventes">
		                        <label class="form-check-label" for="ventes">Mes ventes</label>
		                        <div class="ms-2">
			                        <div class="form-check">
				                        <input type="checkbox" class="form-check-input" id="vente1">
				                        <label class="form-check-label" for="vente1">mes ventes en cours</label>
				                    </div>
				                    <div class="form-check">
				                        <input type="checkbox" class="form-check-input" id="vente2">
				                        <label class="form-check-label" for="vente2">ventes non débutées</label>
				                    </div>
				                    <div class="form-check">
				                        <input type="checkbox" class="form-check-input" id="vente3">
				                        <label class="form-check-label" for="vente3">ventes terminées</label>
				                    </div>
			                    </div>
		                    </div>
					    </div>
					 </div>
                </div>
            </div>
            <div class="col align-items-center">
				<button class="btn btn-primary mt-5 py-5 px-5 d-block mx-auto">Rechercher</button>
            </div>
         ${model.lstEncheres}
			<div class="row mt-5">
				
                <div class="card p-2 col-sm-5 m-2">
                	<div class="row">
                		<div class="col">
		                    <img src="https://picsum.photos/100?random=2" class="card-img-top" alt="Photo de l'article">
                		</div>
                		<div class="col">
		                    <div class="card-body">
		                        <h5 class="card-title text-decoration-underline">Nom de l'article</h5>
		                        <p class="card-text">Prix : $XX.XX</p>
		                        <p class="card-text">Fin de l'enchère : Date</p>
		                        <p class="card-text">Vendeur : Nom du vendeur</p>
		                    </div>
                		</div>
                	</div>
                </div>
                <div class="card p-2 col-sm-5 m-2">
                	<div class="row">
                		<div class="col">
		                    <img src="https://picsum.photos/100?random=2" class="card-img-top" alt="Photo de l'article">
                		</div>
                		<div class="col">
		                    <div class="card-body">
		                        <h5 class="card-title text-decoration-underline">Nom de l'article</h5>
		                        <p class="card-text">Prix : $XX.XX</p>
		                        <p class="card-text">Fin de l'enchère : Date</p>
		                        <p class="card-text">Vendeur : Nom du vendeur</p>
		                    </div>
                		</div>
                	</div>
                </div>
	        </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>