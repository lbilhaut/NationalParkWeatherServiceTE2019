<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Weather Service</title>
<c:url value="/css/npgeek.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
</head>

<body>
<header>
<c:url value="/" var="homePageHref" />
<c:url value="/img/logo.png" var="logoSrc" />
<a href="${homePageHref}">
<img src="${logoSrc}" alt="National Park logo" id="imageHeader" />
</a>
<h1>National Park Weather Service</h1>
</header>
<nav>
<h2>Explore the National Parks</h2>
<p> Use these state of the art web applications to learn more about America's beautiful National Parks and check out the weather! </p>
<ul>
<li><a href="home">Home</a></li>
<li><a href="survey">Survey</a></li>
<li><a href="favoriteParks">Favorite Parks</a></li>
</ul>
</nav>