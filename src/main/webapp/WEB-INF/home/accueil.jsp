<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body class="bg-light">
	<jsp:include page="../headerBanner.jsp" />
	<div class="container mt-5 bg-white rounded p-4 shadow">
		<div class="row">
			<div class="col text-center">
				<h1>Liste des ench�res</h1>
			</div>
		</div>
		<form action="AccueilServlet" method="post">
			<div class="row mt-4">
				<div class="col">
					<h4>Filtres:</h4>
					<input class="form-control" type="text" name="nomArticle"
						placeholder="Le nom de l'article contient" /> <label
						for="categorie" class="mt-3">Cat�gorie:</label> <select
						class="form-control" id="categorie" name="categorie">
						<option value="0">Toutes</option>
						<c:forEach items="${model.lstCategories}" var="categorie">
							<option value="${categorie.noCategorie}">${categorie.libelle}</option>
						</c:forEach>
					</select>
					<c:if test="${user != null}">
						<div class="mt-3">
							<div class="row">
								<div class="col">
									<div class="form-check">
										<input type="radio" class="form-check-input" name="choix"
											id="achats" value="achats"> <label
											class="form-check-label" for="achats">Achats</label>
										<div class="ms-2">
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="achat1" name="achat1" disabled>
												<label class="form-check-label" for="achat1">ench�res
													ouvertes</label>
											</div>
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="achat2" name="achat2" disabled>
												<label class="form-check-label" for="achat2">mes
													ench�res en cours</label>
											</div>
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="achat3" name="achat3" disabled>
												<label class="form-check-label" for="achat3">mes
													ench�res remport�es</label>
											</div>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="form-check">
										<input type="radio" class="form-check-input" name="choix"
											id="ventes" value="ventes"> <label
											class="form-check-label" for="ventes">Mes ventes</label>
										<div class="ms-2">
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="vente1" name="vente1" disabled>
												<label class="form-check-label" for="vente1">mes
													ventes en cours</label>
											</div>
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="vente2" name="vente2" disabled>
												<label class="form-check-label" for="vente2">ventes
													non d�but�es</label>
											</div>
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="vente3" name="vente3" disabled>
												<label class="form-check-label" for="vente3">ventes
													termin�es</label>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</div>
				<div class="col align-items-center">
					<button class="btn btn-primary mt-5 py-5 px-5 d-block mx-auto">Rechercher</button>
				</div>
		</form>
		<div class="row mt-5">
			<c:forEach items="${model.lstEncheres}" var="enchere">
				<div class="card p-2 col-sm-5 m-2">
					<div class="row">
						<div class="col">
							<img src="https://picsum.photos/100?random=2"
								class="card-img-top" alt="Photo de l'article">
						</div>
						<div class="col">
							<div class="card-body">
								<h5 class="card-title text-decoration-underline"></form><a href="FaireEnchereServlet/${enchere.noEnchere}">${enchere.articleVendu.nomArticle }</a></h5>
								<p class="card-text">Prix :
									${enchere.articleVendu.prixVente}</p>
								<p class="card-text">D�but de l'ench�re :
									${enchere.articleVendu.dateDebutEnchere}</p>
								<p class="card-text">Fin de l'ench�re :
									${enchere.articleVendu.dateFinEnchere}</p>
								<p class="card-text">Vendeur : ${enchere.user.nom }
									${enchere.user.prenom}</p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
		
	</script>
	<script>
		const achats = document.getElementById("achats");
		const achat1 = document.getElementById("achat1");
		const achat2 = document.getElementById("achat2");
		const achat3 = document.getElementById("achat3");
		
		const ventes = document.getElementById("ventes");
		const vente1 = document.getElementById("vente1");
		const vente2 = document.getElementById("vente2");
		const vente3 = document.getElementById("vente3");

		achats.addEventListener("click", function() {
			achat1.disabled = false;
			achat2.disabled = false;
			achat3.disabled = false;
			
			vente1.disabled = true;
			vente2.disabled = true;
			vente3.disabled = true;
			
			vente1.checked = false;
			vente2.checked = false;
			vente3.checked = false;
		});
		
		ventes.addEventListener("click", function() {
			vente1.disabled = false;
			vente2.disabled = false;
			vente3.disabled = false;
			
			achat1.disabled = true;
			achat2.disabled = true;
			achat3.disabled = true;
			
			achat1.checked = false;
			achat2.checked = false;
			achat3.checked = false;
		});
	</script>
</body>
</html>