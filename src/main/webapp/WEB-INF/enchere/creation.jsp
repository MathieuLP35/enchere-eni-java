<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <title>Créer une enchère</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.min.js"></script>
    <style>
        /* Styles personnalisés */
        body {
            background-color: #f8f9fa;
        }
        .product-details {
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .product-label {
            font-weight: bold;
        }
        .enlarge-image {
            max-width: 100%; /* Permet à l'image de s'agrandir pour remplir la colonne */
            height: auto;
        }        
    </style>
</head>
<body>
    <jsp:include page="../headerBanner.jsp"/>
    <div class="container mt-5">
        <h1 class="text-center">Détail de l'Enchère</h1>

        <div class="row">
            <div class="col-md-4">
                <img src="https://picsum.photos/1000?random=2" alt="Image de l'enchère" class="img-fluid enlarge-image">
            </div>
            <div class="col-md-8">
                <!-- Formulaire à droite -->
                <div class="product-details">
                    <h2 class="text-center">${nomArticle}</h2>

                    <div class="mb-3">
                        <p class="product-label">Description :</p>
                        <p>${description}</p>
                    </div>

                    <div class="mb-3">
                        <p class="product-label">Catégorie :</p>
                        <p>${categorie}</p>
                    </div>

                    <div class="mb-3">
                        <p class="product-label">Meilleure Offre :</p>
                        <p>${prixVente}</p>
                    </div>

                    <div class="mb-3">
                        <p class="product-label">Mise à Prix :</p>
                        <p>${prixInitial}</p>
                    </div>

                    <div class="mb-3">
                        <p class="product-label">Début de l'Enchère :</p>
                        <p>${debutEnchere}</p>
                    </div>
                    
                    <div class="mb-3">
                        <p class="product-label">Fin de l'Enchère :</p>
                        <p>${finEnchere}</p>
                    </div>

                    <div class="mb-3">
                        <p class="product-label">Retrait :</p>
                        <p>${lieuRetraitRue} ${lieuRetraitCP} ${lieuRetraitVille}</p>
                    </div>
                    
                    <div class="mb-3 d-none">
                    	 <input type="number" class="form-control" name="${idArticle}" id="${idArticle}">
                    </div>                    

                    <div class="mb-3 form-outline">
                        <form action="FaireEnchereServlet" method="post">
	                        <p class="product-label font-weight-bold">Proposition de Prix :</p>
	                        <input type="number" class="form-control" name="encherir" id="encherir">
	                        <button type="submit" name="BTN_SAVE" class="btn btn-primary">Enchérir</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>