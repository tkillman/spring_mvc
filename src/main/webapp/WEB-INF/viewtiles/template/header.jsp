<%@ page contentType="text/html; charset=UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>
	<tiles:importAttribute name="menuList"/>
	<c:forEach var="menu" items="${menuList}">${menu} </c:forEach> 
	| 환영합니다!