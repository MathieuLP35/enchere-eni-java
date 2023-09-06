<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body class="bg-light">
	<jsp:include page="../headerBanner.jsp" />
	<div class="container mt-5 bg-white rounded p-4 shadow d-flex aligns-items-center">
		<form action="AccueilServlet" method="post">
			<div class="row mt-4">
				<h1 class="mb-5">Listes des enchères</h1>
				<div class="col">
					<h4>Filtres:</h4>
					<input class="form-control" type="text" name="nomArticle"
						placeholder="Le nom de l'article contient" value="${nomArticle}" /> <label
						for="categorie" class="mt-3">Catégorie:</label> <select
						class="form-control" id="categorie" name="categorie">
						<option value="0">Toutes</option>
						<c:forEach items="${model.lstCategories}" var="categorie">
							<c:if test="${idCat != 0 && categorie.noCategorie == idCat}">
								<option value="${categorie.noCategorie}" selected>${categorie.libelle}</option>
							</c:if>
							<c:if test="${categorie.noCategorie != idCat}">
								<option value="${categorie.noCategorie}">${categorie.libelle}</option>
							</c:if>
						</c:forEach>
					</select>
					<c:if test="${user != null}">
						<div class="mt-3">
							<div class="row">
								<div class="col">
									<div class="form-check">
										<input type="radio" class="form-check-input" name="achats"
											id="achats" ${achats }> <label
											class="form-check-label" for="achats">Achats</label>
										<div class="ms-2">
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="achat1" name="achat1" disabled>
												<label class="form-check-label" for="achat1" >enchères
													ouvertes</label>
											</div>
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="achat2" name="achat2" disabled>
												<label class="form-check-label" for="achat2">mes
													enchères en cours</label>
											</div>
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="achat3" name="achat3" disabled>
												<label class="form-check-label" for="achat3">mes
													enchères remportées</label>
											</div>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="form-check">
										<input type="radio" class="form-check-input" name="ventes"
											id="ventes" ${ventes }> <label
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
													non débutées</label>
											</div>
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="vente3" name="vente3" disabled>
												<label class="form-check-label" for="vente3">ventes
													terminées</label>
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
			<c:forEach items="${model.lstArticlesVendus}" var="article">
				<div class="card p-2 col-sm-5 m-2">
					<div class="row">
						<div class="col">
							<img src="https://picsum.photos/100?random=2"
								class="card-img-top" alt="Photo de l'article">
						</div>
						<div class="col">
							<div class="card-body">
								<h5 class="card-title text-decoration-underline"></form><a href="FaireEnchereServlet/${article.noArticle}">${article.nomArticle }</a></h5>
								<p class="card-text">Prix :
									${article.prixVente}</p>
								<p class="card-text">D�but de l'ench�re :
									${article.dateDebutEnchere}</p>
								<p class="card-text">Fin de l'ench�re :
									${article.dateFinEnchere}</p>
								<p class="card-text">Vendeur : ${article.utilisateur.nom }
									${article.utilisateur.prenom}</p>
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
			
			ventes.checked = false;
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
			
			achats.checked = false
			achat1.checked = false;
			achat2.checked = false;
			achat3.checked = false;
		});
	</script>
</body>
</html>