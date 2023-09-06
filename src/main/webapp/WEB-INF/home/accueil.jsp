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
	<form action="AccueilServlet" method="post">
		<div class="container mt-5 bg-white rounded p-4 shadow">
			<h1>Listes des enchères</h1>
			<div class="row mt-4">
				<div class="col-md-6">
					<div class="mb-3">
						<label for="nomArticle" class="form-label">Le nom de
							l'article contient</label> <input type="text" class="form-control"
							id="nomArticle" name="nomArticle" value="${nomArticle}">
					</div>
				</div>
				<div class="col-md-6">
					<div class="mb-3">
						<label for="categorie" class="form-label">Catégorie:</label> <select
							class="form-select" id="categorie" name="categorie">
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
					</div>
				</div>
			</div>
			<c:if test="${user != null}">
				<div class="row">
					<div class="col-md-6">
						<fieldset class="mt-2 mb-4">
							<legend>Achat</legend>
							<div class="ms-2">
								<div class="form-check">
									<input type="checkbox" class="form-check-input" id="achat2"
										name="achat2"> <label class="form-check-label"
										for="achat2">Mes enchères en cours</label>
								</div>
								<div class="form-check">
									<input type="checkbox" class="form-check-input" id="achat3"
										name="achat3"> <label class="form-check-label"
										for="achat3">Mes enchères remportées</label>
								</div>
								<hr />
								<div class="form-check">
									<input type="checkbox" class="form-check-input" id="achat1"
										name="achat1"> <label class="form-check-label"
										for="achat1">Enchères ouvertes</label>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-md-6">
						<fieldset class="mt-2 mb-4">
							<legend>Vente</legend>
							<div class="ms-2">
								<div class="form-check">
									<input type="checkbox" class="form-check-input" id="vente1"
										name="vente1"> <label class="form-check-label"
										for="vente1">Mes ventes en cours</label>
								</div>
								<hr />
								<div class="form-check">
									<input type="checkbox" class="form-check-input" id="vente2"
										name="vente2"> <label class="form-check-label"
										for="vente2">Ventes non débutées</label>
								</div>
								<div class="form-check">
									<input type="checkbox" class="form-check-input" id="vente3"
										name="vente3"> <label class="form-check-label"
										for="vente3">Ventes terminées</label>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<button class="btn btn-primary mt-3 w-100">Rechercher</button>
				</div>
				<div class="col-md-1"></div>
			</div>
	</form>
	</div>
	<div class="container mt-5">
		<div class="row mt-5">
			<c:forEach items="${model.lstArticlesVendus}" var="article">
				<div class="col-md-3">
					<div class="card mb-3">
						<img src="https://picsum.photos/200?random=${article.noArticle}"
							class="card-img-top" alt="Photo de l'article">
						<div class="card-body">
							<h5 class="card-title bg-primary py-2 rounded-3 text-center px-2">
								<a class="link-light d-inline-block text-truncate articleCardTitle"
									href="${pageContext.request.contextPath}/FaireEnchereServlet?id=${article.noArticle}">${article.nomArticle}</a>
								<span class="text-white categoriePills d-block mt-1 mb-2">${article.categorie.libelle }</span>
							</h5>
							<hr />
							<p class="card-text">Prix : ${article.prixVente}</p>
							<p class="card-text">Fin de l'enchère :
								${article.dateFinEnchere}</p>
							<p class="card-text">Vendeur : ${article.utilisateur.nom}
								${article.utilisateur.prenom}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<c:if test="${model.message != ''}">
			<div class="alert alert-primary my-2" role="alert">${model.message}</div>
		</c:if>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous">
		
	</script>
</body>
</html>
