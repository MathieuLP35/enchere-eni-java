<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Vente Enchere</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body class="bg-light">
	<jsp:include page="../headerBanner.jsp"/>
	<div class="container mt-5 bg-white rounded p-4 shadow">
		<div class="col-md-4">
			
		</div>
		<div class="col-md-8">
			
			<h4>${model.message}</h4>
			
			<form action="VenteEnchereServlet" method="post" enctype='multipart/form-data'>
			  <div class="form-group row">
			    <label for="nomArticle" class="col-sm-2 col-form-label">Article</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" required id="nomArticle" name="nomArticle" value="">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="description" class="col-sm-2 col-form-label">Description</label>
			    <div class="col-sm-10">
			      <input type="text" id="description" required class="form-control" name="description">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="categorie" class="col-sm-2 col-form-label">Catégorie</label>
			    <div class="col-sm-10">
			      <select id="categorie" class="form-control" required name="categorie">
                	<c:forEach items="${model.lstCategories}" var="categorie">
                    	<option value="${categorie.noCategorie}">${categorie.libelle}</option>
                    </c:forEach>
			      </select>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="file" class="col-sm-2 col-form-label">Photo</label>
			    <div class="col-sm-10">
			      <input type="file" required class="form-control" id="file" name="file">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="miseAPrix" class="col-sm-2 col-form-label">Mise à prix</label>
			    <div class="col-sm-10">
			      <input type="number" required class="form-control" id="miseAPrix" name="miseAPrix" value="">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="dateDebutEnchere" class="col-sm-2 col-form-label">Date de l'enchere</label>
			    <div class="col-sm-10">
			      <input type="date" required class="form-control" id="dateDebutEnchere" name="dateDebutEnchere">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="dateFinEnchere" class="col-sm-2 col-form-label">Fin de l'enchere</label>
			    <div class="col-sm-10">
			      <input type="date" required class="form-control" id="dateFinEnchere" name="dateFinEnchere" value="">
			    </div>
			  </div>
			  
			  <fieldset>
    			<legend>Retrait</legend>
    		  	
    		  	<div class="form-group row">
				  <label for="rue" class="col-sm-2 col-form-label">Rue</label>
				  <div class="col-sm-10">
				     <input type="text" class="form-control" id="rue" value="${model.lieuRetrait.rue}">
				  </div>
			 	</div>
    		  	<div class="form-group row">
				  <label for="codePostal" class="col-sm-2 col-form-label">Code Postal</label>
				  <div class="col-sm-10">
				     <input type="text" class="form-control" id="codePostal" value="${model.lieuRetrait.codePostal}">
				  </div>
			 	</div>
			 	<div class="form-group row">
				  <label for="ville" class="col-sm-2 col-form-label">Ville</label>
				  <div class="col-sm-10">
				     <input type="text" class="form-control" id="ville" value="${model.lieuRetrait.ville}">
				  </div>
			 	</div>
    		  
    		  </fieldset>
    		  <div class="form-group row">
			    <div class="btn-group">
			    	<button class="btn btn-primary">Enregistrer</button>
			    	<button class="btn btn-warning">Annuler</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</body>
</html>