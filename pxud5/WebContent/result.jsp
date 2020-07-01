<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI</title>
</head>
<body>
	<h2>BMI</h2>
	<p>
		Chi so BMI:
		<fmt:formatNumber type="number" maxFractionDigits = "2" value="${bmi}" />
	</p>
	<c:choose>
		<c:when test="${bmi < 18}">
			<p>Duoi chuan</p>
		</c:when>
		<c:when test="${bmi > 29}">
			<p>Thua can</p>
		</c:when>
		<c:otherwise>
			<p>OK</p>
		</c:otherwise>
	</c:choose>
</body>
</html>