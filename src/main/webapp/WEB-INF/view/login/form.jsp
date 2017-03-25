<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>로그인</title>
</head>
<body>

<!-- 소스 코드를 꼭 보도록 하자. -->
<!-- 3가지 경우, 아무것도 안 입력, 아이디랑 비밀번호 입력했는데 다른 경우, 같은경우 -->
	<form:form commandName="loginCommand"><!-- form:form태그는 기본이 method=post방식 -->
	
		<form:errors element="div" />
		아이디: <form:input path="userId" /> <!-- path에 적으면 id와 name 둘다 지정해준다. -->
		<form:errors path="userId"  element="div"/>
		<br />
		암호: <form:password path="password" showPassword="false" /> <!-- id,name,type=password -->
		<form:errors path="password" element="div"/>
		<br />
		<input type="submit" />
	</form:form>
	
</body>
</html>
