<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="bootstrap_css" value="/webjars/bootstrap/4.6.0-1/css/bootstrap.min.css" />
<c:url var="bootstrap_navbar_css" value="https://bootswatch.com/4/yeti/bootstrap.css" />
<c:url var="bootstrap_js" value="/webjars/bootstrap/4.6.0-1/js/bootstrap.min.js" />
<c:url var="jquery_js" value="/webjars/jquery/3.5.1/jquery.min.js" />

<html>
<head>
    <meta charset="UTF-8">
    <title>Kontact</title>
    <link rel="stylesheet" href="${bootstrap_css}">
    <link rel="stylesheet" href="${bootstrap_navbar_css}">
    <script src="${jquery_js}"></script>
    <script src="${bootstrap_js}"></script>
</head>
<body>
<%@ include file="navbar.jsp"%>