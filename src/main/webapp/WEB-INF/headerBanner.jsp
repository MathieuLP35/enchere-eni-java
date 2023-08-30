<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
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
        </ul>
    </div>
</nav>

