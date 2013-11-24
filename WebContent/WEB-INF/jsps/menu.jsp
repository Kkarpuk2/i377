<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homework Part 5</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" type="text/css">
</head>
<body>
	<ul id="menu">
		<li><a id="menu_Search" href="<c:url value="/search"/>">Otsi</a></li>
		<li><a id="menu_Add" href="<c:url value="/addForm"/>">Lisa</a></li>
		<li><a id="menu_ClearData" href="<c:url value="/admin/clearData"/>">Tühjenda</a></li>
	</ul>
	<br />
	<br />
	<br />
</body>
</html>