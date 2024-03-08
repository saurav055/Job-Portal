<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<style type="text/css">
.back-img {
	background: url("img/j2.jpg");
	height: 80vh;
	width: 100x;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="cointainer-fluid back-img">
		<div class="text-center">
			<h1 class="text-white p-4">Welcome Admin</h1>
		</div>
	</div>
</body>
<c:if test="${userobj.role ne 'admin' }">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
</html>