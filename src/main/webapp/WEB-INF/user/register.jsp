<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchère - Inscription</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
		login:<input type="text" name="pseudo"/>
		nom:<input type="text" name="nom"/>
		prenom:<input type="text" name="prenom"/>
		email:<input type="text" name="email"/>
		téléphone:<input type="text" name="telephone"/>
		rue:<input type="text" name="rue"/>
		code postal:<input type="text" name="codePostal"/>
		ville:<input type="text" name="ville"/>
		mot de passe:<input type="text" name="motdepasse"/>
		<input type="submit" value=">>"/>
	</form>
	${message}
</body>
</html>