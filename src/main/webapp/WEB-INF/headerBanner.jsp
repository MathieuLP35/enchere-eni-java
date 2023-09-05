<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<style>

    body {
        background-color: #f8f9fa;         
    }

    .container {
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
        margin-top: 20px;
    }

    .form-group {
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
    }

    input[type="text"],
    input[type="email"],
    input[type="tel"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .btn-primary {
        background-color: #007bff;
        border: none;
    }

    .btn-primary:hover {
        background-color: #0056b3;
    }
</style>    
    
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
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
						<a class="nav-link">Bienvenue ${user.prenom} ${user.nom }</a>
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
	                     <a class="nav-link" href="${pageContext.request.contextPath}/LoginServlet">Enchère</a>
	                </li>
	                <li>
	                     <a class="nav-link" href="${pageContext.request.contextPath}/VenteEnchereServlet">Vendre un article</a>
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

