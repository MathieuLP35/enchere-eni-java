<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
	<head>
		<link href="${pageContext.request.contextPath}/css/styles.css"rel="stylesheet">
	</head>
    <body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container mt-5 bg-white rounded p-4 shadow">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/AccueilServlet">ENI-Enchère</a>
			    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
			        <ul class="navbar-nav">
						<c:if test="${user == null}">
			                <li class="nav-item">
			                     <a class="nav-link" href="${pageContext.request.contextPath}/LoginServlet">Se connecter</a>
			                </li>
			                <li>
			                     <a class="nav-link" href="${pageContext.request.contextPath}/RegisterServlet">S'inscrire</a>
							</li>                
						</c:if>
						<c:if test="${user != null}">
							<li class="nav-item">
								<a class="nav-link">Bienvenue ${user.prenom} ${user.nom } (${user.credit} crédits)</a>
							</li>
							<c:if test="${user.administrateur}">
								<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
							      <ul class="navbar-nav">
							        <li class="nav-item dropdown">
							          <button class="btn btn-light dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
							            Administration
							          </button>
							          <ul class="dropdown-menu dropdown-menu-light">
							            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/GestionUtilisateurServlet">Gestion utilisateur</a></li>
							            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/GestionCategorieServlet">Gestion catégorie</a></li>
							          </ul>
							        </li>
							      </ul>
							    </div>
							</c:if>
			                <li class="nav-item">
			                     <a class="nav-link" href="${pageContext.request.contextPath}/MesEncheresRemporteesServlet">Enchères remportées</a>
			                </li>
			                <li>
			                     <a class="nav-link" href="${pageContext.request.contextPath}/VenteArticleServlet">Vendre un article</a>
							</li> 
							<li>
			                     <a class="nav-link" href="${pageContext.request.contextPath}/ProfilServlet">Mon Profil</a>
							</li>    
							<li>
			                     <a class="nav-link" href="${pageContext.request.contextPath}/LogoutServlet">Déconnexion</a>
							</li> 				            
						</c:if>
			        </ul>
			    </div>
			</div>
		</nav>
	</body>
</html>