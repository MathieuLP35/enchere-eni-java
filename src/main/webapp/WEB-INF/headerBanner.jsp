<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<a href="${pageContext.request.contextPath}/AccueilServlet" class="vintage-button text-decoration-none text-dark fs-2">ENI-Enchère</a>

<c:if test="${user == null}">
<a href="${pageContext.request.contextPath}/RegisterServlet" class="text-decoration-none text-dark">S'inscrire</a>
<a href="${pageContext.request.contextPath}/LoginServlet" class="text-decoration-none text-dark">Se connecter</a>
</c:if>

