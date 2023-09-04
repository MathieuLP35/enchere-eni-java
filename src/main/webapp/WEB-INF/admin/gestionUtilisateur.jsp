<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Administration - Gestion utilisateur</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../headerBanner.jsp"/>
    <div class="container mt-5">
    	${message}
        <table class="table mt-5">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Pseudo</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Prénom</th>
                    <th scope="col">Email</th>
                    <th scope="col">Téléphone</th>
                    <th scope="col">Adresse</th>
                    <th scope="col">Crédit</th>
                    <th scope="col">Administrateur</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td>${u.noUtilisateur}</td>
                        <td>${u.pseudo}</td>
                        <td>${u.nom}</td>
                        <td>${u.prenom}</td>
                        <td>${u.email}</td>
                        <td>${u.telephone}</td>
                        <td>${u.rue}, ${u.codePostal} ${u.ville}</td>
                        <td>${u.credit}</td>
                        <td>
                        	<c:if test="${u.administrateur}"><span class="text-success">Oui</span></c:if>
                        	<c:if test="${!u.administrateur}"><span class="text-danger">Non</span></c:if>
						</td>
                        <td>
							<form action="GestionUtilisateurServlet" method="post" class="d-flex flex-nowrap">
								<input type="hidden" name="idUser" value="${u.noUtilisateur}" />
								<c:if test="${u.isActive}"><button href="#" class="btn btn-warning mx-1" name="BT_DESACTIVATE">Désactiver</button></c:if>
								<c:if test="${!u.isActive}"><button href="#" class="btn btn-primary mx-1" name="BT_DESACTIVATE">Activer</button></c:if>
	                            <button href="#" class="btn btn-danger mx-1" name="BT_REMOVE">Supprimer</button>
							</form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>