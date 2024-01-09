<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ma Boutique Vintage</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            display: flex;
            flex-direction: column;
        }
        #sidebar {
            width: 200px;
            background-color: #222;
            padding: 10px;
            box-sizing: border-box;
            position: fixed; /* Makes the sidebar stay in place */
            top: 0; /* Align to the top */
            bottom: 0; /* Stretch to the bottom */
        }
        #main-content {
            margin-left: 300px; /* Width of the sidebar */
            flex: 1; /* Take up remaining space */
        }
        .header {
            background: url('header-image.jpg') no-repeat center center;
            background-size: cover; /* Ensure it covers the whole area */
            text-align: center;
            padding: 50px 0;
        }
        .menu-item {
            color: #fff;
            text-decoration: none;
            display: block;
            margin-bottom: 10px;
        }
        /* Add additional styles for fonts, colors, etc. */
    </style>
</head>
<body>
    <div id="sidebar">
        <h2>Menu</h2>
        <a href="#" class="menu-item">Accueil</a>
        <a href="categorie" class="menu-item">Catégories</a>
        <a href="#" class="menu-item">Votre Panier</a>
    </div>
    <div id="main-content">
        <!-- The header is now part of the main content to ensure proper layout -->
        <div class="header">
            <h1>ma boutique</h1>
        </div>
        <h2>Accueil</h2>
        <p>Bienvenue dans ma boutique Vintage</p>
    </div>
</body>
</html>