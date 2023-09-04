<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Administration - Gestion catégorie</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body class="bg-light">
	<jsp:include page="../headerBanner.jsp"/>
    <div class="container mt-5 bg-white rounded p-4 shadow">
    	${message}
		<div class="accordion accordion-flush border" id="accordionFlushExample">
		  <div class="accordion-item">
		    <h2 class="accordion-header">
		      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
		        Ajouter une catégorie
		      </button>
		    </h2>
		    <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
		      	<div class="accordion-body">
					<form action="GestionCategorieServlet" method="post" class="d-flex flex-nowrap gap-1">
						<input type="text" class="form-control" name="libelleCategorie" />
			            <button class="btn btn-success mx-1" name="BT_ADD">Ajouter</button>
					</form>
				</div>
		    </div>
		  </div>
		</div>
        <table class="table mt-5">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Libelle</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${categories}" var="c">
                    <tr>
						<form action="GestionCategorieServlet" method="post" class="d-flex flex-nowrap">
	                        <td>${c.noCategorie}</td>
	                        <td><input type="text" class="form-control" name="libelleCategorie" value="${c.libelle}" /></td>
	                        <td>
									<input type="hidden" name="idCat" value="${c.noCategorie}" />
		                            <button href="#" class="btn btn-warning mx-1" name="BT_EDIT">Modifier</button>
		                            <button href="#" class="btn btn-danger mx-1" name="BT_REMOVE">Supprimer</button>
	                        </td>
						</form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>